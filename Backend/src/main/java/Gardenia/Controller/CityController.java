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

import Gardenia.DTO.CityDTO;
import Gardenia.Model.City;
import Gardenia.Service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

/*
 Input structure for City post on JSON
  {
  "name": "Example City",
  "shippingCost": 10, 
  "department": {
    "idDepartment": 1,
    "name": "Amazonas"
  }
}
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @GetMapping
    public List<CityDTO> getCities() {
        return cityService.getAllDTO();
    }

    @GetMapping("/{id_city}")
    public Optional<CityDTO> getCityById(@PathVariable("id_city") Integer id) {
        return cityService.getDTOById(id);
    }

    @GetMapping("/{id_department}/department")
    public List<CityDTO> getCitiesByDepartment(@PathVariable("id_department") Integer id) {
        return cityService.getByDepartment(id);
    }

    @PostMapping("/save")
    public Boolean saveCity(@RequestBody City city) {
        return cityService.save(city);
    }

    @DeleteMapping("/{id_city}")
    public void deleteCityById(@PathVariable("id_city") Integer id) {
        cityService.deleteById(id);
    }

    @PutMapping("/{id_city}")
    public Boolean updateCity(@RequestBody City city, @PathVariable("id_city") Integer id) {
        return cityService.updateById(city, id);
    }
}
