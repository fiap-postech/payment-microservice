package br.com.fiap.tech.challenge.payment.launcher.expectations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Model;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.JsonBody;

import static br.com.fiap.tech.challenge.payment.launcher.util.JsonUtil.asJsonString;
import static org.instancio.Instancio.create;
import static org.mockserver.model.HttpRequest.request;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetCustomerExpectations {
    public static <O> HttpRequest getCustomerSuccessExpectation(MockServerClient client, String id, Model<O> output) {
        var request = request()
                .withPath(String.format("/customer/%s", id))
                .withMethod("GET");

        var response = HttpResponse.response()
                .withStatusCode(200)
                .withBody(new JsonBody(asJsonString(create(output))));

        client.when(request).respond(response);

        return request;
    }

}
