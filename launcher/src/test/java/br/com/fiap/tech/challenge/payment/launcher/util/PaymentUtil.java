package br.com.fiap.tech.challenge.payment.launcher.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentUtil {

    public static String getPaymentPurchaseCreateQueueName(Environment env) {
        return env.getProperty("aws.sqs.purchase-create.name");
    }
}
