package com.controller;

import com.model.Plant;
import com.service.PlantService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class PlantController {

    @Autowired
    private PlantService plantService;

    @GetMapping
    public List<Plant> getAllPlants() {
        return plantService.getAllPlants();
    }

    @GetMapping("/{id}")
    public Plant getPlantById(@PathVariable Long id) {
        return plantService.getPlantById(id);
    }

    @PostMapping
    public Plant createPlant(@RequestBody Plant plant) {
        return plantService.createPlant(plant);
    }

    @PutMapping("/{id}")
    public Plant updatePlant(@PathVariable Long id, @RequestBody Plant updatedPlant) {
        return plantService.updatePlant(id, updatedPlant);
    }

    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable Long id) {
        plantService.deletePlant(id);
    }
}
