package com.fizzbuzzcola.vendingmachine;

public class CoinSlotImpl implements CoinSlot {
    private final CoinReturn coinReturn;

    public CoinSlotImpl(CoinReturn coinReturn) {
        this.coinReturn = coinReturn;
    }

    @Override
    public void acceptCoin(String coin) {
        coinReturn.addCoin(coin);
    }
}
