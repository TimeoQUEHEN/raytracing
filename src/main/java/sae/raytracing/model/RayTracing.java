package sae.raytracing.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RayTracing {
    public static void generateImage(Scene scene, File outputfile) {
        try {
            BufferedImage image = new BufferedImage(scene.getWidth(), scene.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int line = 0 ; line < scene.getWidth() ; line++) {
                for (int column = 0 ; column < scene.getHeight() ; column++) {
                    image.setRGB(line,column,0);
                }
            }
            ImageIO.write(image, "png", outputfile);
            } catch (IOException e) {
                System.err.println("Error");
            }
    }
}
