package Gardenia.DTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class ReviewDTO {
    private String comment;
    private Date commentDate;
    private Integer score;
}
