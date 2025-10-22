package swf.army.mil.brightforge_backend.variant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/variant")
public class VariantController {

    private final VariantService variantService;

    public VariantController(VariantService s) { this.variantService = s; }

    @PostMapping
    public ResponseEntity<Variant> createVariant(@RequestBody Variant variant) {
        Variant saved = variantService.createVariant(variant);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Variant>> getAllVariants() {
        List<Variant> variants = variantService.getAllVariants();
        return ResponseEntity.status(HttpStatus.OK).body(variants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variant> getVariantByID(@PathVariable Long id) {
        Variant variant = variantService.getVariantByID(id);
        return ResponseEntity.ok(variant);
    }

    @GetMapping("/bycolor")
    public ResponseEntity<List<Variant>> getVariantsByColor(@RequestParam String colorLabel) {
        return ResponseEntity.ok(variantService.getVariantsByColor(colorLabel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Variant> modifyVariant(@PathVariable Long id, @RequestBody Variant updatedVariant) {
        updatedVariant.setId(id);
        Variant result = variantService.modifyVariant(updatedVariant);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        variantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}
