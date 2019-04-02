import by.gsu.ms32.Purchase;
import by.gsu.ms32.PurchaseFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {

    private static final int ARRAY_SIZE = 6;

    public static void main(String[] args) {
        Scanner scanner = null;
        Purchase purchArray[] = new Purchase[ARRAY_SIZE];
        Purchase maxPurch = new Purchase();
        int flag = 0;
        try{
            scanner = new Scanner(new FileReader("src/in.txt"));
            for (int i = 0; i < purchArray.length; i++) {
                purchArray[i] = PurchaseFactory.getClassFromFactory(scanner);
                if (purchArray[i].getCost() > maxPurch.getCost()){
                    maxPurch = purchArray[i];
                }
                if(i>0) {
                    if (purchArray[i - 1].equals(purchArray[i])) {
                        flag++;
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден");
        }finally {
            scanner.close();
        }

        for (Purchase p: purchArray) {
            System.out.println(p);
        }
        System.out.println("\n-----Покупка с максимальной стоимостью-----");
        System.out.println(maxPurch);
        System.out.println("\n-----Проверка на равенство------");
        if (flag == ARRAY_SIZE){
            System.out.println("Покупки равны");
        }else{
            System.out.println("Покупки не равны");
        }
    }
}
