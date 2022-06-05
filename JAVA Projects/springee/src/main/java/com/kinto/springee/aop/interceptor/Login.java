package com.kinto.springee.aop.interceptor;

@InterceptorYolKesici
public class Login {

    public String isLoginMethod(String data){
        return "isLo" + data;
    }
}
