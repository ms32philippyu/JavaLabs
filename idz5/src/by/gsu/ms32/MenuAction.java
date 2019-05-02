package by.gsu.ms32;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuAction {

    private Scanner scanner = new Scanner(System.in);
    private List<City> cities = new ArrayList<>();
    private Serializator serializator = new Serializator();
    private String file = "src/in.txt";

    public void addCity(){
        boolean flag = true;
        String newName;
        int newPopulation;
        double newSquare;

        try {
            while(flag){
                System.out.println("Введите название города:");
                newName = scanner.next();
                System.out.println("Введите населённость города:");
                newPopulation = scanner.nextInt();
                System.out.println("Введите площадь города:");
                newSquare = scanner.nextDouble();
                cities.add(new City(newName,newPopulation,newSquare));
                System.out.println("Хотели бы зарегистрировать новый город?(Да/Нет)");
                String s1 = scanner.next();
                if(s1.equals("Да")){
                    flag = true;
                }else{
                    flag = false;
                }
            }
        }catch (InputMismatchException e){
            System.out.println(e + " - Данные введены некорректно");
        }catch (OutOfMemoryError o){
            System.out.println(o + " - Недостаточно памяти");
        }
    }

    public void serialize(){
        System.out.println("Сериализация...");
        for (City city : cities){
            serializator.serialization(city,file);
        }
    }

    public void deSerialize(){
        System.out.println("Десериализация...");
        City res = null;
        try {
            res = serializator.deserialization(file);
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }
        System.out.println(res);
    }

    public void totalSquare(){
        double totalSquare = 0;
        try {
            for(City city : cities){
                totalSquare += city.getSquare();
            }
        }catch (ArithmeticException e){
            System.out.println(e + "Ошибка вычислений!");
        }

        System.out.println("Общая площадь городов = " + totalSquare);
    }

    public void countOfMilCity(){
        int count = 0;
        try {
            for (City city : cities){
                if(city.getPopulation() >= 1000000){
                    count++;
                }
            }
        }catch (ArithmeticException e){
            System.out.println(e + "Ошибка вычислений!");
        }

        System.out.println("Количество городов-миллионеров = " + count);
    }
}
