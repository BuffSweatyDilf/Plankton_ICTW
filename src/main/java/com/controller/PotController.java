package com.controller;

import com.model.Pot;
import com.service.PotService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pots")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class PotController {

    @Autowired
    private PotService potService;

    @GetMapping
    public List<Pot> getAllPots() {
        return potService.getAllPots();
    }

    @GetMapping("/{id}")
    public Pot getPotById(@PathVariable Long id) {
        return potService.getPotById(id);
    }

    @PostMapping
    public Pot createPot(@RequestBody Pot pot) {
        return potService.createPot(pot);
    }

    @PutMapping("/{id}")
    public Pot updatePot(@PathVariable Long id, @RequestBody Pot updatedPot) {
        return potService.updatePot(id, updatedPot);
    }

    @DeleteMapping("/{id}")
    public void deletePot(@PathVariable Long id) {
        potService.deletePot(id);
    }
}
