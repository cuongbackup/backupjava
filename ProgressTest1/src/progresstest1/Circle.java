/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresstest1;

/**
 *
 * @author Administrator
 */
public class Circle implements Shape{
    
    private float r;
    private Point point;

    public Circle() {
        
    }

    public Circle(float r, Point point) {
        this.r = r;
        this.point = point;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }
    
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
    
    public boolean checkContact(Circle c){
        if (this.point.getDistance(c.getPoint()) - (c.r + this.r) <= 0.001){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public float Area() {
        return (float) (2*r*3.14);
    }

    @Override
    public float Circumference() {
        return (float) (r*r*3.14);
    }
    
    
}
