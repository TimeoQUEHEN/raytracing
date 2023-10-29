package sae.raytracing;


import sae.raytracing.model.Parser;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + '/' + args[0]);
        if (file.exists()) {
            Parser.reader(file);
        } else {
            logger.log(Level.WARNING, "Something went wrong: {0} ", args[0]);
        }
    }
}
