package by.gsu.ms42.util;

import by.gsu.ms42.model.CityWeather;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WidgetCreator {

    public void createWidget(CityWeather cityWeather){
        File weather = new File("D:\\JavaUniversiry\\JavaLabs\\idz9maven\\src\\main\\java\\by\\gsu\\ms42\\weatherTemplate.html");
        String htmlString = "null";
        try {
            htmlString = FileUtils.readFileToString(weather);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = cityWeather.getName();
        String country = cityWeather.getSys().getCountry();
        String icon = cityWeather.getWeather().get(0).getIcon();
        String description = cityWeather.getWeather().get(0).getDescription();
        String tempCelsius = String.valueOf(cityWeather.getMain().getTemp());
        String pressure = String.valueOf(cityWeather.getMain().getPressure());
        String humidity = String.valueOf(cityWeather.getMain().getHumidity());
        String tempMin = String.valueOf(cityWeather.getMain().getTemp_min());
        String tempMax = String.valueOf(cityWeather.getMain().getTemp_max());
        String speed = String.valueOf(cityWeather.getWind().getSpeed());
        String deg = String.valueOf(cityWeather.getWind().getDeg());
        String cloudsAll = String.valueOf(cityWeather.getClouds().getAll());

        htmlString = htmlString.replace("$name", name);
        htmlString = htmlString.replace("$country", country);
        htmlString = htmlString.replace("$icon", icon);
        htmlString = htmlString.replace("$description", description);
        htmlString = htmlString.replace("$tempCelsius", tempCelsius);
        htmlString = htmlString.replace("$pressure", pressure);
        htmlString = htmlString.replace("$humidity", humidity);
        htmlString = htmlString.replace("$tempMin", tempMin);
        htmlString = htmlString.replace("$tempMax", tempMax);
        htmlString = htmlString.replace("$speed", speed);
        htmlString = htmlString.replace("$deg", deg);
        htmlString = htmlString.replace("$cloudsAll", cloudsAll);

        File newHtmlFile = new File("D:\\JavaUniversiry\\JavaLabs\\idz9maven\\src\\main\\java\\by\\gsu\\ms42\\weatherWidget.html");
        try {
            FileUtils.writeStringToFile(newHtmlFile, htmlString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
