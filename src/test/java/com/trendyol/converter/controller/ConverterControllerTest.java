package com.trendyol.converter.controller;

import com.trendyol.converter.exception.AmountOverflowException;
import com.trendyol.converter.exception.InvalidWordException;
import com.trendyol.converter.service.NumberWordConverterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ConverterControllerTest {

    private final String NUMBER_IN_WORDS = "two million(s) six hundred(s) eighty seven thousand(s) thirty seven";
    private final Long NUMBER = 2687037L;

    private MockMvc mockMvc;

    @InjectMocks
    private ConverterController converterController;

    @Mock
    @Qualifier("englishNumberWordConverterServiceImpl")
    private NumberWordConverterService numberWordConverterService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(converterController).build();
    }


    @Test
    public void convertNTW() throws Exception {
        when(numberWordConverterService.convertNumberToWord
                (NUMBER)).thenReturn(NUMBER_IN_WORDS);

        when(numberWordConverterService.convertNumberToWord
                (123456789123456789L)).thenThrow(new AmountOverflowException("Amount is overflowed ..."));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/converter/toword")
                .param("amountInNumber", "2687037");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertTrue(response.getContentAsString().contains(NUMBER_IN_WORDS));

        RequestBuilder requestBuilderError = MockMvcRequestBuilders
                .post("/converter/toword")
                .param("amountInNumber", "123456789123456789");
        MvcResult resultError = mockMvc.perform(requestBuilderError).andReturn();
        MockHttpServletResponse responseError = resultError.getResponse();
        assertEquals(HttpStatus.OK.value(), responseError.getStatus());
        assertTrue(responseError.getContentAsString().contains("Amount is overflowed ..."));
    }

    @Test
    public void convertWTN() throws Exception {
        when(numberWordConverterService.convertWordToNumber(NUMBER_IN_WORDS)).thenReturn(NUMBER);

        when(numberWordConverterService.convertWordToNumber("error input")).thenThrow(new InvalidWordException("Invalid word found ..."));

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/converter/tonumber")
                .param("numberInWords", NUMBER_IN_WORDS);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertTrue(response.getContentAsString().contains("2687037"));

        RequestBuilder requestBuilderError = MockMvcRequestBuilders
                .post("/converter/tonumber")
                .param("numberInWords", "error input");
        MvcResult resultError = mockMvc.perform(requestBuilderError).andReturn();
        MockHttpServletResponse responseError = resultError.getResponse();
        assertEquals(HttpStatus.OK.value(), responseError.getStatus());
        assertTrue(responseError.getContentAsString().contains("Invalid word found ..."));
    }
}