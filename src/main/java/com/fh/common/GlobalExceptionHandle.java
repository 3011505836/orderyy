package com.fh.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ControllerAdvice
@RestController
public class GlobalExceptionHandle {

    //定义要捕捉的异常
    @ExceptionHandler(AjaxException.class)
    //@ResponseBody
    public ServerResponse handException2(AjaxException ex){
        ex.printStackTrace();
        return ServerResponse.error();

    }
    @ExceptionHandler(Exception.class)
   // @ResponseBody
    public ServerResponse handException(Exception ex){
        ex.printStackTrace();
        return ServerResponse.error();

    }


}
