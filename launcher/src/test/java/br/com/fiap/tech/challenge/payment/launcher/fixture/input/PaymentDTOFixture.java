package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentMethod;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.math.BigDecimal;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentDTOFixture {

    public static Model<PaymentDTO> paymentDTO() {
        return Instancio.of(PaymentDTO.class)
                .set(field(PaymentDTO::getMethod), PaymentMethod.PAID_MARKET)
                .set(field(PaymentDTO::getStatus), PaymentStatus.CREATED)
                .set(field(PaymentDTO::getUrlPayment), "http://paga.eu/12345")
                .generate(field(PaymentDTO::getId), gen -> gen.text().uuid())
                .generate(field(PaymentDTO::getDate), gen -> gen.temporal().localDate())
                .generate(field(PaymentDTO::getAmount), gen -> gen.math().bigDecimal().min(BigDecimal.valueOf(20.00)))
                .toModel();
    }

}
