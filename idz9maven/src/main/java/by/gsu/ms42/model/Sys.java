package by.gsu.ms42.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Sys {

    private Integer type;
    private Long id;
    private String country;
    private Double sunrise;
    private Double sunset;
}
