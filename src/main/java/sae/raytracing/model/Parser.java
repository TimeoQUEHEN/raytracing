package sae.raytracing.model;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Parser {

    public boolean skipComment(String line){
        if (line.charAt(0) != '#'){
            return true;
        }
        return false;
    }

    public String[] keyWordInformation(String word, String nameFile){
        try {
            File file=new File(nameFile);
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] tmp = line.split(" ");
                if(skipComment(line) && tmp[0].equals(word)){
                    String[] res = new String[tmp.length-1];
                    for (int i = 1; i < tmp.length; i++) {
                        res[i-1] = tmp[i];
                    }
                    return res;
                }

            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return new String[0];
    }


    public void reader(String nameFile) {
        String geo;
        String[] size = keyWordInformation("size", nameFile);
        String[] output = keyWordInformation("output", nameFile);
        String[] camera = keyWordInformation("camera", nameFile);
        String[] ambient = keyWordInformation("ambient", nameFile);
        String[] geometry = keyWordInformation("", nameFile);
        switch (geometry[0]){
            case "tri":
                System.out.println("triangle");
                break;
            case "sphere":
                System.out.println("sphere");
                break;
            default:
                System.out.println("erreur");
                break;
        }
    }
}
