package com.trendyol.converter.service.impl;

import com.trendyol.converter.exception.AmountOverflowException;
import com.trendyol.converter.exception.InvalidWordException;
import com.trendyol.converter.response.Number;
import com.trendyol.converter.service.NumberWordConverterService;
import com.trendyol.converter.util.NWCConstants;
import org.springframework.stereotype.Service;

import static com.trendyol.converter.util.NWCConstants.HUNDREDS_IN_WORD;
import static com.trendyol.converter.util.NWCConstants.MAX_SIZE;
import static com.trendyol.converter.util.NumberWordUtil.getNumberInWordsForAdding;
import static com.trendyol.converter.util.NumberWordUtil.getNumberInWordsForMultipling;

@Service
public class EnglishNumberWordConverterServiceImpl implements NumberWordConverterService {

    /**
     * numbers are converted to words. From billion to decimal.
     *
     * @param paramNumber
     * @return
     * @throws AmountOverflowException
     */
    @Override
    public String convertNumberToWord(Long paramNumber) throws AmountOverflowException {
        if (paramNumber > MAX_SIZE) {
            throw new AmountOverflowException("Amount is overflowed ...");
        }
        if (paramNumber == 0) {
            return NWCConstants.ZERO;
        }
        Number number = new Number(paramNumber);
        number.appendWordsOfBillion()
                .appendWordsOfMillion()
                .appendWordsOfThousands()
                .appendWordsOfHundreds()
                .appendWordsOfDecimal();

        return number.toString();
    }

    /**
     * words are converted to number. From billion to decimal.
     *
     * @param words
     * @return
     * @throws InvalidWordException
     */
    @Override
    public Long convertWordToNumber(String words) throws InvalidWordException {

        long number = 0;
        long finalNumber = 0;

        if (words != null && words.length() > 0) {
            words = words.replaceAll("-", " ");
            words = words.toLowerCase().replaceAll(" and", " ");
            String[] splittedWords = words.trim().split("\\s+");

            // if invalid words is occured, throw InvalidWordException
            for (String word : splittedWords) {
                if (!getNumberInWordsForAdding().containsKey(word) &&
                        !getNumberInWordsForMultipling().containsKey(word)) {
                    throw new InvalidWordException("Invalid word found : " + word);
                }
            }
            // reach to final number with calculating all params of words
            // 0<number<100 ---> add to finalNumber
            // number>100  ----> multiple finalNumber
            for (String word : splittedWords) {
                if (getNumberInWordsForAdding().containsKey(word))
                    number += getNumberInWordsForAdding().get(word);
                else if (getNumberInWordsForMultipling().containsKey(word)) {
                    if (HUNDREDS_IN_WORD.trim().equalsIgnoreCase(word)) {
                        number *= getNumberInWordsForMultipling().get(word);
                    } else {
                        number *= getNumberInWordsForMultipling().get(word);
                        finalNumber += number;
                        number = 0;
                    }
                }

            }
            finalNumber += number;
        }

        return finalNumber;
    }

}
