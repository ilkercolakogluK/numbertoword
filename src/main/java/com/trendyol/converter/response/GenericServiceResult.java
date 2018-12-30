package com.trendyol.converter.response;

import com.trendyol.converter.enums.ResultMapping;
import lombok.Data;

@Data
public class GenericServiceResult {

    private ResultMapping resultMapping;
    private Object responseData;

    public GenericServiceResult(ResultMapping resultMapping, Object responseData) {
        this.resultMapping = resultMapping;
        this.responseData = responseData;
    }

}