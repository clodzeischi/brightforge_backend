package swf.army.mil.brightforge_backend.product;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository r) { this.productRepository = r; }

    @Transactional
    public Product createProduct(Product product) { return productRepository.save(product); }

    public List<Product> getAllProducts() { return productRepository.findAll(); }

    public Product getProductByID(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    @Transactional
    public Product modifyProduct(Product p) {
        Product myProduct = productRepository.findById(p.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        myProduct.setSlug(p.getSlug());
        myProduct.setName(p.getName());
        myProduct.setDescription(p.getDescription());

        return myProduct;
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product myProduct = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepository.deleteById(id);
    }
}
