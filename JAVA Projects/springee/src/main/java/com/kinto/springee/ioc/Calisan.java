package com.kinto.springee.ioc;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "ioc")
public class Calisan {


        @Inject
        private PatronInterface patronI;

        public Calisan(){
            //patronI = new Patron();
        }


        public String getData(String data){
            return patronI.surum("17");
        }
}
