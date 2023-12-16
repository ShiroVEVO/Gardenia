package Gardenia.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idPurchaseOption;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(300)", nullable = false)
    private String urlImg;

    @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
    private Integer baseCost;

    @JsonBackReference("product-purchaseOption")
    @ManyToMany(mappedBy = "purchaseOptions", fetch = FetchType.LAZY)
    private List<Product> products;

    @JsonManagedReference("purchaseOption-spent")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "purchase_option_has_spent", joinColumns = {
            @JoinColumn(name = "purchase_option_id", referencedColumnName = "idPurchaseOption") }, inverseJoinColumns = {
                    @JoinColumn(name = "spent_id", referencedColumnName = "idSpent")
            })
    private List<Spent> spents;
}
