package by.gsu.ms32;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAction {
    List<Client> clients = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addClient(){

        System.out.println("Заполните анкету(*ы)(Один клиент банка может иметь до 2 счетов)");
        System.out.println("----------------------------------------------------------------");

        boolean flag = true;
        String newFirstName;
        String newLastName;
        String newPassport;
        List<BankAccount> newBankAccounts = new ArrayList<>();

        while(flag){
            newBankAccounts = null;
            newBankAccounts = new ArrayList<>();
            System.out.println("Введите Имя");
            newFirstName = scanner.next();
            System.out.println("Введите Фамилию");
            newLastName = scanner.next();
            System.out.println("Введите номер пасспорта");
            newPassport = scanner.next();
            System.out.println("Введите номер счёта, баланс и статус(false = заблокирован/true = разблокирован)");
            newBankAccounts.add(new BankAccount(scanner.next(),scanner.nextInt(),scanner.nextBoolean()));
            System.out.println("Хотели бы добавить второй счёт?(Да/Нет)");
            String s = scanner.next();
            if(s.equals("Да")){
                System.out.println("Введите номер счёта, баланс и статус(false = заблокирован/true = разблокирован)");
                newBankAccounts.add(new BankAccount(scanner.next(),scanner.nextInt(),scanner.nextBoolean()));
            }
            clients.add(new Client(newFirstName,newLastName,newPassport, newBankAccounts));
            System.out.println("Хотели бы зарегистрировать нового клиента?(Да/Нет)");
            String s1 = scanner.next();
            if(s1.equals("Да")){
                flag = true;
            }else{
                flag = false;
            }
        }
    }

    public void showClients(){
        if(!clients.isEmpty()) {
            System.out.println("Список клиентов:");
            for (Client client : clients) {
                System.out.println(client);
            }
        }else{
            System.out.println("Список клиентов пуст\n");
        }
    }

    public void search(){
        System.out.println("Введите номер счёта:");
        String accountName = null;
        int balance = 0;
        boolean status = false;
        boolean newStatus;
        String s = scanner.next();
        boolean flag = false;

        for (Client client : clients) {
            for (int j = 0; j < client.getBankAccounts().size(); j++) {
                if (s.equals(client.getBankAccounts().get(j).getAccountName())) {
                    accountName = client.getBankAccounts().get(j).getAccountName();
                    balance = client.getBankAccounts().get(j).getBalance();
                    status = client.getBankAccounts().get(j).isStatus();
                    flag = true;
                    if (flag) {
                        System.out.println("Ваш номер счёта:" + accountName);
                        System.out.println("Баланс счёта:" + Byn.toByn(balance));
                        System.out.println("Статус счёта:" + status);
                        System.out.println();
                    }
                    System.out.println("Желаете заблокировать/разблокировать счёт? (Да/Нет)");
                    String s1 = scanner.next();
                    if (s1.equals("Да")){
                        System.out.println("Введите новый статус счёта(false = заблокирован/true = разблокирован):");
                        newStatus = scanner.nextBoolean();
                        client.getBankAccounts().get(j).setStatus(newStatus);
                    }
                    break;
                }
            }
        }

        if(!flag)
            System.out.println("!Вы ввели некорректные данные, либо такого счёта не существует!\n");

    }

    public void totalAmount(){
        System.out.println("Введите номер паспорта:");
        String newPassport;
        boolean flag = false;
        int totalAmount = 0;
        int positiveBalance = 0;
        int negativeBalance = 0;
        newPassport = scanner.next();
        for(Client client : clients){
            if (newPassport.equals(client.getPassport())){
                for (int j = 0; j < client.getBankAccounts().size(); j++){
                    totalAmount += client.getBankAccounts().get(j).getBalance();
                    if(client.getBankAccounts().get(j).isStatus()){
                        positiveBalance += client.getBankAccounts().get(j).getBalance();
                    }else{
                        negativeBalance += client.getBankAccounts().get(j).getBalance();
                    }
                }
                flag = true;
                System.out.println("Общий баланс: " + Byn.toByn(totalAmount));
                System.out.println("Положительный баланс: " + Byn.toByn(positiveBalance));
                System.out.println("Отрицательный баланс: " + Byn.toByn(negativeBalance));
                break;
            }
        }
        if(!flag)
            System.out.println("!Вы ввели некорректные данные, либо такой номер пасспорта не существует!\n");
    }


}
