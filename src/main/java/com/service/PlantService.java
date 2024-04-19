package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Plant;
import com.repository.PlantRepository;

@Service
public class PlantService {
	
    @Autowired
    private PlantRepository plantRepository;
    
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    
	public Plant updatePlant(Long id, Plant updatedPlant) {
		Plant plant = plantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));
        plant.setName(updatedPlant.getName());
        return plantRepository.save(plant);
	}
	

	public Plant getPlantById(Long id) {
		return plantRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Plant not found with id: " + id));
	}
	
	public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
	
	public Plant createPlant(Plant plant) {
        return plantRepository.save(plant);
    }

}
