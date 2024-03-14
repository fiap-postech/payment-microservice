package br.com.fiap.tech.challenge.adapter.driven.payment.gateway.service;

import br.com.fiap.tech.challenge.adapter.driven.payment.gateway.client.MarketPaymentClient;
import br.com.fiap.tech.challenge.adapter.driven.payment.gateway.request.CheckoutItem;
import br.com.fiap.tech.challenge.adapter.driven.payment.gateway.request.PaymentCheckoutRequest;
import br.com.fiap.tech.challenge.application.dto.MarketPaymentDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentMethod;
import br.com.fiap.tech.challenge.enterprise.valueobject.PurchaseItem;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Function;

import static java.lang.Double.parseDouble;
import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class PaidMarket implements PaymentGateway {

    private static String TOKEN = "Bearer TEST-2872653470214651-090218-855c012dc9b265fe038ddb59fee4caa1-264267342";
    private final BeanFactory factory;

    @Override
    public boolean accept(PaymentMethod method) {
        return PaymentMethod.PAID_MARKET.equals(method);
    }

    @Override
    @SuppressWarnings("squid:S112")
    public Optional<String> pay(Purchase purchase) {
        try {
            var id = purchase.uuid().toString();
            var checkoutItems = purchase.items().stream().map(buildCheckoutItems(id)).toList();
            var request = PaymentCheckoutRequest.builder().items(checkoutItems).build();
            var response = current().checkout(TOKEN, request);

            if (response.getStatusCode().is2xxSuccessful()) {
                return Optional.of(requireNonNull(response.getBody()).getSandbox_init_point());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<MarketPaymentDTO> getPurchaseUUID(String marketPaymentId) {
        try {
            var response = current().getPayment(TOKEN, marketPaymentId);

            if (response.getStatusCode().is2xxSuccessful()) {
                var paymentConfirmResponse = requireNonNull(response.getBody());

                var dto = MarketPaymentDTO.builder()
                        .purchaseUUID(paymentConfirmResponse.getAdditionalInfo().purchaseId())
                        .statusMarketPayment(paymentConfirmResponse.getStatus())
                        .build();

                return Optional.of(dto);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    private static Function<PurchaseItem, CheckoutItem> buildCheckoutItems(String id) {
        return purchaseItem -> CheckoutItem.builder()
                .id(id + "_" + purchaseItem.id())
                .title(purchaseItem.title())
                .description(purchaseItem.description())
                .picture_url("https://i.imgur.com/KvvHfza.jpeg")
                .category_id(purchaseItem.categoryId().name())
                .quantity(purchaseItem.quantity())
                .currency_id(purchaseItem.currencyId())
                .unit_price(BigDecimal.valueOf(parseDouble(purchaseItem.unitPrice()))).build();
    }

    private MarketPaymentClient current() {
        return factory.getBean(MarketPaymentClient.class);
    }
}
