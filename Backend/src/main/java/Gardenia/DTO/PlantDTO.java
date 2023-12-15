package Gardenia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PlantDTO {
    private String name;
    private String scientificName;
    private String description;
    private String careInstructions;
    private Integer stock;
    private float score;
    private Integer totalCost;
    private Integer stockeableAs;
}
