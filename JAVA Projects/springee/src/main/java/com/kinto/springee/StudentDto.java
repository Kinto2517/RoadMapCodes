package com.kinto.springee;

import lombok.*;

//data transfer object

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private Long studentId;
    private String studentName;
    private String studentSurname;



}
