package com.controller;

import com.model.Greenhouse;
import com.service.GreenhouseService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greenhouses")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class GreenhouseController {

    @Autowired
    private GreenhouseService greenhouseService;

    @GetMapping
    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseService.getAllGreenhouses();
    }

    @GetMapping("/{id}")
    public Greenhouse getGreenhouseById(@PathVariable Long id) {
        return greenhouseService.getGreenhouseById(id);
    }

    @PostMapping
    public Greenhouse createGreenhouse(@RequestBody Greenhouse greenhouse) {
        return greenhouseService.createGreenhouse(greenhouse);
    }

    @PutMapping("/{id}")
    public Greenhouse updateGreenhouse(@PathVariable Long id, @RequestBody Greenhouse updatedGreenhouse) {
        return greenhouseService.updateGreenhouse(id, updatedGreenhouse);
    }

    @DeleteMapping("/{id}")
    public void deleteGreenhouse(@PathVariable Long id) {
        greenhouseService.deleteGreenhouse(id);
    }
}
