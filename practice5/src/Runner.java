import by.gsu.ms32.PricePurchase;
import by.gsu.ms32.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner;
        List<Purchase> purchases = new ArrayList<>();
        try {
            scanner = new Scanner(new FileReader("src/in.csv"));
            while(scanner.hasNextLine()){
                String s = scanner.nextLine();
                String tempArray[] = s.split(";");
                if (tempArray.length == 3){
                    Purchase purchase = new Purchase(tempArray[0],Integer.parseInt(tempArray[1]),Integer.parseInt(tempArray[2]));
                    purchases.add(purchase);
                }else{
                    Purchase pricePurchase = new PricePurchase(tempArray[0],Integer.parseInt(tempArray[1]),Integer.parseInt(tempArray[2]),Double.parseDouble(tempArray[3]));
                    purchases.add(pricePurchase);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("---------Purchases-------");
        for(Purchase p : purchases){
            System.out.println(p);
        }

        System.out.println("\n---------Purchase with index 6--------");
        System.out.println(purchases.get(5));

        ListIterator<Purchase> listIterator = purchases.listIterator();
        while(listIterator.hasNext()){
            if(listIterator.next().getPrice() < 10000){
                listIterator.remove();
            }
        }

        System.out.println("\n---------Purchases with price > 100.00-------");
        for(Purchase p : purchases){
            System.out.println(p);
        }

        Collections.sort(purchases);

        System.out.println("\n---------Sorted list by price-------");
        for(Purchase p : purchases){
            System.out.println(p);
        }

        int foundPurchase = Collections.binarySearch(purchases,new Purchase(null,35000,0));
        System.out.println("\n-------Binary search with price = 350.00");
        System.out.println(foundPurchase);
    }
}
