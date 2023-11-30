package Gardenia.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.Model.City;
import Gardenia.Service.CityService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")

public class CityController {
    private final CityService cityService;

    @GetMapping
    public List<City> getCities() {
        return cityService.getAll();
    }

    @GetMapping("/{id_city}")
    public Optional<City> getCityById(@PathVariable("id_city") Integer id) {
        return cityService.getById(id);

    }

    @PostMapping("/save")
    public void saveCity(@RequestBody City city) {
        cityService.save(city);
    }

    @DeleteMapping("/{id_city}")
    public void deleteCityById() {

    }

    @PutMapping("/{id_city}")
    public City updateCity(@RequestBody City city, @PathVariable("id_city") Integer id) {
        return cityService.update(city, id);
    }
}
