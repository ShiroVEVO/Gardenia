package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.ImageDTO;
import Gardenia.Model.Image;
import Gardenia.Repository.ImageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public List<ImageDTO> getAllDTO() {
        return imageRepository.findImagesby();
    }

    public Optional<ImageDTO> getDTOById(Integer id) {
        return imageRepository.findByIdImage(id);
    }

    public Optional<Image> getById(Integer id) {
        return imageRepository.findById(id);
    }

    /*
     * public List<ImageDTO> getByProduct(){
     * 
     * }
     */

    public Boolean save(Image image) {
        imageRepository.save(image);
        return true;
    }

    public void deleteById(Integer id) {
        imageRepository.deleteById(id);
    }

    public Boolean updateById(Image image, Integer id) {
        Optional<Image> optionalImageExisting = getById(id);
        if (optionalImageExisting.isPresent()) {
            Image imageExisting = optionalImageExisting.get();
            imageExisting.setUrl(image.getUrl());
            return save(imageExisting);
        } else {
            return false;
        }
    }
}
