import by.gsu.ms32.MenuAction;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        MenuAction menuAction = new MenuAction();

        while (flag){
            System.out.println("\n==========MENU=========");
            System.out.println("1. Добавить клиента(*ов)");
            System.out.println("2. Список клиентов");
            System.out.println("3. Поиск счёта. Возможность заблокировать/разблокировать счёт");
            System.out.println("4. Общий счёт. Положительный и отрицательный баланс");
            System.out.println("5. Закончить работу ");
            System.out.println("=======================");
            System.out.println("Введите число, соответствующее пункту menu:");
            int i = scanner.nextInt();
            switch (i){
                case 1:
                    menuAction.addClient();
                    break;
                case 2:
                    menuAction.showClients();
                    break;
                case 3:
                    menuAction.search();
                    break;
                case 4:
                    menuAction.totalAmount();
                    break;
                case 5:
                    System.out.println("Завершение...");
                    flag = false;
                    break;
            }

        }

    }
}
