package by.gsu.ms42.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trapezoid extends Shape {

    public Trapezoid(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3, Integer x4, Integer y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    @Override
    public String toString() {
        return "Trapezoid: " + formatData();
    }
}
