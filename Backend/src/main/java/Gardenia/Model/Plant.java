package Gardenia.Model;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idPlant;

    @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
    private Integer productionCost;

    @Column(columnDefinition = "VARCHAR(600)", nullable = true)
    private String description;

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
    private Integer stock;

    @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
    private Integer totalCost;

    @Column(columnDefinition = "FLOAT UNSIGNED", nullable = true)
    private float score;

    @Column(columnDefinition = "VARCHAR(80)", nullable = true)
    private String name;

    @Column(columnDefinition = "TINYINT(1) UNSIGNED", nullable = false)
    private Integer stockeableAs;

    @Column(columnDefinition = "VARCHAR(1500)", nullable = true)
    private String careInstructions;

    @Column(columnDefinition = "VARCHAR(40)", nullable = false)
    private String scientificName;

    // private List<Request> requests;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "plant_has_category", joinColumns = {
            @JoinColumn(name = "plant_id", referencedColumnName = "idPlant") }, inverseJoinColumns = {
                    @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
            })
    private List<Category> categories;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "plant")
    private List<Image> images;
    // private List<PurchaseOption> purchaseOptions ;

}
