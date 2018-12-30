package com.trendyol.converter.service;

import com.trendyol.converter.exception.AmountOverflowException;
import com.trendyol.converter.exception.InvalidWordException;
import org.springframework.stereotype.Service;

@Service
public interface NumberWordConverterService {

    String convertNumberToWord(Long paramNumber) throws AmountOverflowException;

    Long convertWordToNumber(String word) throws InvalidWordException;

}
