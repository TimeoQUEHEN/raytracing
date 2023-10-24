package sae.raytracing;


import sae.raytracing.model.Parser;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File textFile = new File(System.getProperty("user.dir") + "/" + args[0]);
        System.out.println(textFile.getName());
        if (textFile.exists()) {
            Parser.reader(textFile);
        } else {
            System.err.println("File : " + args[0] + " not found !");
        }
    }
}
