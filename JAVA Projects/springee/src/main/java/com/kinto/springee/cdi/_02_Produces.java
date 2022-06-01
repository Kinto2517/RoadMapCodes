package com.kinto.springee.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value="produces")
@ApplicationScoped
public class _02_Produces {

    @Produces
    public List<String> getList(){
        List<String> liste = new ArrayList<>();
        liste.add("Html5");
        liste.add("CSS");
        liste.add("JS");
        liste.add("React");
        liste.add("Angular");
        return liste;
    }
}
