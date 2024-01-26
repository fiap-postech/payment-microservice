package br.com.fiap.tech.challenge.adapter.driven.mongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static br.com.fiap.tech.challenge.adapter.driven.mongodb.config.EnvironmentProperties.DATABASE_HOST;
import static br.com.fiap.tech.challenge.adapter.driven.mongodb.config.EnvironmentProperties.DATABASE_NAME;
import static br.com.fiap.tech.challenge.adapter.driven.mongodb.config.EnvironmentProperties.DATABASE_PASSWORD;
import static br.com.fiap.tech.challenge.adapter.driven.mongodb.config.EnvironmentProperties.DATABASE_PORT;
import static br.com.fiap.tech.challenge.adapter.driven.mongodb.config.EnvironmentProperties.DATABASE_USERNAME;

@Profile({"dev", "hml", "prod"})
@Configuration
@RequiredArgsConstructor
public class DocumentDBConfiguration extends AbstractMongoClientConfiguration {

    private static final String CONNECTION_STRING_TEMPLATE = "mongodb://%s:%s@%s:%s/%s?directConnection=true&serverSelectionTimeoutMS=2000&tlsAllowInvalidHostnames=true&tls=true&retryWrites=false";

    @Value("${" + DATABASE_NAME + "}")
    private String databaseName;

    @Value("${" + DATABASE_HOST + "}")
    private String databaseHost;

    @Value("${" + DATABASE_PORT + "}")
    private String databasePort;

    @Value("${" + DATABASE_USERNAME + "}")
    private String databaseUsername;

    @Value("${" + DATABASE_PASSWORD + "}")
    private String databasePassword;

    private final SSLLoader sslLoader;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        super.configureClientSettings(builder);

        builder.applyConnectionString(new ConnectionString(getConnectionString()));
        builder.applyToSslSettings(ssl -> ssl.enabled(true).context(sslLoader.load()));
    }

    private String getConnectionString() {
        return String.format(
                CONNECTION_STRING_TEMPLATE,
                databaseUsername,
                databasePassword,
                databaseHost,
                databasePort,
                getDatabaseName()
        );
    }
}
