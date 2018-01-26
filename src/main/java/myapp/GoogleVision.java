package myapp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GoogleVision {
    private static final String TARGET_URL =
            "https://vision.googleapis.com/v1/images:annotate?";
    private static final String API_KEY =
            "key=AIzaSyCRxstIgjv3bTG6bLi1FbcKItcQqu3Xs80";
public static String run () throws IOException{
        URL serverUrl = new URL(TARGET_URL + API_KEY);
        URLConnection urlConnection = serverUrl.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection)urlConnection;
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("Content-Type", "application/json");
        httpConnection.setDoOutput(true);
        BufferedWriter httpRequestBodyWriter = new BufferedWriter(new
                OutputStreamWriter(httpConnection.getOutputStream()));
        httpRequestBodyWriter.write
                ("{\"requests\":  [{ \"features\":  [ {\"type\": \"LABEL_DETECTION\""
                        +"}], \"image\": {\"source\": { \"imageUri\":"
                        +" \"https://www.maangchi.com/wp-content/uploads/2009/02/jeonbok.jpg\"}}}]}");
        httpRequestBodyWriter.close();
        String response = httpConnection.getResponseMessage();
        if (httpConnection.getInputStream() == null) {
            System.out.println("No stream");
            return "No Stream";
        }

        Scanner httpResponseScanner = new Scanner (httpConnection.getInputStream());
        String resp = "";
        while (httpResponseScanner.hasNext()) {
            String line = httpResponseScanner.nextLine();
            resp += line;
            //System.out.println(line);  //  alternatively, print the line of response
        }
        httpResponseScanner.close();
        return resp;
    }
}