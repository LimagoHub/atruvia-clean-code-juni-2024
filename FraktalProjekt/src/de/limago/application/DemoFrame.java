package de.limago.application;

import java.awt.*;
import java.awt.image.*;

public class DemoFrame extends Frame {


    private static final int SIZE = 300;
    private BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);
    //private int feld [] = new int[SIZE*SIZE];
    public DemoFrame()  {
        setSize(SIZE,SIZE);


//        for (int i = 0; i < SIZE * SIZE - 1; i++) {
//            feld[i] = 0xffaaaa;
//        }
//
//        image.setRGB(0,0,SIZE,SIZE, feld,0, SIZE);
    }

    public void setPixels(int feld[]) {
        
        image.setRGB(0,0,SIZE,SIZE, feld,0, SIZE);
        repaint();
    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(image,0,0,this);
    }

    public static void main(String[] args) {

        DemoFrame d = new DemoFrame();
        d.setVisible(true);
        int feld [] = new int[SIZE*SIZE];
        for (int i = 0; i < SIZE * SIZE - 1; i++) {
            feld[i] = 0xffaaaa;
        }
        d.setPixels(feld);
    }
}
