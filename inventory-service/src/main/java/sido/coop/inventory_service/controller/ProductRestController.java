package sido.coop.inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sido.coop.inventory_service.entities.Product;
import sido.coop.inventory_service.repository.ProductRepository;

import java.util.List;
@RestController

public class ProductRestController {
    private final ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Endpoint pour lister tous les produits
    @GetMapping("/products")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    // Endpoint pour trouver un produit par son ID
    @GetMapping("/products/{id}")
    public Product productById(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException(String.format("Product %s not found", id))
        );
    }
}
