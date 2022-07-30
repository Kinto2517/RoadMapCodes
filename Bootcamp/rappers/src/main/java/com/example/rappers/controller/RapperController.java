package com.example.rappers.controller;

import com.example.rappers.entity.Rapper;
import com.example.rappers.service.RapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rappers")
public class RapperController {

    @Autowired
    private RapperService rapperService;

    public RapperController(RapperService rapperService) {
        this.rapperService = rapperService;
    }

    @GetMapping
    public List<Rapper> getRappers() {
        return rapperService.getRappers();
    }

    @PostMapping
    public ResponseEntity<List<Rapper>> createRapper(@RequestBody List<Rapper> rapper) {
        rapperService.createRapper(rapper);
        return ResponseEntity.status(HttpStatus.CREATED).body(rapper);
    }

    @GetMapping("/{id}")
    public Rapper getRapper(@PathVariable Long id) {
        return rapperService.getRapper(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rapper> deleteRapper(@PathVariable Long id) {
        rapperService.deleteRapper(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rapper> updateRapper(@PathVariable Long id, @RequestBody Rapper rapper) {
        rapperService.updateRapper(id, rapper);
        return ResponseEntity.status(HttpStatus.OK).body(rapper);
    }
}
