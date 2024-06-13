package de.atruvia.application.gui.view.internal;

import de.atruvia.application.gui.presenter.PixelViewPresenter;
import de.atruvia.application.gui.view.GenericPixelView;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class GenericPixelViewAWTImpl implements GenericPixelView {

    private static final int SIZE = 500;
    private BufferedImage image = new BufferedImage(SIZE,SIZE, BufferedImage.TYPE_INT_RGB);
    private final  Fenster fenster = new Fenster();
    private PixelViewPresenter presenter;


    @Override
    public void setPixelViewPresenter(PixelViewPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void show() {
        fenster.setVisible(true);
    }

    @Override
    public void close() {
        fenster.dispose();
    }



    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public void setPixels(int [] feld) {

        image.setRGB(0,0,SIZE,SIZE, feld,0, SIZE);
        fenster.repaint();
    }

    private class MyMouseListener extends MouseAdapter {
        private int x;
        private int y;
        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                presenter.onZoomIn(x,y, e.getX(),e.getY());
            }
            else {
                presenter.onUndoZoom();
            }

        }
    }



    private class Fenster extends Frame {

        public Fenster()  {
            setSize(SIZE,SIZE);
            addMouseListener(new MyMouseListener());
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                   close();
                }
            });
        }

        @Override
        public void paint(Graphics g) {

            g.drawImage(image,0,0,this);
        }
    }
}
