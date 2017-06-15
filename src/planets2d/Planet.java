package planets2d;

import java.awt.Color;

/**
 * @author Martin Hula
 */

public class Planet {
    private int planetRadius = 0;
    private int radius = 0;
    private int velocity = 0;
    private int circumference = 0;
    private String name = "Unknown";
    private String realVelocity = "";
    private String realRadius = "";
    private String description = "";
    private Planet parent = null;
    private Color color = new Color(100, 100, 100);
    
    public Planet (int radius, int velocity, String name, String realVelocity, String realRadius, String description) {
        this.radius = radius;
        this.velocity = velocity;
        this.name = name;
        this.realVelocity = realVelocity;
        this.realRadius = realRadius;
        this.description = description;
    }
    
    public Planet (int radius, int velocity, int planetRadius, String name) {
        this.radius = radius;
        this.velocity = velocity;
        this.name = name;
        this.planetRadius = planetRadius;
    }
    
    public Planet (int radius, int velocity, int planetRadius, String name, Planet parent) {
        this.radius = radius;
        this.velocity = velocity;
        this.name = name;
        this.planetRadius = planetRadius;
        this.parent = parent;
    }
    
    public Planet () {}
    
    public Planet (int planetRadius, int radius, int velocity, int circumference, String name, String realVelocity, String realRadius, String description, Planet parent, Color color) {
        this.planetRadius = planetRadius;
        this.radius = radius;
        this.velocity = velocity;
        this.circumference = circumference;
        this.name = name;
        this.realVelocity = realVelocity;
        this.realRadius = realRadius;
        this.description = description;
        this.parent = parent;
        this.color = color;
    }
    
    public String getName () {
        return this.name;
    }
    public void setName (String name) {
        this.name = name;
    }
    
    public int getRadius () {
        return this.radius;
    }
    public void setRadius (int radius) {
        this.radius = radius;
    }
    
    public String getDescription () {
        return this.description;
    }
    public void setDescription (String description) {
        this.description = description;
    }
    
    public int getVelocity () {
        return this.velocity;
    }
    public void setVelocity (int velocity) {
        this.velocity = velocity;
    }
    
    public String getRealRadius () {
        return this.realRadius;
    }
    public void setRealRadius (String realRadius) {
        this.realRadius = realRadius;
    }
    
    public String getRealVelocity () {
        return this.realVelocity;
    }
    public void setRealVelocity (String realVelocity) {
        this.realVelocity = realVelocity;
    }
    
    public int getCircumference () {
        return this.circumference;
    }
    public void setCircumference (int circumference) {
        this.circumference = circumference;
    }
    
    public int getPlanetRadius () {
        return this.planetRadius;
    }
    public void setPlanetRadius (int planetRadius) {
        this.planetRadius = planetRadius;
    }
    
    public String toString () {
        return this.name;
    }
    
    public Color getColor () {
        return this.color;
    }
    public void setColor (Color color) {
        this.color = color;
    }
    
    public Planet getParent () {
        return this.parent;
    }
}
