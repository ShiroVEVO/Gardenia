package Gardenia.Controller;

import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.ImageDTO;
import Gardenia.Model.Image;
import Gardenia.Service.ImageService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping
    public List<ImageDTO> getAllImages() {
        return imageService.getAllDTO();
    }

    @GetMapping("/{id_image}")
    public Optional<ImageDTO> getImageById(@PathVariable("id_image") Integer id) {
        return imageService.getDTOById(id);
    }

    // public List<ImageDTO> getImagesByProduct(@RequestBody Product product)

    @PostMapping("/save")
    public Boolean saveImage(@RequestBody Image image) {
        return imageService.save(image);
    }

    @DeleteMapping("/{id_image}")
    public void deleteImageById(@PathVariable("id_image") Integer id) {
        imageService.deleteById(id);
    }

    @PutMapping("/{id_image}")
    public Boolean putMethodName(@PathVariable("id_image") Integer id, @RequestBody Image image) {
        return imageService.updateById(image, id);
    }
}
