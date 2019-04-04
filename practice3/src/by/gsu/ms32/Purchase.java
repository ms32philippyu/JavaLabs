package by.gsu.ms32;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String name;
    private int price;
    private int nubmOfPurchUnit;

    public Purchase(){}

    public Purchase(String name, int price, int nubmOfPurchUnit) {
        this.name = name;
        this.price = price;
        this.nubmOfPurchUnit = nubmOfPurchUnit;
    }
    public Purchase (Scanner scanner){
        this.name = scanner.next();
        this.price = scanner.nextInt();
        this.nubmOfPurchUnit = scanner.nextInt();
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

    public int getNubmOfPurchUnit() {
        return nubmOfPurchUnit;
    }

    public void setNubmOfPurchUnit(int nubmOfPurchUnit) {
        this.nubmOfPurchUnit = nubmOfPurchUnit;
    }

    public int getCost(){
        return price * nubmOfPurchUnit;
    }

    @Override
    public String toString() {
        return name + ";" + Byn.toByn(price) + ";" + nubmOfPurchUnit + ";" + Byn.toByn(getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return price == purchase.price &&
                Objects.equals(name, purchase.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}


