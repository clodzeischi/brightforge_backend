package swf.army.mil.brightforge_backend.color;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import swf.army.mil.brightforge_backend.variant.VariantRepository;

import java.util.List;

@Service
public class ColorService {

    private final ColorRepository colorRepository;

    ColorService(ColorRepository r) { this.colorRepository = r; }

    @Transactional
    public Color createColor(Color color) { return colorRepository.save(color); }

    public List<Color> getAllColors() { return colorRepository.findAll(); }

    public Color getColorByID(Long id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Color not found"));
    }

    @Transactional
    public Color modifyColor(Color c) {
        Color myColor = colorRepository.findById(c.getId())
                .orElseThrow(() -> new EntityNotFoundException("Color not found"));

        myColor.setCode(c.getCode());
        myColor.setLabel(c.getLabel());
        myColor.setHex(c.getHex());

        return myColor;
    }

    @Transactional
    public void deleteColor(Long id) {
        Color myColor = colorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Color not found"));
        colorRepository.delete(myColor);
    }
}
