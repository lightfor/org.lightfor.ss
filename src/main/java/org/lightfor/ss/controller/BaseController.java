package org.lightfor.ss.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础Controller
 * Created by Light on 2017/5/2.
 */
public class BaseController {

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    void setSessionAttr(String key, Object value){
        getRequest().getSession().setAttribute(key, value);
    }

    @SuppressWarnings("unchecked")
    <T> T getSessionAttr(String key) {
        return (T) getRequest().getSession().getAttribute(key);
    }

    @ExceptionHandler
    protected String handleError(HttpServletRequest request, Exception ex) {
        return "error";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    protected String handle404(){
        return "404";
    }
}
