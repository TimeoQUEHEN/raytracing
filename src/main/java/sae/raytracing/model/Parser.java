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
            builder.setMaxDepth(1);
            File imageFile = null;
            Point[] points = new Point[0];
            int index = 0;
            Color diffuse = null;
            Color specular = null;
            int shininess = 1;
            Color sumLightsColor = new Color(0,0,0);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (! line.isEmpty() && line.charAt(0) != '#') {
                    String[] keyWord = line.split("\\s+");
                    if (keyWord.length != 0) {
                        switch (keyWord[0]) {
                            case "output":
                                imageFile = new File(System.getProperty("user.dir") + '/' + keyWord[1]);
                                break;
                            case "size":
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
                            case "directional":
                                Color colorD = new Color(Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]));
                                colorComponentIncorrect(sumLightsColor, colorD);
                                sumLightsColor = new Color(sumLightsColor.addition(colorD.getRgb()));
                                builder.addLights(new LightDirectional(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6])));
                                break;
                            case "point":
                                Color colorP = new Color(Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]));
                                colorComponentIncorrect(sumLightsColor, colorP);
                                sumLightsColor = new Color(sumLightsColor.addition(colorP.getRgb()));
                                builder.addLights(new LightPunctual(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6])));
                                break;
                            case "maxverts":
                                points = new Point[Integer.parseInt(keyWord[1])];
                                break;
                            case "vertex":
                                points[index++] = new Point(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                break;
                            case "tri":
                                builder.addElements(new Triangle(points[Integer.parseInt(keyWord[1])],
                                        points[Integer.parseInt(keyWord[2])],
                                        points[Integer.parseInt(keyWord[3])], diffuse, specular, shininess));
                                break;
                            case "sphere":
                                builder.addElements(new Sphere(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]), diffuse, specular, shininess));
                                break;
                            case "plane":
                                builder.addElements(new Plane(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]), diffuse, specular, shininess));
                                break;
                            case "ambient":
                                Color colorA = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(colorA);
                                builder.setAmbient(colorA);
                                break;
                            case "diffuse":
                                diffuse = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(diffuse);
                                break;
                            case "specular":
                                specular = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(specular);
                                break;
                            case "shininess":
                                shininess = Integer.parseInt(keyWord[1]);
                                break;
                            case "shadow":
                                builder.setShadow(Boolean.parseBoolean(keyWord[1]));
                                break;
                            case "maxdepth":
                                builder.setMaxDepth(Integer.parseInt(keyWord[1]));
                                break;
                            case "checker":
                                Color color1 = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(color1);
                                Color color2 = new Color(Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]));
                                colorComponentIncorrect(color2);
                                builder.setCheckerAll(true, color1, color2, Double.parseDouble(keyWord[7]));
                                break;
                            default:
                                throw new Exception("The keyword " + keyWord[0] + " is unknown");
                        }
                    }
                }
            }
            sc.close();
            RayTracing.generateImage(builder.Scene(), imageFile);
        }catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void colorComponentIncorrect(Color sum, Color color) throws Exception {
        if (sum.getRgb().getX() + color.getRgb().getX() > 1 ||
            sum.getRgb().getY() + color.getRgb().getY() > 1 ||
            sum.getRgb().getZ() + color.getRgb().getZ() > 1)
            throw new Exception("The sum of the lights' color has at least one compenent superior to one");
    }

    private static void colorComponentIncorrect(Color color) throws Exception {
        if (color.getRgb().getX() > 1 || color.getRgb().getX() < 0 ||
            color.getRgb().getY() > 1 || color.getRgb().getY() < 0 ||
            color.getRgb().getZ() > 1 || color.getRgb().getZ() < 0)
            throw new Exception("At least one of the component of a color is incorrect (must be between 0 and 1)");
    }
}
