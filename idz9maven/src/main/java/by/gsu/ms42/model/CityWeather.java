package by.gsu.ms42.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CityWeather {

    private Long id;
    private String name;
    private Integer cod;
    private Coordinates coord;
    private List<Weather> weather;
    private String base;
    private MainInfo main;
    private Long visibility;
    private Wind wind;
    private Clouds clouds;
    private Double dt;
    private Sys sys;
    private Double timezone;
}
