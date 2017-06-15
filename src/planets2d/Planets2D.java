package planets2d;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Martin Huia
 */

public class Planets2D {
    
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    private ArrayList<int[]> coordinates = new ArrayList<int[]>();
    private ArrayList<int[]> coordinatesMin = new ArrayList<int[]>();
    Time time = new Time(this);
    Window window = null;
    Repaint repaint = new Repaint(this);
    boolean testRepaint = false;
    boolean testTime = true;
    boolean start = true;
    
    public Planets2D () {
        run();
    }

    public static void main (String[] args) {
        new Planets2D();
    }
    
    public ArrayList<Planet> getPlanets () {
        return this.planets;
    }
    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }
    
    public ArrayList<int[]> getCoordinates () {
        return coordinates;
    }
    public void setCoordinates (ArrayList<int[]> coordinates, ArrayList<int[]> coordinatesMin) {
        this.coordinates = coordinates;
        this.coordinatesMin = coordinatesMin;
    }
    
    public ArrayList<int[]> getCoordinatesMin () {
        return this.coordinatesMin;
    }
    
    synchronized public void run () {
        this.planets.add(new Planet(80, 2, 20, "Venus"));
        this.planets.get(0).setColor(Color.pink);
        this.planets.add(new Planet(130, 10, 25, "Earth"));
        this.planets.get(1).setColor(Color.BLUE);
        this.planets.add(new Planet(250, 2, 40, "Mars"));
        this.planets.get(2).setColor(Color.RED);
        this.planets.add(new Planet(50, 7, 10, "Mars moon", this.planets.get(2)));
        this.window = new Window(this);
        this.time.start();
        this.repaint.start();
    }
    
    public void loadPlanets () {
        BufferedReader re = null;
        ArrayList <String> data = new ArrayList<String>();
        try {
            re = new BufferedReader(new FileReader("data.txt"));
            while (true) {
                String radek =  re.readLine();
                if (radek == null) {
                    break;
                }
                if (radek.equals("new")) {
                    while (true) {
                      String str = re.readLine();
                        if (str.equals("end")) {
                            break;
                        }
                       data.add(str);
                    }
                    if (data.size() == 15) {
                    this.planets.add(new Planet(Integer.parseInt(data.get(0)),
                        Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)),
                        Integer.parseInt(data.get(3)), data.get(4), data.get(5),
                        data.get(6), data.get(7), new Planet(Integer.parseInt(data.get(8)),
                        Integer.parseInt(data.get(9)), Integer.parseInt(data.get(10)), data.get(11)
                        ),new Color(Integer.parseInt(data.get(12)),Integer.parseInt(data.get(13)),
                        Integer.parseInt(data.get(14)))));
                    } else {
                        this.planets.add(new Planet(Integer.parseInt(data.get(0)),
                            Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2)),
                            Integer.parseInt(data.get(3)), data.get(4), data.get(5),
                            data.get(6), data.get(7), null,new Color(Integer.parseInt(data.get(8)),Integer.parseInt(data.get(9)),
                            Integer.parseInt(data.get(10)))));
                    }
                    data.clear();
                } else {
                    break;
                } 
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(window,"file not found error" , "error", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(window, "file communication error", "error", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(window, "data error", "error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
