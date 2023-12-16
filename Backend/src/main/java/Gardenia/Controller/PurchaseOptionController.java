package Gardenia.Controller;

import org.springframework.web.bind.annotation.RestController;

import Gardenia.DTO.PurchaseOptionDTO;
import Gardenia.Model.PurchaseOption;
import Gardenia.Service.PurchaseOptionService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/purchase_option")
@RequiredArgsConstructor
public class PurchaseOptionController {

    private final PurchaseOptionService purchaseOptionService;

    @GetMapping
    public List<PurchaseOptionDTO> getAllPurchaseOptions() {
        return purchaseOptionService.getAllDTO();
    }

    @GetMapping("/{id_purchaseOption}")
    public Optional<PurchaseOptionDTO> getPurchaseOptionById(@PathVariable("id_purchaseOption") Integer id) {
        return purchaseOptionService.getDTOById(id);
    }

    @PostMapping("/save")
    public Boolean savePurchaseOption(@RequestBody PurchaseOption purchaseOption) {
        return purchaseOptionService.save(purchaseOption);
    }

    @DeleteMapping("/{id_purchaseOption}")
    public void deletePurchaseOptionById(@PathVariable("id_purchaseOption") Integer id) {
        purchaseOptionService.deleteById(id);
    }

    @PutMapping("/{id_purchaseOption}")
    public Boolean updatePurchaseOptionById(@PathVariable("id_purchaseOption") Integer id,
            @RequestBody PurchaseOption purchaseOption) {
        return purchaseOptionService.updateById(purchaseOption, id);
    }
}
