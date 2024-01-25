package br.com.fiap.tech.challenge.payment.launcher.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentUtil {

    public static String getPaymentCartCloseQueueName(Environment env) {
        return env.getProperty("aws.sqs.close-cart.name");
    }

    public static String getPaymentCreatedQueueName(Environment env) {
        return env.getProperty("aws.sqs.close-cart.name");
    }
}
