package com.zenyoga.naveen.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zenyoga.naveen.dto.response.Trainerdto;
import com.zenyoga.naveen.service.Trainerservice;

import java.util.List;

@RequestMapping("/traineradd")
@CrossOrigin(origins="*")
@Tag(name="Trainer ",description="Trainer details")
@RestController
public class Trainercontroller {

    private final Trainerservice trainerservice;

    public Trainercontroller(Trainerservice trainerservice) {
        this.trainerservice = trainerservice;
    }

    @Transactional
    @GetMapping
    public ResponseEntity<List<Trainerdto>> getAllTrainers() {
        List<Trainerdto> trainers = trainerservice.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }
 
    @Transactional
    @GetMapping("/{name}")
    public ResponseEntity<Trainerdto> getTrainerByName(@PathVariable String name) {
        Trainerdto trainer = trainerservice.getTrainerByName(name);
        if (trainer != null) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Trainerdto> createTrainer(@RequestBody Trainerdto trainer) {
        Trainerdto createdTrainer = trainerservice.createTrainer(trainer);
        return new ResponseEntity<>(createdTrainer, HttpStatus.CREATED);
    }
 
    @Transactional
    @PutMapping("/{name}")
    public ResponseEntity<Trainerdto> updateTrainerByName(@PathVariable String name, @RequestBody Trainerdto updatedTrainer) {
        Trainerdto updatedTrainerDto = trainerservice.updateTrainerByName(name, updatedTrainer);
        if (updatedTrainerDto != null) {
            return new ResponseEntity<>(updatedTrainerDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
   
    @Transactional
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteTrainerByName(@PathVariable String name) {
        trainerservice.deleteTrainerByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
