package com.fizzbuzzcola.vendingmachine;

import java.util.List;

public class CoinReturnImpl implements CoinReturn {
    @Override
    public List<String> getContents() {
        return List.of("SLUG");
    }
}
