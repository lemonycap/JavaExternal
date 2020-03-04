package task5.data;

import org.json.simple.*;
import org.json.simple.parser.*;
import task5.utils.Observer;
import task5.utils.Subject;
import task5.utils.URLConnectionReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private JSONObject wind;
    private JSONObject main;
    private long visibility;
    private String url = "http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=7651e70ce9b438882405c5a22d2f93b0";

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }


    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public JSONObject getWind() {
        return wind;
    }

    public JSONObject getMain() {
        return main;
    }

    public long getVisibility() {
        return visibility;
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(main, wind, visibility);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }


    public void setMeasurements(JSONObject main,JSONObject wind,long visibility) throws IOException {
        this.main = main;
        this.wind = wind;
        this.visibility = visibility;
        measurementsChanged();
    }

    public void getDataFromFile() throws IOException {
        URLConnectionReader.getUrlContents(url);
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("src/main/resources/file.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONObject main = (JSONObject) jsonObject.get("main");
            JSONObject wind = (JSONObject) jsonObject.get("wind");
            long visibility = (long) jsonObject.get("visibility");
            setMeasurements(main,wind,visibility);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
