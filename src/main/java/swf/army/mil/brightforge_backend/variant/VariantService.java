package swf.army.mil.brightforge_backend.variant;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {

    VariantRepository variantRepository;

    VariantService(VariantRepository r) { this.variantRepository = r; }

    @Transactional
    public Variant saveVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    public Variant getVariantByID(Long id) {

        return variantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    @Transactional
    public Variant modifyVariant(Variant changedVariant) {
        Variant myVariant = variantRepository.findById(changedVariant.getId())
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        myVariant.setProduct(changedVariant.getProduct());
        myVariant.setColor(changedVariant.getColor());
        myVariant.setImageUrl(changedVariant.getImageUrl());
        myVariant.setLifecycleStatus(changedVariant.getLifecycleStatus());

        return myVariant;
    }

    @Transactional
    public Variant deleteVariant(Long id) {
        Variant myColor = variantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        variantRepository.deleteById(id);
        return myColor;
    }
}
