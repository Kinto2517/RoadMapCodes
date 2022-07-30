package com.example.rappers.service;

import com.example.rappers.entity.Cat;
import com.example.rappers.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    public void createCat(List<Cat> cat) {
        catRepository.saveAll(cat);
    }

    public Cat getCat(Long id) {
        return catRepository.findById(id).orElse(null);
    }

    public void updateCat(Long id, Cat cat) {
        Cat catToUpdate = catRepository.findById(id).orElse(null);
        catToUpdate.setName(cat.getName());
        catRepository.save(catToUpdate);
    }

    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}
