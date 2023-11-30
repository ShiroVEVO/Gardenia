package Gardenia.Model;

import org.hibernate.annotations.ManyToAny;

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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SMALLINT(5) UNSIGNED")
    private Integer id_city;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
    private Integer shipping_cost;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    // METODOS EQUALS Y HASHCODE EN AMBAS
}
