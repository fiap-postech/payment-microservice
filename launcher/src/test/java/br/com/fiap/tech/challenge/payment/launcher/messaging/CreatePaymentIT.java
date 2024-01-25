package br.com.fiap.tech.challenge.payment.launcher.messaging;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.repository.PaymentRepository;
import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.payment.launcher.config.TestConfiguration;
import br.com.fiap.tech.challenge.payment.launcher.fixture.input.CartDTOFixture;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.instancio.Model;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.util.stream.Stream;

import static br.com.fiap.tech.challenge.payment.launcher.containers.LocalStackContainers.localStackContainer;
import static br.com.fiap.tech.challenge.payment.launcher.containers.MongoDbContainers.localMongoDbContainer;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.payment.launcher.util.ConfigurationOverrides.overrideConfiguration;
import static br.com.fiap.tech.challenge.payment.launcher.util.PaymentUtil.getPaymentCartCloseQueueName;
import static br.com.fiap.tech.challenge.payment.launcher.util.QueueUtil.sendMessage;
import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({ "test" })
@Testcontainers
@DirtiesContext(classMode = AFTER_CLASS)
public class CreatePaymentIT {

    private static final String PAYMENT_CREATED_QUEUE = "local-payment-created-queue";

    @Container
    protected static final MongoDBContainer DATABASE = localMongoDbContainer();

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @Autowired
    private Environment env;

    @Autowired
    private SqsTemplate sqsTemplate;

    @Autowired
    private PaymentRepository repository;

    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        overrideConfiguration(registry, DATABASE, LOCAL_STACK_CONTAINER);
    }

    @ParameterizedTest
    @MethodSource("getCreateOptions")
    void testCreatePayment(Model<CartDTO> model) {
        var message = create(model);

        sendMessage(sqsTemplate, getPaymentCartCloseQueueName(env), message);

        given()
                .await()
                .pollInterval(Duration.ofSeconds(2))
                .atMost(Duration.ofSeconds(20))
                .ignoreExceptions()
                .untilAsserted(() -> {
                    var paymentCreatedOpt = repository.findByCartUUID(message.getId());
                    assertTrue(paymentCreatedOpt.isPresent());

                    var messageProducerOpt = sqsTemplate.receive(PAYMENT_CREATED_QUEUE, String.class);
                    assertTrue(messageProducerOpt.isPresent());

                    var messageProducer = messageProducerOpt.get();
                    assertTrue(messageProducer.getPayload().contains(message.getId()));
                });
    }

    static Stream<Model<CartDTO>> getCreateOptions() {
        return Stream.of(
                CartDTOFixture.cartDTO()
        );
    }

}
