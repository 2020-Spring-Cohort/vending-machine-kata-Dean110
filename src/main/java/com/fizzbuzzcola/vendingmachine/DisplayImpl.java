package com.fizzbuzzcola.vendingmachine;

public class DisplayImpl implements Display {
    public DisplayImpl(CoinSlot coinSlot) {
    }

    @Override
    public String getDisplayMessage() {
        return "INSERT COIN";
    }
}
