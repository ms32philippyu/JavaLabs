package by.gsu.ms32;

public class Byn {
    public static String toByn(int penny) {
        return penny / 100 + "." + penny / 10 % 10 + penny % 10;
    }
}
