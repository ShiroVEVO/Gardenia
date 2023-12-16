package Gardenia.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import Gardenia.DTO.PurchaseOptionDTO;
import Gardenia.Model.PurchaseOption;
import Gardenia.Repository.PurchaseOptionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PurchaseOptionService {
    private final PurchaseOptionRepository purchaseOptionRepository;

    public List<PurchaseOptionDTO> getAllDTO() {
        return purchaseOptionRepository.findPurchaseOptionBy();
    }

    public Optional<PurchaseOptionDTO> getDTOById(Integer id) {
        return purchaseOptionRepository.findByIdPurchaseOption(id);
    }

    public Optional<PurchaseOption> getById(Integer id) {
        return purchaseOptionRepository.findById(id);
    }

    public Boolean save(PurchaseOption purchaseOption) {
        purchaseOptionRepository.save(purchaseOption);
        return true;
    }

    public void deleteById(Integer id) {
        purchaseOptionRepository.deleteById(id);
    }

    public Boolean updateById(PurchaseOption purchaseOption, Integer id) {
        Optional<PurchaseOption> optionalPurchaseOptionExisting = getById(id);
        if (optionalPurchaseOptionExisting.isPresent()) {
            PurchaseOption purchaseOptionExisting = optionalPurchaseOptionExisting.get();
            purchaseOptionExisting.setName(purchaseOption.getName());
            purchaseOptionExisting.setUrlImg(purchaseOption.getUrlImg());
            return save(purchaseOptionExisting);
        } else {
            return false;
        }
    }
}
