package by.gsu.ms42.constants;

public class SqlQueries {
    public static final String SELECT_ALL_COORDINATES_AND_LENGTHS =  "SELECT x1, y1, x2, y2, x3, y3, x4, y4,\n" +
                                                                "\t   round(sqrt(( pow(x2 - x1, 2)) + (pow(y2 - y1, 2))), 2) as length1_2,\n" +
                                                                "\t   round(sqrt(( pow(x3 - x2, 2)) + (pow(y3 - y2, 2))), 2) as length2_3,\n" +
                                                                "       round(sqrt(( pow(x4 - x3, 2)) + (pow(y4 - y3, 2))), 2) as length3_4,\n" +
                                                                "       round(sqrt(( pow(x1 - x4, 2)) + (pow(y1 - y4, 2))), 2) as length4_1\n" +
                                                                " FROM coordinates";
}
