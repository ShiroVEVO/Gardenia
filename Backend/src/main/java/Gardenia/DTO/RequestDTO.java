package Gardenia.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class RequestDTO {
    private String state;
    private Date requestDate;
    private Integer totalAmount;
}
