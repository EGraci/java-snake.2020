/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationlatihan;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Andre
 */
public class ClassUlar {
    private int[] x;
    private int[] y;
    private  int dx;
    private int dy;
    private int jum;

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getJum() {
        return jum;
    }

    public void setJum(int jum) {
        this.jum = jum;
    }
        
    
    public ClassUlar() {
        x = new int[20];
        y = new int[20];
        dx = 10;
        dy = 0;
        x[0] = 100;
        y[0] = 100;
        jum = 6;
        for (int i=1;i<=jum-1;i++)
        {
            x[i] = x[i-1]-10;
            y[i] = y[i-1];
        }
    }
    public void gerak_ular()
    {
     x[0] = x[0] + dx;
     y[0] = y[0] + dy;

     for (int i = jum-1;i>=1;i--)
     {        
        x[i] = x[i-1];
        y[i] = y[i-1];
     }
    }
    public void gambar_ular(Graphics g){
        
        g.setColor(Color.RED);
        
        for (int i = 0;i<= jum-1;i++)
        {         
            g.drawRect(x[i], y[i], 10, 10);
        }                        
    }
   
    
}
