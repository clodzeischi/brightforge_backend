package swf.army.mil.brightforge_backend.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService s) { this.productService = s; };

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable Long id) {
        Product product = productService.getProductByID(id);

        if (product != null) return ResponseEntity.ok(product);
        else return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> modifyProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        Product result = productService.modifyProduct(updatedProduct);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
