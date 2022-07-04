package com.example.onlinecvproject.service.imp;


import com.example.onlinecvproject.model.Cv;
import com.example.onlinecvproject.repository.CvRepository;
import com.example.onlinecvproject.service.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvServiceImp implements CvService {


    @Autowired
    private CvRepository cvRepository;

    @Override
    public void save(Cv jobs) {
        cvRepository.save(jobs);
    }

    @Override
    public List<Cv> getAllJobs() {
        return cvRepository.findAll();
    }

    @Override
    public Cv getByJobId(Long jobId) {
        return cvRepository.findById(jobId).orElse(null);
    }

    @Override
    public void delete(Long jobId) {
        cvRepository.deleteById(jobId);
    }

    @Override
    public List<Cv> searchBy(String search) {
        return cvRepository.findByJobTitleContainingOrJobTypeContainingOrJobSalaryContaining(search);
    }

    @Override
    public Page<Cv> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {

        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);


        return this.cvRepository.findAll(pageable);
    }

}
