package by.gsu.ms42.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
abstract class Shape {
    //Coords
    private Integer x1;
    private Integer y1;
    private Integer x2;
    private Integer y2;
    private Integer x3;
    private Integer y3;
    private Integer x4;
    private Integer y4;

    public Shape(Integer x1, Integer y1, Integer x2, Integer y2, Integer x3, Integer y3, Integer x4, Integer y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }

    @Override
    public String toString() {
        return formatData();
    }

    protected final String formatData() {
        return " Coordinates: x1 = " + x1 + "; y1 = " + y1 + "; x2 = " + x2 + "; y2 = " + y2 +
                "; x3 = " + x3 + "; y3 = " + y3 + "; x4 = " + x4 + "; y4 = " + y4 + "";
    }
}
