package Gardenia.Model;

import java.sql.Date;
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
public class Spent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idSpent;

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private String name;

    @Column(columnDefinition = "VARCHAR(2)", nullable = false)
    private String unit;

    @Column(nullable = false)
    private Date spentDate;

    @Column(columnDefinition = "MEDIUMINT(10) UNSIGNED", nullable = false)
    private Integer amount;

    @Column(columnDefinition = "SMALLINT(5) UNSIGNED")
    private Integer quantity;

    @JsonBackReference("purchaseOption-spent")
    @ManyToMany(mappedBy = "spents", fetch = FetchType.LAZY)
    private List<PurchaseOption> purchaseOptions;
}
