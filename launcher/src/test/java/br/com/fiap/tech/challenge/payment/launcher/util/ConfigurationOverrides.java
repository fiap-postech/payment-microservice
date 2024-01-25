package br.com.fiap.tech.challenge.payment.launcher.util;

import io.restassured.RestAssured;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import static org.slf4j.LoggerFactory.getLogger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationOverrides {

    private static final Logger LOGGER = getLogger(ConfigurationOverrides.class);

    private static final int LOCAL_PORT = 8691;

    public static void overrideConfiguration(DynamicPropertyRegistry registry, MongoDBContainer database, GenericContainer<?> localstack) {
        localstack.followOutput(new Slf4jLogConsumer(LOGGER));

        System.setProperty("spring.data.mongodb.uri", database.getConnectionString());
        System.setProperty("spring.data.mongodb.database", "paymentdb");

        System.setProperty("server.port", String.valueOf(LOCAL_PORT));

        RestAssured.port = LOCAL_PORT;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}