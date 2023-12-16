package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.PlantDTO;
import Gardenia.Model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    public List<PlantDTO> findPlantsBy();

    public Optional<PlantDTO> findByIdPlant(Integer idPlant);
}
