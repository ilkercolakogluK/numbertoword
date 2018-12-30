package com.trendyol.converter.response;

import com.trendyol.converter.util.NumberWordUtil;
import lombok.Data;

import static com.trendyol.converter.util.NWCConstants.*;

@Data
public class Number {

    private Long paramNumber;
    private String billion;
    private String million;
    private String thousand;
    private String hundred;
    private String decimal;

    public Number(Long paramNumber) {
        this.paramNumber = paramNumber;
    }

    /**
     * Provides obtaining all number in words after
     * all calculations are completed.
     *
     * @return
     */
    @Override
    public String toString() {
        String numberInWords = "";

        if (billion != null) {
            numberInWords += billion + BILLION_IN_WORD;
        }
        if (million != null) {
            numberInWords += million + MILLION_IN_WORD;
        }
        if (thousand != null) {
            numberInWords += thousand + THOUSANDS_IN_WORD;
        }
        return writeHundredsAndDecimal(numberInWords);
    }

    /**
     * This method seperate upper digits because of every digit can have this digit inside
     *
     * @param numberInWords
     * @return
     */
    private String writeHundredsAndDecimal(String numberInWords) {
        if (hundred != null) {
            numberInWords += hundred + HUNDREDS_IN_WORD;
        }
        if (decimal != null) {
            numberInWords += decimal;
        }
        if (numberInWords.length() == 0) {
            return null;
        }
        return numberInWords;
    }

    /**
     * append Billion's step's words
     * via finding division of BILLION
     *
     * @return
     */
    public Number appendWordsOfBillion() {
        long div = paramNumber / BILLION;
        Number billionNumber = calculate(div);
        billionNumber.setBillion(billionNumber.writeHundredsAndDecimal(""));
        clearHundredsAndDecimal();
        return billionNumber;
    }

    /**
     * append Million's step's words
     * via finding division of MILLION after remaining BILLION
     *
     * @return
     */
    public Number appendWordsOfMillion() {
        long div = paramNumber % BILLION / MILLION;
        Number millionNumber = calculate(div);
        millionNumber.setMillion(millionNumber.writeHundredsAndDecimal(""));
        clearHundredsAndDecimal();
        return millionNumber;
    }

    /**
     * append Thousand's step's words
     * via finding division of THOUSANDS after remaining MILLION
     *
     * @return
     */
    public Number appendWordsOfThousands() {
        long div = paramNumber % MILLION / THOUSANDS;
        Number thousandsNumber = calculate(div);
        thousandsNumber.setThousand(thousandsNumber.writeHundredsAndDecimal(""));
        clearHundredsAndDecimal();
        return thousandsNumber;
    }

    /**
     * append Hundred's step's words
     * via finding division of HUNDREDS after remaining THOUSANDS
     *
     * @return
     */
    public Number appendWordsOfHundreds() {
        long div = paramNumber % THOUSANDS / HUNDREDS;
        Number hundredsNumber = calculate(div);
        this.setHundred(hundredsNumber.writeHundredsAndDecimal(""));
        this.setDecimal(null);
        return this;
    }

    /**
     * append Decimal's step's words
     * via finding remaining of HUNDREDS
     *
     * @return
     */
    public Number appendWordsOfDecimal() {
        long div = paramNumber % HUNDREDS;
        calculate(div);
        return this;
    }

    /**
     * this method consist of 2 steps.
     * First step find hundreds if exist
     * Second step write correct numbers in word via util hashmap which includes 1-20
     *
     * @param number
     * @return
     */
    private Number calculate(long number) {
        if (number > NINETY_NINE) {
            long div = number / HUNDREDS;
            String oneWord = NumberWordUtil.getEnglishUnityNumbersAndWords().get(div);
            this.setHundred(oneWord);
            number = number % HUNDREDS;
        }
        if (number > TWENTY) {
            long remaining = number % TEN;
            number = number / TEN;
            String tenWord = NumberWordUtil.getEnglishDecimalNumbersAndWords().get(number);
            String oneWord = NumberWordUtil.getEnglishUnityNumbersAndWords().get(remaining);
            this.setDecimal(tenWord + " " + oneWord);
        } else {
            String word = NumberWordUtil.getEnglishUnityNumbersAndWords().get(number);
            this.setDecimal(word);
        }
        return this;
    }

    /**
     * this fields must be cleared not to influence next steps.
     */
    private void clearHundredsAndDecimal() {
        this.setHundred(null);
        this.setDecimal(null);
    }

}
