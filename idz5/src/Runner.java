import by.gsu.ms32.MenuAction;
import by.gsu.ms32.Serializator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        Serializator serializator = new Serializator();
        MenuAction menuAction = new MenuAction();


        while(flag) {
            System.out.println("\n==========MENU=========");
            System.out.println("1. Добавить город");
            System.out.println("2. Сериализовать");
            System.out.println("3. Десериализовать");
            System.out.println("4. Общая площадь");
            System.out.println("5. Количество городов-миллионеров");
            System.out.println("6. Завершить работу");
            System.out.println("=======================");
            System.out.println("Введите число, соответствующее пункту menu:");
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    menuAction.addCity();
                    break;
                case 2:
                    menuAction.serialize();
                    break;
                case 3:
                    menuAction.deSerialize();
                    break;
                case 4:
                    menuAction.totalSquare();
                    break;
                case 5:
                    menuAction.countOfMilCity();
                    break;
                case 6:
                    System.out.println("Завершение...");
                    flag = false;
                    break;
            }
        }



    }
}
