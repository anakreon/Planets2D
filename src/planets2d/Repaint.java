package planets2d;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Martin Hula
 */

public class Repaint extends Thread {
    private Planets2D main;
    
    public Repaint(Planets2D main) {
        this.main = main;
    }
    
    @Override
    synchronized public void run () {
        while (true) {
            while (main.testRepaint) {
                try {
                    Repaint.sleep(100);
                     main.window.repaint();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
                }
                main.testRepaint = false;
                main.testTime = true;
            }
        }
    }
}
