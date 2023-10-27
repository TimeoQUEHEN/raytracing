package sae.raytracing.model;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {

    public static void reader(File textFile){
        try {
            Scanner sc = new Scanner(textFile);
            IBuilder builder = new SceneBuilder();
            builder.setAmbient(new Color(0,0,0));
            builder.setShadow(false);
            File imageFile = null;
            Point[] points = new Point[0];
            int index = 0;
            Color diffuse = null;
            Color specular = null;
            int shininess = 0;
            int maxDepth = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (! line.isEmpty() && line.charAt(0) != '#') {
                    String[] keyWord = line.split(" ");
                    switch (keyWord[0]) {
                        case "output" :
                            imageFile = new File(System.getProperty("user.dir") + '/' + keyWord[1]);
                            break;
                        case "size" :
                            builder.setDimensions(Integer.parseInt(keyWord[1]), Integer.parseInt(keyWord[2]));
                            break;
                        case "camera":
                            builder.setCamera(new Camera(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4]),
                                    Double.parseDouble(keyWord[5]),
                                    Double.parseDouble(keyWord[6]),
                                    Double.parseDouble(keyWord[7]),
                                    Double.parseDouble(keyWord[8]),
                                    Double.parseDouble(keyWord[9]),
                                    Double.parseDouble(keyWord[10])));
                            break;
                        case "directional" :
                            builder.addLights(new LightDirectional(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4]),
                                    Double.parseDouble(keyWord[5]),
                                    Double.parseDouble(keyWord[6])));
                            break;
                        case "point" :
                            builder.addLights(new LightPunctual(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4]),
                                    Double.parseDouble(keyWord[5]),
                                    Double.parseDouble(keyWord[6])));
                            break;
                        case "maxverts" :
                            points = new Point[Integer.parseInt(keyWord[1])];
                            break;
                        case "vertex" :
                            points[index++] = new Point(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]));
                            break;
                        case "tri" :
                            builder.addElements(new Triangle(points[Integer.parseInt(keyWord[1])],
                                    points[Integer.parseInt(keyWord[2])],
                                    points[Integer.parseInt(keyWord[3])], diffuse, specular, shininess));
                            break;
                        case "sphere" :
                            builder.addElements(new Sphere(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4]), diffuse, specular, shininess));
                            break;
                        case "plane" :
                            builder.addElements(new Plane(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4]),
                                    Double.parseDouble(keyWord[5]),
                                    Double.parseDouble(keyWord[6]), diffuse, specular, shininess));
                            break;
                        case "ambient" :
                            builder.setAmbient(new Color(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3])));
                            break;
                        case "diffuse" :
                            diffuse = new Color(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]));
                            break;
                        case "specular" :
                            specular = new Color(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]));
                            break;
                        case "shininess" :
                            shininess = Integer.parseInt(keyWord[1]);
                            break;
                        case "shadow" :
                            builder.setShadow(Boolean.parseBoolean(keyWord[1]));
                            break;
                        case "maxdepth" :
                            builder.setMaxDepth(Integer.parseInt(keyWord[1]));
                            break;
                    }
                }
            }
            sc.close();
            RayTracing.generateImage(builder.Scene(), imageFile);
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }
}
