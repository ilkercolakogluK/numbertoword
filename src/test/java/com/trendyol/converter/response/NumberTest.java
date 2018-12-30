package com.trendyol.converter.response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class NumberTest {

    private final String NUMBER_IN_WORDS = "four million(s) one hundred(s) twenty three thousand(s) five hundred(s) seventy four";
    private final Long NUMBER = 4123574L;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void toStringTest() {
        Number number = new Number(NUMBER);
        number.appendWordsOfBillion()
                .appendWordsOfMillion()
                .appendWordsOfThousands()
                .appendWordsOfHundreds()
                .appendWordsOfDecimal();
        assertEquals(NUMBER_IN_WORDS, number.toString());
    }

    @Test
    public void appendWordsOfBillionTest() {
        Number number = new Number(NUMBER);
        number.appendWordsOfBillion();
        assertEquals(null, number.toString());
    }

    @Test
    public void appendWordsOfMillionTest() {
        Number number = new Number(NUMBER);
        number.appendWordsOfMillion();
        assertEquals("four million(s)", number.toString().trim());
    }

    @Test
    public void appendWordsOfThousandsTest() {
        Number number = new Number(NUMBER);
        number.appendWordsOfThousands();
        assertEquals("one hundred(s) twenty three thousand(s)", number.toString().trim());
    }

    @Test
    public void appendWordsOfHundredsTest() {
        Number number = new Number(NUMBER);
        number.appendWordsOfHundreds();
        assertEquals("five hundred(s)", number.toString().trim());
    }

    @Test
    public void appendWordsOfDecimalTest() {
        Number number = new Number(NUMBER);
        number.appendWordsOfDecimal();
        assertEquals("seventy four", number.toString().trim());
    }

}