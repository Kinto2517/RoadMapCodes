package com.example.spring3insta.repository;

import java.util.ArrayList;

import com.example.spring3insta.entity.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusRepo extends CrudRepository<Status, Integer>{

	Status save(Status save);
	ArrayList<Status> findAll();
}
