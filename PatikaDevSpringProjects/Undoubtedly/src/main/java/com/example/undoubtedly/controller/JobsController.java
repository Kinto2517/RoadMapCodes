package com.example.undoubtedly.controller;

import com.example.undoubtedly.model.Job;
import com.example.undoubtedly.model.User;
import com.example.undoubtedly.service.JobsService;
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
public class JobsController {

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private JobsService jobsService;


    @GetMapping("/jobs")
    public String jobs(Model model) {

        model.addAttribute("jobs", jobsService.getAllJobs());
        return "jobs";
    }

    @GetMapping("/jobs/search")
    public String search(@RequestParam("reportParam") String search, Model model) {
        List<Job> jobs = jobsService.searchBy(search);

        model.addAttribute("jobs", jobs);

        return "jobs";
    }

    @GetMapping("/jobs/add")
    public String addUser(Model model) {
        logger.info("addUser()");
        Job job = new Job();
        logger.info("user: " + job);
        model.addAttribute("job", job);
        return "addJob";
    }

    @PostMapping("/jobs/add")
    public String addUser(@ModelAttribute("job") Job job, BindingResult result) {
        logger.info("addUser()");
        if (result.hasErrors()) {
            logger.info("addUser(): hasErrors");
            return "addJob";
        }
        logger.info("job: " + job);
        jobsService.save(job);
        return "redirect:/jobs";
    }

    @GetMapping("/jobs/delete")
    public String delete(@RequestParam("jobId") Long jobId) {
        logger.info("delete()");
        if (jobId == null) {
            logger.info("delete(): jobId is null");
            return "redirect:/jobs";
        }
        jobsService.delete(jobId);
        return "redirect:/jobs";
    }

    //page/1?sortField=name&sortDir=asc
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir, Model model){

        int pageSize = 5;
        Page<Job> page = jobsService.findPaginated(pageNo,pageSize,sortField,sortDir);
        List<Job> employeeList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", employeeList);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");

        return "jobs";
    }

}
