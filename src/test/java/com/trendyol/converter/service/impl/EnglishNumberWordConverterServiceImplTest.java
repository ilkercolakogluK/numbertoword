package com.trendyol.converter.service.impl;

import com.trendyol.converter.exception.AmountOverflowException;
import com.trendyol.converter.exception.InvalidWordException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class EnglishNumberWordConverterServiceImplTest {

    private final String NUMBER_IN_WORDS = "two million(s) six hundred(s) eighty seven thousand(s) thirty seven";
    private final Long NUMBER = 2687037L;

    @InjectMocks
    private EnglishNumberWordConverterServiceImpl numberWordConverterService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void convertNumberToWord() throws AmountOverflowException {
        String result = numberWordConverterService.convertNumberToWord(NUMBER);
        assertEquals(result, NUMBER_IN_WORDS);
    }

    @Test
    public void convertWordToNumber() throws InvalidWordException {
        Long result = numberWordConverterService.convertWordToNumber(NUMBER_IN_WORDS);
        assertEquals(result, NUMBER);
    }
}