package com.kinto.springee.cdi;

//kapsam

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "scoped")
//@ApplicationScoped//tüm uyg boyunca
//@RequestScoped//1 istek boyunca sonra ölür
//@SessionScoped//logout olana kadar serializable implement
//@Dependent bukalemun
public class _00_Scoped {



}
