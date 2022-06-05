package com.kinto.springee.aop.stereotype;


import lombok.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import java.lang.annotation.*;

@Stereotype
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Named
@ApplicationScoped
public @interface BenimStereotype {

}
