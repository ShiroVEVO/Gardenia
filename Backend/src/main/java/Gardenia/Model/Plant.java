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
import jakarta.persistence.OneToOne;
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

        @Column(columnDefinition = "VARCHAR(1500)", nullable = true)
        private String careInstructions;

        @Column(columnDefinition = "VARCHAR(40)", nullable = false)
        private String scientificName;

        @OneToOne(mappedBy = "plant")
        private Product product;

}
