package Gardenia.Model;

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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddress", columnDefinition = "INT UNSIGNED")
    private Integer idAddress;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String addressValue;

    @Column(columnDefinition = "VARCHAR(150)", nullable = true)
    private String addressReferences;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

}
