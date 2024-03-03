package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PaymentEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus.PAID;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentEntityFixture {

    public static Model<PaymentEntity> paymentEntityModel() {
        return Instancio.of(PaymentEntity.class)
                .generate(field(PaymentEntity::getUuid), gen -> gen.text().uuid())
                .set(field(PaymentEntity::getStatus), PAID)
                .set(field(PaymentEntity::getMethod), "MERCADO_PAGO")
                .set(field(PaymentEntity::getPurchaseId), "6efa43ba-6166-42dd-b46a-c5698922465a")
                .set(field(PaymentEntity::getPaymentUrl), "http://paga.eu/12345")
                .toModel();
    }
}
