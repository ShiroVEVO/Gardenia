package Gardenia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class CityDTO {
    private String name;
    private Integer shippingCost;
}
