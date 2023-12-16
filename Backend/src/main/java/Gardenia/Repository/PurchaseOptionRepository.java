package Gardenia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gardenia.DTO.PurchaseOptionDTO;
import Gardenia.Model.PurchaseOption;

@Repository
public interface PurchaseOptionRepository extends JpaRepository<PurchaseOption, Integer> {
    public List<PurchaseOptionDTO> findPurchaseOptionBy();

    public Optional<PurchaseOptionDTO> findByIdPurchaseOption(Integer id);
}
