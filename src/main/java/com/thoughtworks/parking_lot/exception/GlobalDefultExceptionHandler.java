package com.thoughtworks.parking_lot.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GlobalDefultExceptionHandler {
    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Map<String,Object> myExceptionHandler(BusinessException businessException){
        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("code",businessException.getCode());
        map.put("message",businessException.getMessage());
        map.put("method",businessException.getMethod());
        return map;
    }
}
