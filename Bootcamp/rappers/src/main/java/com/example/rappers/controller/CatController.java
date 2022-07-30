package com.example.rappers.controller;

import com.example.rappers.entity.Cat;
import com.example.rappers.repository.CatRepository;
import com.example.rappers.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {


    @Autowired
    private CatService catService;

    private CatController(CatService catService) {
        this.catService = catService;
    }


    @GetMapping
    public List<Cat> getCats() {
        return catService.getCats();
    }

    @PostMapping
    public ResponseEntity<List<Cat>> createCat(@RequestBody List<Cat> cat) {
        catService.createCat(cat);
        return ResponseEntity.status(HttpStatus.CREATED).body(cat);
    }

    @GetMapping("/{id}")
    public Cat getCat(@PathVariable Long id) {
        return catService.getCat(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cat> deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cat> updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        catService.updateCat(id, cat);
        return ResponseEntity.status(HttpStatus.OK).body(cat);
    }
}
