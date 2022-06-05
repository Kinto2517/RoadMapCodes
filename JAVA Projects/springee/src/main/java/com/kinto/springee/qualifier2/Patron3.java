package com.kinto.springee.qualifier2;


@QualifierMultiple(EFazlaSecenek.IKINCI)
public class Patron3 implements PatronInterface {

    @Override
    public String surum(String data){
        return "qua543     "+data;
    }
}
