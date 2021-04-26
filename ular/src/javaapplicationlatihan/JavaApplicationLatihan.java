/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationlatihan;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Andre
 */
public class JavaApplicationLatihan extends JFrame implements KeyListener, Runnable {

    /**
     * @param args the command line arguments
     */

    public static final int CANVAS_WIDTH  = 500;
    public static final int CANVAS_HEIGHT = 500; 
    public ClassUlar ular;
    public int x, y;
    public int dx, dy;
    Thread waktu;
    public JavaApplicationLatihan(){ 
        ular = new ClassUlar();
       waktu= new Thread(this);
        waktu.start(); 
        x = 100;
        y = 100;
        dx = 10;
        dy = 0;
        addKeyListener(this);
        setSize(500,500);
        setVisible(true);                    
    }
    
    public void paint(Graphics g) {   
      // Memanggil metoda paint dari superclass
      super.paint(g); 
      // Mengatur warna
      g.setColor(Color.RED);
      g.drawRect(x, y, 10, 10); 
      ular.gambar_ular(g);
   }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        JavaApplicationLatihan latihan = new JavaApplicationLatihan();    
 
    }

    @Override
    public void keyTyped(KeyEvent e) {
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int keycode = e.getKeyCode();
            
            switch (keycode) {
                //delete record table
                case KeyEvent.VK_W:
                    dx = 0;
                    dy=-10;
                    ular.setDx(dx);
                    ular.setDy(dy);
                    break;
                case KeyEvent.VK_A:
                    dx = -10;
                    dy=0;
                    ular.setDx(dx);
                    ular.setDy(dy);

                    break;
                case KeyEvent.VK_S:
                    dx = 0;
                    dy=10;
                    ular.setDx(dx);
                    ular.setDy(dy);
                    break;
                case KeyEvent.VK_D:
                    dx = 10;
                    dy=0;
                    ular.setDx(dx);
                    ular.setDy(dy);
                    break;
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }              

    @Override
    public void run() {
                do {                    
                    //System.out.println("javaapplicationlatihan.JavaApplicationLatihan.run()");
                    ular.gerak_ular();
                    x = x +  dx;
                    y = y + dy;
                repaint();
                
                try {
                    Thread.sleep(100); //berhenti selama frameDelay=100
                }catch(InterruptedException ex){}
        } while (true);
    }

    

   
}

