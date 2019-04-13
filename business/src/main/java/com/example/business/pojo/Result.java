package com.example.business.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {

    private boolean success;
    private Object data;
    private Object error;

    public static Result success() {
        Result result = new Result();
        result.success = true;
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.success = true;
        result.data = data;
        return result;
    }

    public static Result fail() {
        Result result = new Result();
        result.success = false;
        return result;
    }

    public static Result fail(Object error) {
        Result result = new Result();
        result.success = false;
        result.error = error;
        return result;
    }

}
