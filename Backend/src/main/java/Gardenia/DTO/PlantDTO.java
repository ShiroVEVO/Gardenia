package Gardenia.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class PlantDTO {
    private String scientificName;
    private String careInstructions;
}
