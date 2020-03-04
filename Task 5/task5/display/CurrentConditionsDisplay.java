package task5.display;

import org.json.simple.JSONObject;
import task5.utils.DisplayElement;
import task5.utils.Observer;
import task5.utils.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private JSONObject main;
    private JSONObject wind;
    private long visibility;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("General conditions: " + main + "\nWind: " + wind + "\nVisibility: " + visibility);
    }


    public void update(JSONObject main, JSONObject wind, long visibility) {
        this.main = main;
        this.wind = wind;
        this.visibility = visibility;
        display();
    }
}
