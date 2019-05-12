package by.gsu.ms32;

public class PricePurchase extends Purchase {
    private double discount;

    public PricePurchase(String name, int price, int numberOfPurchUnit, double discount) {
        super(name, price, numberOfPurchUnit);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + discount;
    }
}
