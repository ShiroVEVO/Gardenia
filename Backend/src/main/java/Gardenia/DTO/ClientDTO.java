package Gardenia.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ClientDTO {
    private String names;
    private String lastnames;
    private String phoneNumber;
    // private List<AddressDTO> addresses;
}
