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
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(columnDefinition = "INT UNSIGNED")
        private Integer idProduct;

        @Column(columnDefinition = "VARCHAR(50)", nullable = false)
        private String name;

        @Column(columnDefinition = "FLOAT UNSIGNED", nullable = true)
        private Float score;

        @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
        private Integer totalCost;

        @Column(columnDefinition = "TINYINT(1) UNSIGNED", nullable = false)
        private Integer stockeableAs;

        @Column(columnDefinition = "SMALLINT(5) UNSIGNED", nullable = false)
        private Integer stock;

        @Column(columnDefinition = "VARCHAR(800)", nullable = false)
        private String description;

        @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
        private Integer productionCost;

        @OneToOne
        @JoinColumn(name = "plant_id", nullable = true)
        private Plant plant;

        @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
        private List<Image> images;

        @JsonManagedReference("product-category")
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "product_has_category", joinColumns = {
                        @JoinColumn(name = "product_id", referencedColumnName = "idProduct") }, inverseJoinColumns = {
                                        @JoinColumn(name = "category_id", referencedColumnName = "idCategory")
                        })
        private List<Category> categories;

        @JsonBackReference("request-product")
        @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
        private List<Request> requests;

        @JsonManagedReference("product-purchaseOption")
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "product_has_purchase_option", joinColumns = {
                        @JoinColumn(name = "product_id", referencedColumnName = "idProduct") }, inverseJoinColumns = {
                                        @JoinColumn(name = "purchase_option_id", referencedColumnName = "idPurchaseOption")
                        })
        private List<PurchaseOption> purchaseOptions;

}
