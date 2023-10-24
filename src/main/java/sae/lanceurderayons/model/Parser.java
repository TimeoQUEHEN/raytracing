package sae.lanceurderayons.model;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    public void reader(String nameFile) {
        try {
            File file=new File(nameFile);
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                if(line.charAt(0) != '#'){
                    System.out.println(line);
                }
            }
            sc.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

}
