package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Gardenia.DTO.ProductDTO;
import Gardenia.Model.Category;
import Gardenia.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<ProductDTO> findProductBy();

    public Optional<ProductDTO> findByIdProduct(Integer id);

    public List<ProductDTO> findProductByNameContaining(String word);

    public List<ProductDTO> findProductByScoreBetween(float minScore, float maxScore);

    public List<ProductDTO> findProductByTotalCostBetween(float minPrice, float maxPrice);

    public List<ProductDTO> findProductByCategories(Category category);
}
