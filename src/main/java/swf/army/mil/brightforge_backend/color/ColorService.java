package swf.army.mil.brightforge_backend.color;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {

    ColorRepository colorRepository;

    ColorService(ColorRepository r) { this.colorRepository = r; }

    @Transactional
    public Color saveColor(Color color) {
        return colorRepository.save(color);
    }

    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    public Color getColorByID(Long id) {
        return colorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Color not found"));
    }

    @Transactional
    public Color modifyColor(@NotNull Color c) {
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
