package de.atruvia.io;

public class ConsoleWriter implements Writer{

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
