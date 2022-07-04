package com.example.onlinecvproject.repository;

import com.example.onlinecvproject.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> {

    @Query("SELECT r FROM Cv r WHERE lower(r.jobTitle) like lower(concat('%',:search,'%')) "
            + "or lower(r.jobType) like lower(concat('%',:search,'%')) " +
            "or lower(r.jobSalary) like lower(concat('%',:search,'%')) ")
    List<Cv> findByJobTitleContainingOrJobTypeContainingOrJobSalaryContaining(@Param("search") String search);
}
