package Gardenia.Util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ClientKey {
    @Column(columnDefinition = "VARCHAR(2) CHECK (document_type in ('CC', 'PA', 'CE', 'TI'))", nullable = false)
    private String documentType;

    @Column(columnDefinition = "BIGINT(10) UNSIGNED", nullable = false)
    private Integer documentNumber;
}
