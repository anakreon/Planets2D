package planets2d;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Martin Hula
 */

public class PlanetCanvas extends Canvas {
    ArrayList<int[]> coordinates = new ArrayList<int[]>();
    ArrayList<int[]> coordinatesMin = new ArrayList<int[]>();
    ArrayList<Planet> pla = new ArrayList<Planet>();
    Planets2D main;
    boolean first = true;
    int i = 0;
    
    public PlanetCanvas (Planets2D main) {
        this.main = main;
        this.setBackground(Color.BLACK);
        this.setSize(600, 600);
    }
    
    @Override
    public void repaint () {
        i++;
        if (first == false) {
            coordinates = main.getCoordinates();
            coordinatesMin = main.getCoordinatesMin();
            pla = main.getPlanets();
        }

        Graphics g = this.getGraphics();
        g.setColor(Color.YELLOW);
        g.fillOval(this.getWidth() / 2, this.getHeight() / 2, 50, 50);
        for (int j = 0; j < coordinates.size(); j++) {
            g.setColor(Color.BLACK);
            g.fillOval(coordinatesMin.get(j)[0] + coordinatesMin.get(j)[3],
                    coordinatesMin.get(j)[1] + coordinatesMin.get(j)[4], coordinatesMin.get(j)[2],
                    coordinatesMin.get(j)[2]);
            g.setColor(pla.get(j).getColor());
            g.fillOval(coordinates.get(j)[0] + coordinates.get(j)[3],
                    coordinates.get(j)[1] + coordinates.get(j)[4], coordinates.get(j)[2],
                    coordinates.get(j)[2]);
        }
        if (i > 10) {
            first = false;
        }
    }
    
}
