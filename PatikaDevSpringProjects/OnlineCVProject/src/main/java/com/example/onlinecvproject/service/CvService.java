package com.example.onlinecvproject.service;

import com.example.onlinecvproject.model.Cv;
import org.springframework.data.domain.Page;

import java.util.List;


public interface CvService {

    void save(Cv jobs);

    List<Cv> getAllJobs();

    Cv getByJobId(Long jobId);

    void delete(Long jobId);

    List<Cv> searchBy(String search);

    Page<Cv> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
}
