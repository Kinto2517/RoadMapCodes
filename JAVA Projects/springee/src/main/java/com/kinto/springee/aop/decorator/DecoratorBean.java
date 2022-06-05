package com.kinto.springee.aop.decorator;

import jdk.jfr.Name;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named(value = "db")
@ApplicationScoped
public class DecoratorBean {

    @Inject
    IEv iEv;

    public String beanMethod(){
        return iEv.boyama("nope");
    }
}
