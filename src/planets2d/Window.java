package planets2d;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 * @author Martin Hula
 */

public class Window extends JFrame {
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel controlPanel = new JPanel(new GridBagLayout());
    private Planets2D main;
    private PlanetCanvas canvas;
    private JLabel title = new JLabel("   Solar system");
    private JComboBox list = new JComboBox();
    private JTextArea data = new JTextArea();
    private JButton start = new JButton("Stop");
    private JSlider slider = new JSlider(1, 3);
    
    Window (Planets2D main) {
        this.main = main;
        canvas = new PlanetCanvas(main);
        jbInit();
    }
    
    private void jbInit () {
        this.getContentPane().setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.WEST);
        controlPanel.setPreferredSize(new Dimension(400, 1000));
        mainPanel.add(canvas, BorderLayout.CENTER);
        this.setBounds(0, 0, 1300, 1000);
        controlPanel.setLayout(new GridLayout(6, 1));
        controlPanel.add(title);
        fillComboBox();
        controlPanel.add(list);
        controlPanel.add(data);
        data.setPreferredSize(new Dimension(400, 500));
        controlPanel.add(start);
        data.setEditable(false);
        controlPanel.add(slider);
        slider.setMinimum(1);
        slider.setMaximum(4);
        list.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged (java.awt.event.ItemEvent evt) {
                listItemStateChanged(evt);
            }
        });

        start.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                startActionPerformed(e);
            }
        });
        list.setSelectedIndex(1);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
    
    @Override
    public void repaint () {
        super.repaint();
        this.canvas.repaint();
    }
    
    private void fillComboBox () {
        ArrayList<Planet> arr = main.getPlanets();
        for (int i = 0; i < arr.size(); i++) {
            list.addItem(arr.get(i));
        }
    }
    
    private void listItemStateChanged (ItemEvent evt) {
        Planet planet = (Planet) list.getSelectedItem();
        data.setText("");
        data.append("   Subject information:" + "\n");
        data.append("   Subject name " + planet.getName() + "\n");
        data.append("   planet radius: " + planet.getRealRadius() + "km" + "\n");
        data.append("   subject velocity " + planet.getRealVelocity() + "km/s" + "\n");
        data.append("   description: " + planet.getDescription());
    }
    
    private void startActionPerformed (ActionEvent e) {
        if (main.start) {
            main.start = false;
            start.setText("Start");
        } else {
            main.start = true;
            start.setText("Stop");
        }
    }
    
    public PlanetCanvas getCanvas () {
        return this.canvas;
    }
    public int getSliderValue (){
        return this.slider.getValue();
    }
}
