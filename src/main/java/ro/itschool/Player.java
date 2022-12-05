package ro.itschool;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {

    //@CsvBindByName(column = "id")
    @CsvBindByPosition(position = 0)
    private int id;

    @CsvBindByPosition(position = 1)
    private String firstName;

    @CsvBindByPosition(position = 2)
    private String lastName;

    @CsvBindByPosition(position = 3)
    private int age;

    @CsvBindByPosition(position = 4)
    private int gsTitles;
}