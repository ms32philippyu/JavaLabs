package by.gsu.ms32;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private int priceDiscount;

    public PriceDiscountPurchase(int priceDiscount) {
        super();
    }

    public PriceDiscountPurchase(String name, int price, int nubmOfPurchUnit, int priceDiscount) {
        super(name, price, nubmOfPurchUnit);
        this.priceDiscount = priceDiscount;
    }

    public PriceDiscountPurchase(Scanner scanner){
        super(scanner.next(),scanner.nextInt(),scanner.nextInt());
        this.priceDiscount = scanner.nextInt();
    }

    public int getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(int priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    @Override
    public int getCost() {
        return (getPrice() - priceDiscount)*getNubmOfPurchUnit();
    }

    @Override
    public String toString() {
        return super.toString() + ";" + priceDiscount;
    }
}
