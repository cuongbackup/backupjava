/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progresstest1;


/**
 *
 * @author Administrator
 */
public class TestCircle {
    public static void main(String[] args) {
        Point a = new Point(1, 9);    
        Point b = new Point(5, 3);
        System.out.println("The distance between A(1,9) and B(5,3) is: " + a.getDistance(b));
        Circle c = new Circle((float) 3.211, a);
        Circle d = new Circle(4, b);
        if(c.checkContact(d)){
            System.out.println("Two circle are outer contact");
        }
        else {
            System.out.println("Two circle are not outer contact");
        }
}
}