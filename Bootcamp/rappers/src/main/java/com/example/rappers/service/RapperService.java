package com.example.rappers.service;

import com.example.rappers.entity.Rapper;
import com.example.rappers.repository.RapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RapperService {

    @Autowired
    private final RapperRepository rapperRepository;

    public RapperService(RapperRepository rapperRepository) {
        this.rapperRepository = rapperRepository;
    }

    public void createRapper(List<Rapper> rapper) {
        rapperRepository.saveAll(rapper);
    }

    public Rapper getRapper(Long id) {
        return rapperRepository.findById(id).orElse(null);
    }

    public List<Rapper> getRappers() {
        return rapperRepository.findAll();
    }

    public void deleteRapper(Long id) {
        rapperRepository.deleteById(id);
    }

    public void updateRapper(Long id, Rapper rapper) {
        Rapper rapperToUpdate = rapperRepository.findById(id).orElse(null);
        rapperToUpdate.setName(rapper.getName());
        rapperRepository.save(rapperToUpdate);
    }
}
