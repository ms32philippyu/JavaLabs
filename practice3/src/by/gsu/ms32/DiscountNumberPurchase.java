package by.gsu.ms32;

import java.util.Scanner;

public class DiscountNumberPurchase extends Purchase {
    private double discount;
    private static final int QUANTITY = 20;

    public DiscountNumberPurchase(int discount) {
        super();
    }

    public DiscountNumberPurchase(String name, int price, int nubmOfPurchUnit, int discount) {
        super(name, price, nubmOfPurchUnit);
        this.discount = discount;
    }

    public DiscountNumberPurchase (Scanner scanner){
        super(scanner.next(),scanner.nextInt(),scanner.nextInt());
        this.discount = scanner.nextDouble();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public int getCost() {
        if (getNubmOfPurchUnit() >= QUANTITY){
            return (int) (getPrice() * getNubmOfPurchUnit() *(1-discount/100));
        }else {
            return getPrice() * getNubmOfPurchUnit();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ";" + discount;
    }
}
