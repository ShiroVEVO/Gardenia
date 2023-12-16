package Gardenia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private Float score;
    private Integer totalCost;
    private Integer stockeableAs;
    private Integer stock;
}
