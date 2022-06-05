package com.kinto.springee.qualifier2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "qua")
public class Calisan {


        //@Inject

        /*@Inject
        @QualifierMultiple*/

        @Inject
        @QualifierMultiple(EFazlaSecenek.IKINCI)
        private PatronInterface patronI;

        public Calisan(){
            //patronI = new Patron();
        }


        public String getData(String data){
            return patronI.surum("17");
        }
}
