package by.gsu.ms42.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MainInfo {

    private Double temp;
    private Double pressure;
    private Long humidity;
    private Double temp_min;
    private Double temp_max;
}
