package br.com.fiap.tech.challenge.payment.launcher.containers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MongoDbContainers {

    public static MongoDBContainer localMongoDbContainer(){
        var container = new MongoDBContainer(DockerImageName.parse("mongo"))
                .withEnv("MONGO_INITDB_DATABASE","paymentdb")
                .withEnv("MONGO_INIT_ROOT_USERNAME","root")
                .withEnv("MONGO_INIT_ROOT_PASSWORD","admin");

        container.setPortBindings(List.of(
                "27017:27017"
        ));

        return container;
    }

}
