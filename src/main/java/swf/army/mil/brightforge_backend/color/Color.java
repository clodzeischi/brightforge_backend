package swf.army.mil.brightforge_backend.color;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import swf.army.mil.brightforge_backend.variant.Variant;

import java.util.List;

@Entity
public class Color {
    @Id
    @GeneratedValue
    private Long id;

    private String code;
    private String label;
    private String hex;

    @OneToMany(mappedBy = "color")
    private List<Variant> variants;
}

