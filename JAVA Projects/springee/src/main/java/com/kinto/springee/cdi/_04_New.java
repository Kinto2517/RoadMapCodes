package com.kinto.springee.cdi;


import com.kinto.springee.StudentDto;
import lombok.Getter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


@ApplicationScoped
@Named(value = "new")

public class _04_New {

    @Produces
    public String üretilenData(StudentDto studentDto){
            studentDto = StudentDto.builder().studentId(0L).studentName("hey").build();
            return studentDto.getStudentName();
    }

    @Getter
    @Inject
    private String tüketilenData;


}
