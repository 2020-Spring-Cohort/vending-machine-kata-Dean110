package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;

public class CoinSlotImpl implements CoinSlot {
    private final CoinReturn coinReturn;
    private BigDecimal balance;

    public CoinSlotImpl(CoinReturn coinReturn) {
        this.coinReturn = coinReturn;
        balance = BigDecimal.ZERO;
    }

    @Override
    public void acceptCoin(String coin) {
        if (isValidCoin(coin)) {
            balance=balance.add(new BigDecimal("0.05"));
        } else {
            coinReturn.addCoin(coin);
        }
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    private boolean isValidCoin(String coin) {
        return coin.equals("NICKEL");
    }
}
