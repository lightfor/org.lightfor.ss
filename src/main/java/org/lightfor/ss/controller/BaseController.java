package org.lightfor.ss.controller;

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
}
