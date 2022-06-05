package com.kinto.springee.aop.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class EvDecorator implements IEv{

    @Inject @Delegate
    private IEv iEv;
    @Override
    public String boyama(String data) {
        System.out.println("Decorator Burdaydı");
        String dataInformation = iEv.boyama(data);
        if (dataInformation.equals("nope")){
            
        }
        return null;
    }
}
