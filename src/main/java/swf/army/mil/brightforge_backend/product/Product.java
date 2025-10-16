package swf.army.mil.brightforge_backend.product;

import jakarta.persistence.*;
import swf.army.mil.brightforge_backend.variant.Variant;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String slug;

    @OneToMany(mappedBy = "product")
    private List<Variant> variants;
}
