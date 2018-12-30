package com.trendyol.converter.controller;

import com.trendyol.converter.enums.ResultMapping;
import com.trendyol.converter.exception.AmountOverflowException;
import com.trendyol.converter.exception.InvalidWordException;
import com.trendyol.converter.response.GenericServiceResult;
import com.trendyol.converter.service.NumberWordConverterService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Api(value = "converter", description = "RESTful API to convert number<-->word amount of money.")
@RestController
@RequestMapping("converter")
public class ConverterController {

    private static final Logger LOG = LoggerFactory.getLogger(ConverterController.class);

    private final NumberWordConverterService numberWordConverterService;


    @Autowired
    public ConverterController(final @Qualifier(value = "englishNumberWordConverterServiceImpl")
                                       NumberWordConverterService numberWordConverterService) {
        this.numberWordConverterService = numberWordConverterService;
    }

    @PostMapping("/toword")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GenericServiceResult convertNTW(@RequestParam Long amountInNumber) {
        try {
            String word = numberWordConverterService.convertNumberToWord(amountInNumber);
            LOG.info(" Number converted to word successfully. ");
            return new GenericServiceResult(ResultMapping.SUCCESS, word);
        } catch (AmountOverflowException e) {
            return new GenericServiceResult(ResultMapping.AMOUNT_OVERFLOW_EXCEPTION, e.getMessage());
        }
    }

    @PostMapping("/tonumber")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GenericServiceResult convertWTN(@RequestParam String numberInWords) {
        try {
            Long number = numberWordConverterService.convertWordToNumber(numberInWords);
            LOG.info(" Number converted to number successfully. ");
            return new GenericServiceResult(ResultMapping.SUCCESS, number);
        } catch (InvalidWordException e) {
            return new GenericServiceResult(ResultMapping.INVALID_WORD_EXCEPTION, e.getMessage());
        }
    }

}
