package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;

public class DisplayImpl implements Display{
    private final CoinSlot coinSlot;

    public DisplayImpl(CoinSlot coinSlot) {
        this.coinSlot = coinSlot;
    }

    @Override
    public String getDisplayMessage() {
        if (coinSlot.getBalance().equals(BigDecimal.ZERO)) {
            return "INSERT COIN";
        }
        return coinSlot.getBalance().toPlainString();
    }


}
