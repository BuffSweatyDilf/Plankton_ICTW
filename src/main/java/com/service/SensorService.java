package com.service;

import com.model.Sensor;
import com.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Sensor getSensorById(Long id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found with id: " + id));
    }

    public Sensor createSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    public Sensor updateSensor(Long id, Sensor updatedSensor) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found with id: " + id));
        sensor.setName(updatedSensor.getName());
        sensor.setValue(updatedSensor.getValue());
        return sensorRepository.save(sensor);
    }

    public void deleteSensor(Long id) {
        sensorRepository.deleteById(id);
    }
}
