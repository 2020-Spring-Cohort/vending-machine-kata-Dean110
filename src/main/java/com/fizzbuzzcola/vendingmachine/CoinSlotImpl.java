package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class CoinSlotImpl implements CoinSlot {
    private final CoinReturn coinReturn;
    private BigDecimal balance;
    private Map<String, BigDecimal> coinValues;

    public CoinSlotImpl(CoinReturn coinReturn) {
        this.coinReturn = coinReturn;
        balance = BigDecimal.ZERO;
        setCoinValues();
    }

    private void setCoinValues() {
        coinValues = Map.of(
                "NICKEL", new BigDecimal("0.05"),
                "DIME", new BigDecimal("0.10")
        );
    }

    @Override
    public void acceptCoin(String coin) {
        if (isValidCoin(coin)) {
            balance=balance.add(coinValues.get(coin));
        } else {
            coinReturn.addCoin(coin);
        }
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    private boolean isValidCoin(String coin) {
        return coinValues.keySet().contains(coin);
    }
}
