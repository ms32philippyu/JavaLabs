package by.gsu.ms42.service;

import by.gsu.ms42.model.Parallelogram;
import by.gsu.ms42.model.Trapezoid;

import java.util.List;

public class PrinterService {

    public static void printCoords(List<Parallelogram> parallelogramList, List<Trapezoid> trapezoidList) {
        System.out.println("---------Parallelogram coords----------");
        parallelogramList.forEach(System.out::println);
        System.out.println("---------------------------------------\n");

        System.out.println("---------Trapezoid coords--------------");
        trapezoidList.forEach(System.out::println);
        System.out.println("---------------------------------------\n");
    }
}
