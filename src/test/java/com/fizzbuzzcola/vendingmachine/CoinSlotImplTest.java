package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinSlotImplTest {

    public static final String INSERT_COIN_MESSAGE = "INSERT COIN";
    private CoinSlot underTest;
    private Display testDisplay;

    @BeforeEach
    public void setup(){
        underTest = new CoinSlotImpl();
        testDisplay = new DisplayImpl(underTest);
    }

    @Test
    public void withNoCoinsInSlotInsertCoinIsDisplayed() {
        String displayText = testDisplay.getDisplayMessage();
        assertThat(displayText).isEqualTo(INSERT_COIN_MESSAGE);
    }
}
