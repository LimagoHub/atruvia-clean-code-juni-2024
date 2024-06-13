package de.limago.gui;

import de.limago.math.Complex;
import de.limago.math.Newton;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Stack;


public class NewtonView extends Frame {

    private static final int SIZE = 512;


    private Newton newton = new Newton();

    public NewtonView() {
        addMouseListener(new MyMouseListener());
        setSize(SIZE,SIZE);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

    }




    @Override
    public void paint(Graphics g) {

        long ende, start = System.currentTimeMillis();
        for(int x = 0 ; x < SIZE ; x ++ ){
            for(int y = 0; y < SIZE; y ++) {
                int i = newton.iterate(newton.createC(x, y, SIZE));

                switch (i) {
                    case 1: g.setColor(Color.RED); break;
                    case 2: g.setColor(Color.BLUE); break;
                    case 3: g.setColor(Color.yellow); break;
                    default: g.setColor(Color.BLACK);
                }

                g.drawLine(x, y, x+1, y+1);
            }
        }
        ende = System.currentTimeMillis();
        System.out.println("Duration = " + (ende -start));
    }



    class MyMouseListener extends MouseAdapter {
        Complex linkeUntereEcke ;
        Stack<Newton> stack = new Stack<Newton>();
        @Override
        public void mousePressed(MouseEvent e) {
            linkeUntereEcke = newton.createC(e.getX(), e.getY(), SIZE);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                Complex rechteObereEcke = newton.createC(e.getX(), e.getY(), SIZE);
                double breite = rechteObereEcke.re() - linkeUntereEcke.re();
                double hoehe = rechteObereEcke.im() - linkeUntereEcke.im();
                stack.push(newton);
                newton = new Newton(linkeUntereEcke, breite > hoehe? breite :hoehe);
            } else {
                if(! stack.isEmpty()) {
                    newton = stack.pop();
                }
            }


            repaint();

        }

    }
}
