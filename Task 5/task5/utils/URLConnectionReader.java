package task5.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
   /* public static void main(String[] args)
    {
        String output  = null;
        try {
            output = getUrlContents("http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=7651e70ce9b438882405c5a22d2f93b0");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(output);
    }*/

    public static String getUrlContents(String theUrl) throws IOException {
        StringBuilder content = new StringBuilder();
        FileWriter fileWriter = new FileWriter("file.json");
        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");

            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        fileWriter.write(content.toString());
        fileWriter.flush();
        fileWriter.close();
        return content.toString();
    }


}
