package com.controller;

import com.model.Sensor;
import com.service.SensorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
@SecurityRequirement(name = "bearerAuth")
@Validated
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable Long id) {
        return sensorService.getSensorById(id);
    }

    @PostMapping
    public Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }

    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable Long id, @RequestBody Sensor updatedSensor) {
        return sensorService.updateSensor(id, updatedSensor);
    }

    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
    }
}
