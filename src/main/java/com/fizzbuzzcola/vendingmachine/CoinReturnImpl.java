package com.fizzbuzzcola.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CoinReturnImpl implements CoinReturn {
    private List<String> contents;

    public CoinReturnImpl(){
        contents = new ArrayList<>();
    }

    @Override
    public List<String> getContents() {
        return contents;
    }

    @Override
    public void addCoin(String coin) {
        contents.add(coin);
    }
}
