package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;

public interface CoinSlot{
    String DIME = "DIME";
    String NICKEL = "NICKEL";
    String QUARTER = "QUARTER";

    void acceptCoin(String coin);

    BigDecimal getBalance();
}
