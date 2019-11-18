package by.gsu.ms42;

import by.gsu.ms42.model.CityWeather;
import by.gsu.ms42.parser.Parser;
import by.gsu.ms42.parser.impl.ParserImpl;
import by.gsu.ms42.util.WidgetCreator;
import com.google.gson.Gson;

import static by.gsu.ms42.util.ApiWeatherConstants.*;

public class idz9Application {

    public static void main(String[] args) {

        WidgetCreator widgetCreator = new WidgetCreator();
        Gson gson = new Gson();
        Parser parser = new ParserImpl();
        String json = "";

        try {
            json = parser.parse(URL_PATH + "weather?q=" + CITY_NAME + "&APPID=" + API_KEY + "&units=metric");
        } catch (Exception e) {
            e.printStackTrace();
        }
        CityWeather cityWeather = gson.fromJson(json, CityWeather.class);
        widgetCreator.createWidget(cityWeather);
    }
}
