package Gardenia.Util;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DateIntervals {
    private Date initialDate;
    private Date finalDate;
}
