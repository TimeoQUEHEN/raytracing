package sae.lanceurderayons.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    public void reader(String file) {
        try {
            String line;
            String data;
            File myObj = new File("/export/etu/thomas.mouton/IdeaProjects/test/src/sae/lanceurderayons/model/filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if((line = myReader.nextLine()).startsWith("#")) {
                    myReader.nextLine();
                }
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}
