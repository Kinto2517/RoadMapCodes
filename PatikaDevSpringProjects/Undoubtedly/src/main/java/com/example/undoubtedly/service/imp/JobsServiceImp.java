package com.example.undoubtedly.service.imp;

import com.example.undoubtedly.model.Job;
import com.example.undoubtedly.repository.JobsRepository;
import com.example.undoubtedly.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsServiceImp implements JobsService {


    @Autowired
    private JobsRepository jobsRepository;

    @Override
    public void save(Job jobs) {
        jobsRepository.save(jobs);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobsRepository.findAll();
    }

    @Override
    public Job getByJobId(Long jobId) {
        return jobsRepository.findById(jobId).orElse(null);
    }

    @Override
    public void delete(Long jobId) {
        jobsRepository.deleteById(jobId);
    }

    @Override
    public List<Job> searchBy(String search) {
        return jobsRepository.findByJobTitleContainingOrJobTypeContainingOrJobSalaryContaining(search);
    }

    @Override
    public Page<Job> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        return jobsRepository.findAll(pageable);
    }

}
