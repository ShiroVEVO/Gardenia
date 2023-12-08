package Gardenia.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class AccountDTO {
    private Date birthDate;
}
