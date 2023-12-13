package Gardenia.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.CategoryDTO;
import Gardenia.Model.Category;
import Gardenia.Service.CategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllDTO();
    }

    @GetMapping("/{id_category}")
    public Optional<CategoryDTO> getCategoryById(@PathVariable("id_category") Integer id) {
        return categoryService.getDTOById(id);
    }

    @PostMapping
    public Boolean saveCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("/{id_category}")
    public void deleteCategoryById(@PathVariable("id_category") Integer id) {
        categoryService.deleteById(id);
    }

    @PutMapping("/{id_category}")
    public Boolean updateCategoryById(@PathVariable("id_category") Integer id, @RequestBody Category category) {
        return categoryService.updateById(category, id);
    }

}
