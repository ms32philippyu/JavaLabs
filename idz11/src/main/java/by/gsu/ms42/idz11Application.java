package by.gsu.ms42;

import by.gsu.ms42.connection.ConnectionManager;
import by.gsu.ms42.model.Parallelogram;
import by.gsu.ms42.model.Trapezoid;
import by.gsu.ms42.service.PrinterService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.gsu.ms42.constants.SqlQueries.SELECT_ALL_COORDINATES_AND_LENGTHS;

public class idz11Application {
    public static void main(String[] args) {

        Statement statement;
        ResultSet resultSet;
        List<Trapezoid> trapezoidList = new ArrayList<>();
        List<Parallelogram> parallelogramList = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_COORDINATES_AND_LENGTHS);

            while (resultSet.next()) {
                if (resultSet.getDouble("length1_2") == resultSet.getDouble("length3_4") &&
                        resultSet.getDouble("length2_3") == resultSet.getDouble("length4_1")) {
                    Parallelogram parallelogram = new Parallelogram(resultSet.getInt("x1"), resultSet.getInt("y1"), resultSet.getInt("x2"), resultSet.getInt("y2"),
                            resultSet.getInt("x3"), resultSet.getInt("y3"), resultSet.getInt("x4"), resultSet.getInt("y4"));
                    parallelogramList.add(parallelogram);
                } else {
                    Trapezoid trapezoid = new Trapezoid(resultSet.getInt("x1"), resultSet.getInt("y1"), resultSet.getInt("x2"), resultSet.getInt("y2"),
                            resultSet.getInt("x3"), resultSet.getInt("y3"), resultSet.getInt("x4"), resultSet.getInt("y4"));
                    trapezoidList.add(trapezoid);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrinterService.printCoords(parallelogramList, trapezoidList);
    }
}
