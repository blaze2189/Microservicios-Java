package com.bc.jlopez.infrastructure.inbound.controller;

import com.bc.jlopez.domain.model.Flight;
import com.bc.jlopez.domain.service.FrequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/frequence")
public class FrequenceController {

    private FrequenceService frequenceService;

    public FrequenceController(@Autowired FrequenceService frequenceService){
        this.frequenceService=frequenceService;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> findAllFrequence(){

        var frequenceList = frequenceService.findAllFrequence();

        return ResponseEntity.ofNullable(frequenceList);

    }

}
