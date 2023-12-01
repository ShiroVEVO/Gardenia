package Gardenia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDTO {
    private String name;
    private Integer shippingCost;
}
