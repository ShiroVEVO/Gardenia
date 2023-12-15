package Gardenia.Controller;

import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.PlantDTO;
import Gardenia.Model.Plant;
import Gardenia.Service.PlantService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/plant")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @GetMapping
    public List<PlantDTO> getAllPlants() {
        return plantService.getAllDTOs();
    }

    @GetMapping("/{id_plant}")
    public Optional<PlantDTO> getPlantById(@PathVariable("id_plant") Integer id) {
        return plantService.getDTOById(id);
    }

    @GetMapping("/search")
    public List<PlantDTO> getPlantsByWord(@RequestParam(name = "keyword") String word) {
        return plantService.getByWord(word);
    }

    @GetMapping("/score")
    public List<PlantDTO> getPlantsByScore(@RequestParam(name = "value") Integer score) {
        return plantService.getByScore(score);
    }

    @GetMapping("/price")
    public List<PlantDTO> getPlantsByPriceRange(@RequestParam(name = "minPrice") Integer minPrice,
            @RequestParam(name = "maxPrice") Integer maxPrice) {
        return plantService.getByPriceRange(minPrice, maxPrice);
    }

    /*
     * public List<PlantDTO> getPlantsByCategory(Integer id) {
     * 
     * }
     */

    @PostMapping("save")
    public Boolean save(@RequestBody Plant plant) {
        return plantService.save(plant);
    }

    @DeleteMapping("/{id_plant}")
    public void deleteById(@PathVariable("id_plant") Integer id) {
        plantService.deleteById(id);
    }

    @PutMapping("/{id_plant}")
    public Boolean updateById(@RequestBody Plant plant, @PathVariable("id_plant") Integer id) {
        return plantService.updateById(plant, id);

    }
}
