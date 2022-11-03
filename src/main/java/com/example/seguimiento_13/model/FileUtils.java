package com.example.seguimiento_13.model;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {
    public static String readFile(String path){
        StringBuilder output = new StringBuilder();
        File f = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String line;
            while( (line = reader.readLine()) != null ){
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
    public static void saveData(String path,String ricardo) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(ricardo.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
