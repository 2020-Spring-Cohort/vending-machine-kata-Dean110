package com.fizzbuzzcola.vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.fizzbuzzcola.vendingmachine.CoinSlot.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CoinSlotImplTest{

    public static final String INSERT_COIN_MESSAGE = "INSERT COIN";
    public static final String SLUG = "SLUG";
    private CoinSlot underTest;
    private Display testDisplay;
    private CoinReturn testCoinReturn;

    private void assertSingleCoinValuesAreDisplayed(String insertedCoin, String expectedDisplayText) {
        setup();
        underTest.acceptCoin(insertedCoin);
        String displayText = testDisplay.getDisplayMessage();
        assertThat(displayText).isEqualTo(expectedDisplayText);
    }

    @BeforeEach
    public void setup() {
        testCoinReturn = new CoinReturnImpl();
        underTest = new CoinSlotImpl(testCoinReturn);
        testDisplay = new DisplayImpl(underTest);
    }

    @Test
    public void withNoCoinsInSlotInsertCoinIsDisplayed() {
        String displayText = testDisplay.getDisplayMessage();
        assertThat(displayText).isEqualTo(INSERT_COIN_MESSAGE);
    }

    @Test
    public void invalidCoinIsReturnedToTheCoinReturn() {
        underTest.acceptCoin(SLUG);
        List<String> coinReturnContents = testCoinReturn.getContents();
        assertThat(coinReturnContents).containsExactly(SLUG);
    }

    @Test
    public void invalidCoinsAreReturnedToTheCoinReturn() {
        underTest.acceptCoin(SLUG);
        underTest.acceptCoin(SLUG);
        List<String> coinReturnContents = testCoinReturn.getContents();
        assertThat(coinReturnContents).containsExactlyInAnyOrder(SLUG, SLUG);
    }

    @Test
    public void coinValuesAreDisplayedWhenSingleCoinsAreInserted() {
        assertAll(
                ()-> assertSingleCoinValuesAreDisplayed(NICKEL, "0.05"),
                ()-> assertSingleCoinValuesAreDisplayed(DIME, "0.10"),
                ()-> assertSingleCoinValuesAreDisplayed(QUARTER, "0.25")
        );
    }

    @Test
    public void twoQuartersOneDimeAndOneNickelShouldDisplayCorrectTotal(){
        underTest.acceptCoin(QUARTER);
        underTest.acceptCoin(QUARTER);
        underTest.acceptCoin(NICKEL);
        underTest.acceptCoin(DIME);
        String displayText = testDisplay.getDisplayMessage();
        assertThat(displayText).isEqualTo("0.65");
    }
}
