package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskiesFilterByYearDistilleryAge(@RequestParam(name="year", required = false) Integer year, @RequestParam(name="age", required = false) Integer age, @RequestParam(name="distillery", required = false) Long id) {
        if(year != null){
            return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        else if (age != null & id != null){
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryId(age,id), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{id}")
    public ResponseEntity getWhisky(@PathVariable Long id) {
        return new ResponseEntity<>(whiskyRepository.findById(id), HttpStatus.OK);
    }

}
