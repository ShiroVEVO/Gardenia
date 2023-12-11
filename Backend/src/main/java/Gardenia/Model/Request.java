package Gardenia.Model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Integer idRequest;

    @Column(columnDefinition = "VARCHAR(10) CHECK (state IN ('EN_ESPERA', 'PAGADO', 'ENVIADO', 'CANCELADO', 'FINALIZADO'))", nullable = false)
    private String state;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(nullable = false)
    private Date requestDate;

    @Column(columnDefinition = "MEDIUMINT(10) UNSIGNED", nullable = false)
    private Integer totalAmount;

    @ManyToOne
    @JsonBackReference("client-request")
    @JoinColumns({
            @JoinColumn(name = "client_DocumentType", columnDefinition = "VARCHAR(2) CHECK (client_document_type in ('CC', 'PA', 'CE', 'TI'))", referencedColumnName = "documentType", nullable = false),
            @JoinColumn(name = "client_DocumentNumber", referencedColumnName = "documentNumber", nullable = false),
    })
    private Client client;

    // private List<Product> products;
    // private List<Review> reviews;
    // private List<Plants> plants;
}
