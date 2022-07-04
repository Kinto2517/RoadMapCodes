package com.example.onlinecvproject.controller;

import com.example.onlinecvproject.model.Cv;
import com.example.onlinecvproject.service.CvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CvController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private CvService cvService;

    @GetMapping("/jobs")
    public String viewHomePage(Model model) {
        return findPaginated(1,"jobType","asc",model);
    }



    @GetMapping("/jobs/search")
    public String search(@RequestParam("reportParam") String search, Model model) {
        List<Cv> cvs = cvService.searchBy(search);

        model.addAttribute("jobs", cvs);

        return "redirect:/jobs";
    }

    @GetMapping("/jobs/add")
    public String addUser(Model model) {
        logger.info("addUser()");
        Cv cv = new Cv();
        logger.info("user: " + cv);
        model.addAttribute("job", cv);
        return "addJobs";
    }

    @PostMapping("/jobs/add")
    public String addUser(@ModelAttribute("job") Cv cv, BindingResult result) {
        logger.info("addUser()");
        if (result.hasErrors()) {
            logger.info("addUser(): hasErrors");
            return "addJobs";
        }
        logger.info("job: " + cv);
        cvService.save(cv);
        return "redirect:/jobs";
    }

    @GetMapping("/jobs/delete")
    public String delete(@RequestParam("id") Long id) {
        logger.info("delete()");
        if (id == null) {
            logger.info("delete(): jobId is null");
            return "redirect:/jobs";
        }
        cvService.delete(id);
        return "redirect:/jobs";
    }

    //page/1?sortField=name&sortDir=asc
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir, Model model){

        int pageSize = 5;
        Page<Cv> page = cvService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Cv> jobsList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("jobsList", jobsList);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");

        return "jobs";
    }

}
