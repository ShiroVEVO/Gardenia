package Gardenia.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    @JsonBackReference
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne
    @JsonBackReference
    @JoinColumns({
            @JoinColumn(name = "clientDocumentType", columnDefinition = "VARCHAR(2) CHECK (client_document_type in ('CC', 'PA', 'CE', 'TI'))", referencedColumnName = "documentType", nullable = false),
            @JoinColumn(name = "clientDocumentNumber", referencedColumnName = "documentNumber", nullable = false),
    })
    private Client client;

}
