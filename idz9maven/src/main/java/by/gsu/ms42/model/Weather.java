package by.gsu.ms42.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Weather {

    private Long id;
    private String main;
    private String description;
    private String icon;

}
