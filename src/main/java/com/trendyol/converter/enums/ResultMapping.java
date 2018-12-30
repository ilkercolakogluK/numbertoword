package com.trendyol.converter.enums;

public enum ResultMapping {

    SUCCESS(200, "success"),
    AMOUNT_OVERFLOW_EXCEPTION(410, "amount_overflow_exception"),
    INVALID_WORD_EXCEPTION(420, "amount_overflow_exception"),
    UNEXPECTED_ERROR(430, "unexpected_error");

    private int resultCode;
    private String resultMessage;

    ResultMapping(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

}
