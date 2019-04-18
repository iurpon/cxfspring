package ru.trandefil.spring.feign;

import ru.trandefil.spring.dto.Result;

public class ResultResource {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
