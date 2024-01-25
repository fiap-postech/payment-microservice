package br.com.fiap.tech.challenge.adapter.presenter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PresenterFactory {

    public static PurchasePresenter purchasePresenter() {
        return new PurchasePresenterImpl();
    }
}
