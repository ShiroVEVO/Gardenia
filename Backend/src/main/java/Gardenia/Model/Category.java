package Gardenia.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idCategory;

    @Column(columnDefinition = "VARCHAR(300)", nullable = false)
    private String urlImg;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String name;

    @JsonBackReference("product-category")
    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Product> products;

}
