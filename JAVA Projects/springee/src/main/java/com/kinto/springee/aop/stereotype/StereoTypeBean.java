package com.kinto.springee.aop.stereotype;

import lombok.*;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

@BenimStereotype
@Data @AllArgsConstructor @NoArgsConstructor
public class StereoTypeBean {

    private Long id;
    private String name;
    private String trade;


}
