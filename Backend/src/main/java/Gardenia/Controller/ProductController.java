package Gardenia.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.ProductDTO;
import Gardenia.Model.Category;
import Gardenia.Model.Product;
import Gardenia.Service.CategoryService;
import Gardenia.Service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllDTO();
    }

    @GetMapping("/{id_product}")
    public Optional<ProductDTO> GetProductById(@PathVariable("id_product") Integer id) {
        return productService.getDTOById(id);
    }

    @GetMapping("/search")
    public List<ProductDTO> getProductsByWord(@RequestParam(name = "keyWord") String word) {
        return productService.getByWord(word);
    }

    @GetMapping("search_score")
    public List<ProductDTO> getProductsByScore(@RequestParam(name = "score") Integer score) {
        return productService.getByScore(score);
    }

    @GetMapping("search_prices")
    public List<ProductDTO> getProductsByPrice(@RequestParam(name = "minPrice") Integer minPrice,
            @RequestParam(name = "maxPrice") Integer maxPrice) {
        return productService.getByPrice(minPrice, maxPrice);
    }

    @GetMapping("/search_categories")
    public List<ProductDTO> getByCategories(@RequestParam(name = "keyCategory") Integer id) {
        Optional<Category> optionalExistingCategory = categoryService.getById(id);
        if (optionalExistingCategory.isPresent()) {
            return productService.getByCategories(optionalExistingCategory.get());
        } else {
            return null;
        }
    }

    @PostMapping("/save")
    public Boolean saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/{id_product}")
    public void deleteProductById(@PathVariable("id_product") Integer id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id_product}")
    public Boolean updateProductById(@RequestBody Product product, @PathVariable("id_product") Integer id) {
        return productService.update(product, id);
    }

}
