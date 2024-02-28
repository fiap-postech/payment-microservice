package br.com.fiap.tech.challenge.payment.launcher.rest;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.repository.PaymentRepository;
import br.com.fiap.tech.challenge.payment.launcher.config.TestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static br.com.fiap.tech.challenge.payment.launcher.containers.LocalStackContainers.localStackContainer;
import static br.com.fiap.tech.challenge.payment.launcher.containers.MongoDbContainers.localMongoDbContainer;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.PaymentConfirmRequestFixture.paymentConfirmRequestModel;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.PaymentEntityFixture.paymentEntityModel;
import static br.com.fiap.tech.challenge.payment.launcher.util.ConfigurationOverrides.overrideConfiguration;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({ "test" })
@Testcontainers
@DirtiesContext(classMode = AFTER_CLASS)
public class ConfirmPaymentIT {

    @Container
    protected static final MongoDBContainer DATABASE = localMongoDbContainer();

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @Autowired
    private PaymentRepository repository;


    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        overrideConfiguration(registry, DATABASE, LOCAL_STACK_CONTAINER);
    }

    @BeforeEach
    void init () {
        var paymentEntity = create(paymentEntityModel());
        repository.save(paymentEntity);
    }

    @Test
    void shouldConfirmPaymentOfPaymentGateway() {
        var paymentGatewayRequest = create(paymentConfirmRequestModel());

        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(paymentGatewayRequest)
            .when()
                .post("/payment/confirm")
            .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("schemas/PaymentResponseSchema.json"));
    }
}
