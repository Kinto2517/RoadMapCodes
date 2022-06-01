package com.kinto.springee.cdi;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named(value = "inject")
@ApplicationScoped
public class _03_Inject {


    @Inject
    private List<String> liste;

    public List<String> getListe() {
        return liste;
    }
}
