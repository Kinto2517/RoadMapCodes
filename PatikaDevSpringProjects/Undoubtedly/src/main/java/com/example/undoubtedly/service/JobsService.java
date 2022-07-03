package com.example.undoubtedly.service;

import com.example.undoubtedly.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobsService {

    void save(Job jobs);

    List<Job> getAllJobs();

    Job getByJobId(Long jobId);

    void delete(Long jobId);

    List<Job> searchBy(String search);

    Page<Job> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
}
