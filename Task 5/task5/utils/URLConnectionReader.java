package task5.utils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {

    public static String getUrlContents(String theUrl) throws IOException {
        StringBuilder content = new StringBuilder();
        FileWriter fileWriter = new FileWriter("src/main/resources/file.json");

        try
        {
            URL url = new URL(theUrl);


            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

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
