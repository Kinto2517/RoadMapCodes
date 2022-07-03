package com.example.undoubtedly.repository;

import com.example.undoubtedly.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Long> {

    @Query("SELECT r FROM Job r WHERE lower(r.jobTitle) like lower(concat('%',:search,'%')) "
            + "or lower(r.jobType) like lower(concat('%',:search,'%')) " +
            "or lower(r.jobSalary) like lower(concat('%',:search,'%')) ")
    List<Job> findByJobTitleContainingOrJobTypeContainingOrJobSalaryContaining(@Param("search") String search);
}
