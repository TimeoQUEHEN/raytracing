package sae.raytracing;


import sae.raytracing.model.Parser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/" + "src/main/java/sae/raytracing/essai.txt");
        if (file.exists()) {
            Parser.reader(file);
        } else {
            System.err.println("File " + "test.txt" + " not found !");
        }
    }
}
