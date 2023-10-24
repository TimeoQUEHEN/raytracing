package sae.raytracing;


import sae.raytracing.model.Parser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/" + args[0]);
        if (file.exists()) {
            Parser.reader(file);
        } else {
            System.err.println("File " + args[0] + " not found !");
        }
    }
}
