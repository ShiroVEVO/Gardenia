package Gardenia.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.CityDTO;
import Gardenia.Model.City;
import Gardenia.Model.Department;
import Gardenia.Repository.CityRepository;
import Gardenia.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final DepartmentRepository departmentRepository;

    public List<CityDTO> getAllDTO() {
        return cityRepository.findCityBy();
    }

    public Optional<CityDTO> getDTOById(Integer id) {
        return cityRepository.findCityByIdCity(id);
    }

    public Optional<City> getById(Integer id) {
        return cityRepository.findById(id);
    }

    public List<CityDTO> getByDepartment(Integer idDepartment) {
        List<CityDTO> ListCitiesDTO = new ArrayList<>();
        List<City> X = departmentRepository.findCitiesByDepartment(idDepartment);
        if (X.size() != 0) {
            for (Integer i = 0; i < X.size(); i++) {
                City city = X.get(i);
                CityDTO cityDTO = new CityDTO(city.getName(), city.getShippingCost());
                ListCitiesDTO.add(cityDTO);
            }
            return ListCitiesDTO;
        } else {
            return null;
        }
    }

    public Boolean save(City city) {
        Department department = city.getDepartment();
        if (departmentRepository.findById(department.getIdDepartment()).isPresent()) {
            cityRepository.save(city);
            return true;
        } else {
            return false;
        }
    }

    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    public Boolean updateById(City city, Integer id) {
        Optional<City> optionalCityExisting = getById(id);
        if (optionalCityExisting.isPresent()) {
            City cityExisting = optionalCityExisting.get();
            cityExisting.setName(city.getName());
            cityExisting.setShippingCost(city.getShippingCost());
            System.out.println(cityExisting);
            save(cityExisting);
            return true;
        } else {
            return false;
        }
    }

}
