/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class CalModel {
    private float num1;
    private float num2;
    private String op;
    
    public CalModel() {
        
    }

    public CalModel(float num1, float num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public float getNum1() {
        return num1;
    }

    public void setNum1(float num1) {
        this.num1 = num1;
    }

    public float getNum2() {
        return num2;
    }

    public void setNum2(float num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
    
    public float calculate() {
        if(op.equals("+")) return num1 + num2;
        if(op.equals("-")) return num1 - num2;
        if(op.equals("*")) return num1 * num2;
        return num1 / num2;
    }

    @Override
    public String toString() {
        return num1+" "+ op +" "+num2+" = "+calculate();
    }
}
