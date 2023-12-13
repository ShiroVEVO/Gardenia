package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.CategoryDTO;
import Gardenia.Model.Category;
import Gardenia.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllDTO() {
        return categoryRepository.findCategoryBy();
    }

    public Optional<CategoryDTO> getDTOById(Integer id) {
        return categoryRepository.findByIdCategory(id);
    }

    public Optional<Category> getById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Boolean save(Category category) {
        categoryRepository.save(category);
        return true;
    }

    public void deleteById(Integer id) {
        categoryRepository.deleteById(id);
    }

    public boolean updateById(Category category, Integer id) {
        Optional<Category> optionalCategoryExisting = getById(id);
        if (optionalCategoryExisting.isPresent()) {
            Category categoryExisting = optionalCategoryExisting.get();
            categoryExisting.setName(category.getName());
            categoryExisting.setUrlImg(category.getUrlImg());
            return save(categoryExisting);
        } else {
            return false;
        }
    }
}
