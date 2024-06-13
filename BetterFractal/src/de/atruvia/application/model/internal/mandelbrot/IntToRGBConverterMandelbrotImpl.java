package de.atruvia.application.model.internal.mandelbrot;

import de.atruvia.application.converter.IntToRGBConverter;

public class IntToRGBConverterMandelbrotImpl implements IntToRGBConverter {



    @Override
    public int convertIntToRGB(int value) {
        int rot = (value * 3) % 256;
        int gruen = (value * 5) % 256;
        int blau = (value * 11) % 256;
        return (rot << 16) | (gruen << 8) | blau;
    }
}
