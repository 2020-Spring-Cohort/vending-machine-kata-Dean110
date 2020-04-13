package com.fizzbuzzcola.vendingmachine;

import java.math.BigDecimal;

public interface CoinSlot {
    void acceptCoin(String coin);

    BigDecimal getBalance();
}
