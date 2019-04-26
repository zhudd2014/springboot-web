package com.szxfd.springboot.web.controller;

import com.szxfd.springboot.web.entity.Result;
import com.szxfd.springboot.web.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseStatus
    public Result runtimeExceptionHandler(Exception e) {
        return ResultUtil.error(-1, e.getMessage());
    }
}
