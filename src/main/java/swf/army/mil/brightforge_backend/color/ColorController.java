package swf.army.mil.brightforge_backend.color;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/color")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService s) { this.colorService = s; }

    @PostMapping
    public ResponseEntity<Color> createColor(@RequestBody Color color) {
        Color saved = colorService.createColor(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Color>> getAllColors() {
        List<Color> colors = colorService.getAllColors();
        return ResponseEntity.status(HttpStatus.OK).body(colors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorByID(@PathVariable Long id) {
        Color color = colorService.getColorByID(id);
        return ResponseEntity.ok(color);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> modifyColor(@PathVariable Long id, @RequestBody Color updatedColor) {
        updatedColor.setId(id);
        Color result = colorService.modifyColor(updatedColor);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteColor(@PathVariable Long id) {
        colorService.deleteColor(id);
        return ResponseEntity.noContent().build();
    }
}
