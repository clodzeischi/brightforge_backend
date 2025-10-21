package swf.army.mil.brightforge_backend.variant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import swf.army.mil.brightforge_backend.color.Color;
import swf.army.mil.brightforge_backend.product.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Color color;

    private String imageUrl;
    private BigDecimal rating;

    @Column(nullable = false)
    private Integer qty;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LifecycleStatus lifecycleStatus;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
