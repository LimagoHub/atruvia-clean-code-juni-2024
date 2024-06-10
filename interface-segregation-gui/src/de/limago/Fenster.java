package de.limago;

import java.awt.*;
import java.awt.event.*;


public class Fenster extends Frame {


    public Fenster()  {

        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->beenden());
        addWindowListener(new MyWindowListener());
        add(button);

    }

    private void ausgabe() {
        System.out.println("Button wurde gedrückt");
    }

    private void beenden() {
        // Daten retten
        dispose();
    }

    public static void main(String[] args) {

        new Fenster().setVisible(true);
    }

    /*private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           ausgabe();
        }
    }*/

    private class MyWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            beenden();
        }
    }
}
