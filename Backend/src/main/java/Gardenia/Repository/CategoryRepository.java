package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.CategoryDTO;
import Gardenia.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public List<CategoryDTO> findCategoryBy();

    public Optional<CategoryDTO> findByIdCategory(Integer idCategory);
}
