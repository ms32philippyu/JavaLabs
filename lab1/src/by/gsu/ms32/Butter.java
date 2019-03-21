package by.gsu.ms32;

public class Butter implements Comparable<Butter> {

    private String name;
    private boolean availabilityOfHerbalSupplements;
    private double price;

    public Butter(){

    }

    public Butter(String name, boolean availabilityOfHerbalSupplements, double price) {
        this.name = name;
        this.availabilityOfHerbalSupplements = availabilityOfHerbalSupplements;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailabilityOfHerbalSupplements() {
        return availabilityOfHerbalSupplements;
    }

    public void setAvailabilityOfHerbalSupplements(boolean availabilityOfHerbalSupplements) {
        this.availabilityOfHerbalSupplements = availabilityOfHerbalSupplements;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ";" + availabilityOfHerbalSupplements + ";" + Byn.toByn((int) price);
    }

    @Override
    public int compareTo(Butter b) {
        return (int) (this.price - b.price);
    }

}
