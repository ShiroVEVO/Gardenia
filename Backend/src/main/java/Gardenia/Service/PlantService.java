package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.PlantDTO;
import Gardenia.Model.Plant;
import Gardenia.Repository.PlantRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;

    public List<PlantDTO> getAllDTOs() {
        return plantRepository.findPlantsBy();
    }

    public Optional<PlantDTO> getDTOById(Integer id) {
        return plantRepository.findByIdPlant(id);
    }

    public Optional<Plant> getById(Integer id) {
        return plantRepository.findById(id);
    }

    public Boolean save(Plant plant) {
        plantRepository.save(plant);
        return true;
    }

    public void deleteById(Integer id) {
        plantRepository.deleteById(id);
    }

    public Boolean updateById(Plant plant, Integer id) {
        Optional<Plant> optionalPlantExisting = getById(id);
        if (optionalPlantExisting.isPresent()) {
            Plant plantExisting = optionalPlantExisting.get();
            plantExisting.setCareInstructions(plant.getCareInstructions());
            plantExisting.setScientificName(plant.getScientificName());
            return save(plantExisting);
        } else {
            return false;
        }
    }

}
