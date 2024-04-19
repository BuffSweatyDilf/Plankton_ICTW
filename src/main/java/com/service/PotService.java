package com.service;

import com.model.Pot;
import com.repository.PotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PotService {

    @Autowired
    private PotRepository potRepository;

    public List<Pot> getAllPots() {
        return potRepository.findAll();
    }

    public Pot getPotById(Long id) {
        return potRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pot not found with id: " + id));
    }

    public Pot createPot(Pot pot) {
        return potRepository.save(pot);
    }

    public Pot updatePot(Long id, Pot updatedPot) {
        Pot pot = potRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pot not found with id: " + id));
        pot.setMaterial(updatedPot.getMaterial());
        pot.setSize(updatedPot.getSize());
        // Update other fields as needed
        return potRepository.save(pot);
    }

    public void deletePot(Long id) {
        potRepository.deleteById(id);
    }
}
