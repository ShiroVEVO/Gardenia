package Gardenia.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private Integer idCity;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "MEDIUMINT(8) UNSIGNED", nullable = false)
    private Integer shippingCost;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "city")
    private List<Address> addresses;

    // @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    // METODOS EQUALS Y HASHCODE EN AMBAS

    public String toString() {
        return "{" +
                "\"idCity\":" + idCity + "," +
                "\"name\":" + name + "," +
                "\"shippingCost\":" + shippingCost +
                "}";
    }
}
