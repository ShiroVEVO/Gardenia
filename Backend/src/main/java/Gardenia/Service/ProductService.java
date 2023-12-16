package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.ProductDTO;
import Gardenia.Model.Category;
import Gardenia.Model.Product;
import Gardenia.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDTO> getAllDTO() {
        return productRepository.findProductBy();
    }

    public Optional<ProductDTO> getDTOById(Integer id) {
        return productRepository.findByIdProduct(id);
    }

    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    public List<ProductDTO> getByWord(String word) {
        return productRepository.findProductByNameContaining(word);
    }

    public List<ProductDTO> getByScore(Integer score) {
        return productRepository.findProductByScoreBetween(score.floatValue(), score.floatValue() + 1);
    }

    public List<ProductDTO> getByPrice(Integer minPrice, Integer maxPrice) {
        return productRepository.findProductByTotalCostBetween(minPrice, maxPrice);
    }

    public List<ProductDTO> getByCategories(Category category) {
        return productRepository.findProductByCategories(category);
    }

    public Boolean save(Product product) {
        productRepository.save(product);
        return true;
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public Boolean update(Product product, Integer id) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setDescription(product.getDescription());
            existingProduct.setName(product.getName());
            existingProduct.setProductionCost(product.getProductionCost());
            existingProduct.setScore(product.getScore());
            existingProduct.setStock(product.getStock());
            existingProduct.setTotalCost(product.getTotalCost());
            existingProduct.setStockeableAs(product.getStockeableAs());
            return save(existingProduct);
        } else {
            return null;
        }
    }
}
