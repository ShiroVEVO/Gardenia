package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.Model.Product;
import Gardenia.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product, Integer id) {
        Optional<Product> existingProductOptional = productRepository.findById(id);
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setDescription(product.getDescription());
            existingProduct.setName(product.getName());
            existingProduct.setProduction_cost(product.getProduction_cost());
            existingProduct.setScore(product.getScore());
            existingProduct.setStock(product.getStock());
            existingProduct.setTotal_cost(product.getTotal_cost());
            saveProduct(existingProduct);
        } else {
            // IDK xd
        }
    }
}
