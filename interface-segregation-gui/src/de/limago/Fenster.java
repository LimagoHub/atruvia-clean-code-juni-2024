package de.limago;

import java.awt.*;
import java.awt.event.*;


public class Fenster extends Frame {


    public Fenster()  {

        setSize(300, 300);
        Button button = new Button("Drück mich");
        button.addActionListener(e->ausgabe());
        add(button);

    }



    public static void main(String[] args) {

        new Fenster().setVisible(true);
    }

    private void ausgabe() {
        System.out.println("Button wurde gedrückt");
    }

//   private class MyActionListner implements ActionListener {
//
//       @Override
//       public void actionPerformed(ActionEvent e) {
//           ausgabe();
//       }
//   }
}
