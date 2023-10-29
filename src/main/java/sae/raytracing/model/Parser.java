package sae.raytracing.model;

import sae.raytracing.Main;
import sae.raytracing.elements.Plane;
import sae.raytracing.elements.Sphere;
import sae.raytracing.elements.Triangle;
import sae.raytracing.lights.LightDirectional;
import sae.raytracing.lights.LightPunctual;
import sae.raytracing.scene.Camera;
import sae.raytracing.scene.IBuilder;
import sae.raytracing.scene.SceneBuilder;
import sae.raytracing.triplet.Color;
import sae.raytracing.triplet.Point;

import java.io.File;
import java.util.Scanner;

public class Parser {

    /**
     * Read the file to create the elements of the scene with a builder and
     * use it in the call of the method generateImage from RayTracing class
     *
     * @param textFile the file with the text to parse and execute
     */
    public static void reader(File textFile){
        try {
            Scanner sc = new Scanner(textFile); // Creation of a Scanner to read the text file
            IBuilder builder = new SceneBuilder(); // Create the Builder for Scene
            builder.setAmbient(new Color(0,0,0)); // Initialization of the ambient color to black
            builder.setShadow(false); // Initialization of the shadow to false
            builder.setMaxDepth(1); // Initialization of the maxDepth to one
            File imageFile = null;
            Point[] points = new Point[0];
            int index = 0;
            Color diffuse = new Color(0,0,0); // Initialization of the diffuse color to black
            Color specular = new Color(0,0,0); // Initialization of the specular color to black
            int shininess = 1; // Initialization of the shininess color to one
            Color sumLightsColor = new Color(0,0,0); // Initialization of the sum of the lights' color to 0 for all component
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (! line.isEmpty() && line.charAt(0) != '#') {
                    String[] keyWord = line.split("\\s+");
                    if (keyWord.length != 0) {
                        switch (keyWord[0]) {
                            case "output": // Create the file with the name
                                imageFile = new File(System.getProperty("user.dir") + '/' + keyWord[1]);
                                break;
                            case "size": // Give the size of the image to the builder
                                builder.setDimensions(Integer.parseInt(keyWord[1]), Integer.parseInt(keyWord[2]));
                                break;
                            case "camera": // Create and give the camera to the builder
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
                            case "directional": // Create and give the directional light to the builder
                                Color colorD = new Color(Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]));
                                colorComponentIncorrect(colorD); // Verify if the color has correct components value
                                colorComponentIncorrect(sumLightsColor, colorD); // Verify the sum of the lights' color is not incorrect
                                sumLightsColor = new Color(sumLightsColor.addition(colorD.getRgb())); // Add to the light color to the sum
                                builder.addLights(new LightDirectional(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6])));
                                break;
                            case "point": // Create and give the punctual light to the builder
                                Color colorP = new Color(Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]));
                                colorComponentIncorrect(colorP); // Verify if the color has correct components value
                                colorComponentIncorrect(sumLightsColor, colorP); // Verify the sum of the lights' color is not incorrect
                                sumLightsColor = new Color(sumLightsColor.addition(colorP.getRgb())); // Add to the light color to the sum
                                builder.addLights(new LightPunctual(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6])));
                                break;
                            case "maxverts": // Create the real table of points with the good size
                                points = new Point[Integer.parseInt(keyWord[1])];
                                break;
                            case "vertex": // Create a point and add it into the table
                                points[index++] = new Point(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                break;
                            case "tri": // Create and give a triangle to the builder
                                builder.addElements(new Triangle(points[Integer.parseInt(keyWord[1])],
                                        points[Integer.parseInt(keyWord[2])],
                                        points[Integer.parseInt(keyWord[3])], diffuse, specular, shininess));
                                break;
                            case "sphere": // Create and give a sphere to the builder
                                builder.addElements(new Sphere(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]), diffuse, specular, shininess));
                                break;
                            case "plane": // Create and give a plane to the builder
                                builder.addElements(new Plane(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]),
                                        Double.parseDouble(keyWord[4]),
                                        Double.parseDouble(keyWord[5]),
                                        Double.parseDouble(keyWord[6]), diffuse, specular, shininess));
                                break;
                            case "ambient":  // Create and give the real ambient color to the builder
                                Color colorA = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(colorA); // Verify if the color has correct components value
                                builder.setAmbient(colorA);
                                break;
                            case "diffuse": // Change the value of the diffuse color to give it at an element
                                diffuse = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(diffuse); // Verify if the color has correct components value
                                break;
                            case "specular": // Change the value of the specular color to give it at an element
                                specular = new Color(Double.parseDouble(keyWord[1]),
                                        Double.parseDouble(keyWord[2]),
                                        Double.parseDouble(keyWord[3]));
                                colorComponentIncorrect(specular); // Verify if the color has correct components value
                                break;
                            case "shininess": // Change the value of the shininess to give it at an element
                                shininess = Integer.parseInt(keyWord[1]);
                                break;
                            case "shadow": // Give the new value of shadow to the builder
                                builder.setShadow(Boolean.parseBoolean(keyWord[1]));
                                break;
                            case "maxdepth": // Give the max depth for the reflexive lights to the builder
                                builder.setMaxDepth(Integer.parseInt(keyWord[1]));
                                break;
                            case "checker": // Give all the information for a checker to the builder
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
                            default: // If the keyword is unknown
                                throw new Exception("The keyword " + keyWord[0] + " is unknown");
                        }
                    }
                }
            }
            sc.close();
            RayTracing.generateImage(builder.scene(), imageFile);
        }catch (Exception e) {
            Main.logger.warning(e.getMessage());
        }
    }

    /**
     * Throws an exception if the sum has at least one component superior to one
     *
     * @param sum the sum of the lights'color
     * @param color the current color of a new light
     * @throws Exception if the sum has at least one component superior to one
     */
    private static void colorComponentIncorrect(Color sum, Color color) throws Exception {
        if (sum.getRgb().getX() + color.getRgb().getX() > 1 || // Verify if the sum of the red components is superior to one
            sum.getRgb().getY() + color.getRgb().getY() > 1 || // Verify if the sum of the green components is superior to one
            sum.getRgb().getZ() + color.getRgb().getZ() > 1) // Verify if the sum of the blue components is superior to one
            throw new Exception("The sum of the lights' color has at least one component superior to one");
    }

    /**
     * Throw an exception if at least one component is superior to one
     *
     * @param color the current color
     * @throws Exception if at least one component is superior to one
     */
    private static void colorComponentIncorrect(Color color) throws Exception {
        if (color.getRgb().getX() > 1 || color.getRgb().getX() < 0 || // Verify if the red component is superior to one
            color.getRgb().getY() > 1 || color.getRgb().getY() < 0 || // Verify if the green component is superior to one
            color.getRgb().getZ() > 1 || color.getRgb().getZ() < 0) // Verify if the blue component is superior to one
            throw new Exception("At least one of the component of a color is incorrect (must be between 0 and 1)");
    }
}
