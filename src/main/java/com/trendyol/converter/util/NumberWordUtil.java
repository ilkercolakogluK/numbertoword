package com.trendyol.converter.util;

import java.util.HashMap;
import java.util.Map;

import static com.trendyol.converter.util.NWCConstants.*;

public class NumberWordUtil {

    private static Map<Long, String> englishUnityNumbersAndWordsMap;
    private static Map<Long, String> englishDecimalNumbersAndWordsMap;

    private static Map<String, Long> numberInWordsForAdding;
    private static Map<String, Long> numberInWordsForMultipling;

    public static Map<Long, String> getEnglishUnityNumbersAndWords() {
        englishUnityNumbersAndWordsMap = new HashMap<>();

        englishUnityNumbersAndWordsMap.put(0L, "");
        englishUnityNumbersAndWordsMap.put(1L, ONE_IN_WORD);
        englishUnityNumbersAndWordsMap.put(2L, TWO_IN_WORD);
        englishUnityNumbersAndWordsMap.put(3L, THREE_IN_WORD);
        englishUnityNumbersAndWordsMap.put(4L, FOUR_IN_WORD);
        englishUnityNumbersAndWordsMap.put(5L, FIVE_IN_WORD);
        englishUnityNumbersAndWordsMap.put(6L, SIX_IN_WORD);
        englishUnityNumbersAndWordsMap.put(7L, SEVEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(8L, EIGHT_IN_WORD);
        englishUnityNumbersAndWordsMap.put(9L, NINE_IN_WORD);
        englishUnityNumbersAndWordsMap.put(10L, TEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(11L, ELEVEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(12L, TWELVE_IN_WORD);
        englishUnityNumbersAndWordsMap.put(13L, THIRTEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(14L, FOURTEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(15L, FIFTEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(16L, SIXTEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(17L, SEVENTEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(18L, EIGHTEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(19L, NINETEEN_IN_WORD);
        englishUnityNumbersAndWordsMap.put(20L, TWENTY_IN_WORD);

        return englishUnityNumbersAndWordsMap;
    }

    public static Map<Long, String> getEnglishDecimalNumbersAndWords() {
        englishDecimalNumbersAndWordsMap = new HashMap<>();

        englishDecimalNumbersAndWordsMap.put(2L, TWENTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(3L, THIRTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(4L, FOURTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(5L, FIFTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(6L, SIXTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(7L, SEVENTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(8L, EIGHTY_IN_WORD);
        englishDecimalNumbersAndWordsMap.put(9L, NINETY_IN_WORD);

        return englishDecimalNumbersAndWordsMap;
    }

    public static Map<String, Long> getNumberInWordsForAdding() {
        numberInWordsForAdding = new HashMap<>();

        numberInWordsForAdding.put(ZERO_IN_WORD, 0L);
        numberInWordsForAdding.put(ONE_IN_WORD, 1L);
        numberInWordsForAdding.put(TWO_IN_WORD, 2L);
        numberInWordsForAdding.put(THREE_IN_WORD, 3L);
        numberInWordsForAdding.put(FOUR_IN_WORD, 4L);
        numberInWordsForAdding.put(FIVE_IN_WORD, 5L);
        numberInWordsForAdding.put(SIX_IN_WORD, 6L);
        numberInWordsForAdding.put(SEVEN_IN_WORD, 7L);
        numberInWordsForAdding.put(EIGHT_IN_WORD, 8L);
        numberInWordsForAdding.put(NINE_IN_WORD, 9L);
        numberInWordsForAdding.put(TEN_IN_WORD, 10L);
        numberInWordsForAdding.put(ELEVEN_IN_WORD, 11L);
        numberInWordsForAdding.put(TWELVE_IN_WORD, 12L);
        numberInWordsForAdding.put(THIRTEEN_IN_WORD, 13L);
        numberInWordsForAdding.put(FOURTEEN_IN_WORD, 14L);
        numberInWordsForAdding.put(FIFTEEN_IN_WORD, 15L);
        numberInWordsForAdding.put(SIXTEEN_IN_WORD, 16L);
        numberInWordsForAdding.put(SEVENTEEN_IN_WORD, 17L);
        numberInWordsForAdding.put(EIGHTEEN_IN_WORD, 18L);
        numberInWordsForAdding.put(NINETEEN_IN_WORD, 19L);
        numberInWordsForAdding.put(TWENTY_IN_WORD, 20L);
        numberInWordsForAdding.put(THIRTY_IN_WORD, 30L);
        numberInWordsForAdding.put(FOURTY_IN_WORD, 40L);
        numberInWordsForAdding.put(FIFTY_IN_WORD, 50L);
        numberInWordsForAdding.put(SIXTY_IN_WORD, 60L);
        numberInWordsForAdding.put(SEVENTY_IN_WORD, 70L);
        numberInWordsForAdding.put(EIGHTY_IN_WORD, 80L);
        numberInWordsForAdding.put(NINETY_IN_WORD, 90L);

        return numberInWordsForAdding;
    }

    public static Map<String, Long> getNumberInWordsForMultipling() {
        numberInWordsForMultipling = new HashMap<>();
        numberInWordsForMultipling.put(HUNDREDS_IN_WORD.trim(), HUNDREDS);
        numberInWordsForMultipling.put(THOUSANDS_IN_WORD.trim(), THOUSANDS);
        numberInWordsForMultipling.put(MILLION_IN_WORD.trim(), MILLION);
        numberInWordsForMultipling.put(BILLION_IN_WORD.trim(), BILLION);

        return numberInWordsForMultipling;
    }

}
