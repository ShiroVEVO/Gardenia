package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.Model.City;
import Gardenia.Repository.CityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public Optional<City> getById(Integer id) {
        return cityRepository.findById(id);
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    public City update(City city, Integer id) {
        Optional<City> optionalCityExisting = getById(id);
        if (optionalCityExisting.isPresent()) {
            City cityExisting = optionalCityExisting.get();
            cityExisting.setName(city.getName());
            cityExisting.setShipping_cost(city.getShipping_cost());
            save(cityExisting);
            return cityExisting;
        } else {
            // IDK x3
            return null;
        }
    }

}
