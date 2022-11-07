package com.xiaowei.servicebase.exception;

import com.xiaowei.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R error(Exception e)
    {
        return R.fail().msg(e.getMessage());
    }
}
