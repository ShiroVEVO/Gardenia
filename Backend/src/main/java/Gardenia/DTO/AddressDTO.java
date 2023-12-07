package Gardenia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class AddressDTO {
    private String addressValue;
    private String addressReferences;
}
