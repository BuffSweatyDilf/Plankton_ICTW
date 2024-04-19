package com.service;

import com.model.Greenhouse;
import com.repository.GreenhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GreenhouseService {

    @Autowired
    private GreenhouseRepository greenhouseRepository;

    public List<Greenhouse> getAllGreenhouses() {
        return greenhouseRepository.findAll();
    }

    public Greenhouse getGreenhouseById(Long id) {
        return greenhouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greenhouse not found with id: " + id));
    }

    public Greenhouse createGreenhouse(Greenhouse greenhouse) {
        return greenhouseRepository.save(greenhouse);
    }

    public Greenhouse updateGreenhouse(Long id, Greenhouse updatedGreenhouse) {
        Greenhouse greenhouse = greenhouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greenhouse not found with id: " + id));
        greenhouse.setName(updatedGreenhouse.getName());
        greenhouse.setLocation(updatedGreenhouse.getLocation());
        return greenhouseRepository.save(greenhouse);
    }

    public void deleteGreenhouse(Long id) {
        greenhouseRepository.deleteById(id);
    }
}
