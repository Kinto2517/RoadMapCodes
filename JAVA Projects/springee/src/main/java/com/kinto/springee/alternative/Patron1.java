package com.kinto.springee.alternative;


import javax.enterprise.inject.Alternative;

@Alternative
public class Patron1 implements PatronInterface {

    @Override
    public String surum(String data){
        return "patr1 "+data;
    }
}
