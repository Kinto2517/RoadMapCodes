package com.example.springboot.tuto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class TeacherDto {


    private Long teacherId;

    @NotEmpty(message = "boş isim olmaz")
    @Size(min = 1, max = 255)
    private String teacherName;


    @NotEmpty(message = "email obs olmasın")
    @Email(message = "email uygunsuz")
    @Min(value = 18,message = "yaş 18den büyük olsun")
    @Max(value = 45,message = "yaş 45den kücük olsun")
    private String teacherEmail;


}
