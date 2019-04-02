package by.gsu.ms32;

import java.util.Scanner;

public class PurchaseFactory {
    private enum PurchasesKinds {
        GENERAL_PURCHASE, GENERAL_PURCHASE_PRICE_DISCOUNT, GENERAL_PURCHASE_DISCOUNT_NUMBER;
    }

    public static Purchase getClassFromFactory(Scanner sc) {
        String id = sc.next();
        PurchasesKinds kind = PurchasesKinds.valueOf(id);
        switch (kind) {
            case GENERAL_PURCHASE:
                return new Purchase(sc);
            case GENERAL_PURCHASE_PRICE_DISCOUNT:
                return new PriceDiscountPurchase(sc);
            case GENERAL_PURCHASE_DISCOUNT_NUMBER:
                return new DiscountNumberPurchase(sc);
            default:
                throw new IllegalArgumentException();
        }
    }
}
