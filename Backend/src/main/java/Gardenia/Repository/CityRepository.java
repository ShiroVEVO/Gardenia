package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.CityDTO;
import Gardenia.Model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<CityDTO> findCityBy();

    Optional<CityDTO> findCityByIdCity(Integer idCity);

}
