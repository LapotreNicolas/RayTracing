package sae.raytracing.model;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Parser {

    public static Scene reader(File textFile){
        try {
            Scanner sc = new Scanner(textFile);
            IBuilder builder = new SceneBuilder();
            File imageFile;
            Point[] points = new Point[0];
            int index = 0;
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.charAt(0) != '#') {
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
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[6]),
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
                                    points[Integer.parseInt(keyWord[3])]));
                            break;
                        case "sphere" :
                            builder.addElements(new Sphere(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4])));
                            break;
                        case "plane" :
                            builder.addElements(new Plane(Double.parseDouble(keyWord[1]),
                                    Double.parseDouble(keyWord[2]),
                                    Double.parseDouble(keyWord[3]),
                                    Double.parseDouble(keyWord[4]),
                                    Double.parseDouble(keyWord[5]),
                                    Double.parseDouble(keyWord[6])));
                            break;
                        case "ambient" :
                            // not implement yet
                            break;
                        case "diffuse" :
                            // not implement yet
                            break;
                        case "specular" :
                            // not implement yet
                            break;
                        case "shininess" :
                            // not implement yet
                            break;
                    }
                }
            }
            sc.close();
            return builder.Scene();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            return null;
        }
    }
}
