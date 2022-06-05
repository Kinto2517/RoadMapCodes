package com.kinto.springee.qualifier2;


@QualifierMultiple(EFazlaSecenek.BIRINCI)
public class Patron2 implements PatronInterface {

    @Override
    public String surum(String data){
        return "qua2     "+data;
    }
}
