/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progresstest1;

import java.lang.Math;

/**
 *
 * @author Administrator
 */
public class Point {
    private float x;
    private float y;

    public Point() {
        
    }
    
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
       

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    public float getDistance(Point p2) {
        return (float) (Math.sqrt((p2.x-this.x)*(p2.x-this.x)+(p2.y-this.y)*(p2.y-this.y)));
    }
        
    public void getPoint(float x, float y) {
        System.out.println("Point: (" + x + ", )" + y);
    }
}
