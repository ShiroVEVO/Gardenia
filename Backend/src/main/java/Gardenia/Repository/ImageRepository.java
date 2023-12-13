package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.ImageDTO;
import Gardenia.Model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("SELECT NEW Gardenia.DTO.ImageDTO(i.url) FROM Image i")
    public List<ImageDTO> findImagesby();

    public Optional<ImageDTO> findByIdImage(Integer idImage);
}
