package planets2d;

import java.util.ArrayList;

/**
 * @author Martin Hula
 */

public class Time extends Thread {
    private Planets2D main;
    private long t = 1;
    private long velocity = 2000;
    
    public Time (Planets2D main) {
        this.main = main;
    }
    
    @Override
    synchronized public void run () {
        while (true) {
            while (main.testTime & main.start) {
                ArrayList<Planet> planety = main.getPlanets();
                ArrayList<int[]> coordinates = new ArrayList<int[]>();
                ArrayList<int[]> coordinatesMin = main.getCoordinates();
                int zrychleni = main.window.getSliderValue();
                
                double uhel;

                if (t == 0) {
                    uhel = 0;
                } else {
                    uhel = ((2 * Math.PI) / velocity * zrychleni) * t;
                }
                tick();
                for (int i = 0; i < planety.size(); i++) {
                    int x = (int) (planety.get(i).getRadius() * Math.cos(uhel * planety.get(i).getVelocity()));
                    int y = (int) (planety.get(i).getRadius() * Math.sin(uhel * planety.get(i).getVelocity()));
                    int xRodice = main.window.getCanvas().getWidth() / 2;
                    int yRodice = main.window.getCanvas().getHeight() / 2;
                    if (planety.get(i).getParent() != null) {
                        xRodice += (int) (planety.get(i).getParent().getRadius() * Math.cos(uhel * planety.get(i).getParent().getVelocity()));
                        yRodice += (int) (planety.get(i).getParent().getRadius() * Math.sin(uhel * planety.get(i).getParent().getVelocity()));
                    }
                    int[] planetCoordinates = { x, y, planety.get(i).getPlanetRadius(), xRodice, yRodice };

                    coordinates.add(planetCoordinates);
                }
                if (main.testTime) {
                    main.setCoordinates(coordinates, coordinatesMin);

                    main.testTime = false;
                    main.testRepaint = true;

                    this.yield();
                }
            }
        }
    }
    
    private void tick () {
        t++;
        if (t > 2000) {
            t = 1;
        }
    }
}
