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
import org.springframework.web.bind.annotation.RestController;

import Gardenia.Model.Product;
import Gardenia.Service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id_product}")
    public Optional<Product> GetProductById(@PathVariable("id_product") Integer id) {
        return productService.getById(id);
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @DeleteMapping("/{id_product}")
    public void deleteProductById(@PathVariable("id_product") Integer id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id_product}")
    public void updateProductById(@RequestBody Product product, @PathVariable("id_product") Integer id) {
        productService.update(product, id);
    }

}
