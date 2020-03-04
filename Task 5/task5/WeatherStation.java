package task5;

import task5.data.WeatherData;
import task5.display.CurrentConditionsDisplay;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherStation {
    public static void main(String []args)  {
        WeatherData weatherData = new WeatherData();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            try {
                weatherData.getDataFromFile();
                CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
                currentConditionsDisplay.update(weatherData.getMain(),weatherData.getWind(),weatherData.getVisibility());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, 0, 10, TimeUnit.SECONDS);


    }
}
