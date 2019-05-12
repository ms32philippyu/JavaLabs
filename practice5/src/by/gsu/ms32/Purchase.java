package by.gsu.ms32;

import java.util.Objects;

public class Purchase implements Comparable<Purchase> {
    private String name;
    private int price;
    private int numberOfPurchUnit;

    public Purchase(String name, int price, int numberOfPurchUnit) {
        this.name = name;
        this.price = price;
        this.numberOfPurchUnit = numberOfPurchUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumberOfPurchUnit() {
        return numberOfPurchUnit;
    }

    public void setNumberOfPurchUnit(int numberOfPurchUnit) {
        this.numberOfPurchUnit = numberOfPurchUnit;
    }

    protected String fieldsToString(){
        return name+";"+Byn.toByn(price)+";"+ numberOfPurchUnit;
    }

    @Override
    public String toString() {
        return fieldsToString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return price == purchase.price &&
                numberOfPurchUnit == purchase.numberOfPurchUnit &&
                Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, numberOfPurchUnit);
    }

    @Override
    public int compareTo(Purchase purchase) {
        return this.price - purchase.getPrice();
    }
}
