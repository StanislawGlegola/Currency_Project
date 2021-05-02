package com.project.nbpAPIcurrency.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

public class JsonReader {

    public static String getDataFromUrl(String url) throws IOException {
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            inputStream = new URL(url).openStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            return readData(bufferedReader);
        } catch (IOException e) {
            throw e;
        } finally {
            closeResource(inputStream);
            closeResource(bufferedReader);
        }
    }

    public static String readData(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int cp;
        while ((cp= reader.read())!=-1){
            stringBuilder.append((char) cp);
        }
        if(stringBuilder.toString().startsWith("[")){
            return removeFirstAndLastCharToKillArrayOfRates(stringBuilder.toString());
        }
        else {
            return stringBuilder.toString();
        }
    }

    private static void closeResource(AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
                //System.out.println("\n" + closeable.getClass().getName() + " CLOSED");
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static String removeFirstAndLastCharToKillArrayOfRates(String s) {
        return (s == null || s.length() == 0)
                ? null
                : (s.substring(1, s.length() - 1));
    }
}
