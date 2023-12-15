package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.PlantDTO;
import Gardenia.Model.Category;
import Gardenia.Model.Plant;
import Gardenia.Repository.PlantRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;
    private final CategoryService categoryService;

    public List<PlantDTO> getAllDTOs() {
        return plantRepository.findPlantsBy();
    }

    public Optional<PlantDTO> getDTOById(Integer id) {
        return plantRepository.findByIdPlant(id);
    }

    public Optional<Plant> getById(Integer id) {
        return plantRepository.findById(id);
    }

    public List<PlantDTO> getByWord(String word) {
        return plantRepository.findPlantByNameContaining(word);
    }

    public List<PlantDTO> getByScore(Integer score) {
        return plantRepository.findPlantByScoreBetween(score.floatValue(), score.floatValue() + 1);
    }

    public List<PlantDTO> getByPriceRange(Integer minPrice, Integer maxPrice) {
        return plantRepository.findPlantByTotalCostBetween(minPrice, maxPrice);
    }

    public List<PlantDTO> getByCategory(Integer id) {
        Optional<Category> optionalCategoryExisting = categoryService.getById(id);
        if (optionalCategoryExisting.isPresent()) {
            return plantRepository.findPlantByCategories(optionalCategoryExisting.get());
        } else {
            return null;
        }

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
            plantExisting.setDescription(plant.getDescription());
            plantExisting.setName(plant.getName());
            plantExisting.setProductionCost(plant.getProductionCost());
            plantExisting.setScientificName(plant.getScientificName());
            plantExisting.setScore(plant.getScore());
            plantExisting.setStock(plant.getStock());
            plantExisting.setStockeableAs(plant.getStockeableAs());
            plantExisting.setTotalCost(plant.getTotalCost());
            plantExisting.setImages(plant.getImages());
            return save(plantExisting);
        } else {
            return false;
        }
    }

}
