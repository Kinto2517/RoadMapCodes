package com.kinto.springee.iocsiz_disiz;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "calisan")
public class Calisan {
        private Patron patron;

        public Calisan(){
            patron = new Patron();
        }


        public String getData(String data){
            return patron.surum("17");
        }
}
