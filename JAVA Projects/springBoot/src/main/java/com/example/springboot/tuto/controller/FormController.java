package com.example.springboot.tuto.controller;


import com.example.springboot.tuto.dto.TeacherDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class FormController {

    @GetMapping("/form")
    public String getForm(Model model){

        model.addAttribute("cv_teacher", new TeacherDto());
        return "form_post/formvalidation";
    }

    @PostMapping("/form")
    public String postForm(@Valid @ModelAttribute("cv_teacher") TeacherDto teacherDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Logger.getLogger(FormController.class.getName()).info("hata");
            System.out.println("hata");
            return "form_post/formvalidation";
        }

        Logger.getLogger(FormController.class.getName()).info("Başarılı: " + teacherDto);
        return "form_post/success";
    }

}
