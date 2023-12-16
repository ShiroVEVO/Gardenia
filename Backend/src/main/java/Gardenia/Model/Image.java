package Gardenia.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idImage;

    @Column(columnDefinition = "VARCHAR(300)", nullable = false)
    private String url;

    @ManyToOne
    @JsonBackReference("product-image")
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @ManyToOne
    @JsonBackReference("plant-image")
    @JoinColumn(name = "plant_id", nullable = true)
    private Plant plant;
}
