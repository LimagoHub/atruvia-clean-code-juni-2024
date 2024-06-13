package de.limago.converter.impl;

import de.limago.converter.ColorConverter;

public class MandelbrotColorConverterImpl implements ColorConverter {
    @Override
    public int convertIntToRGB(int value) {
        int rot = (value * 3) % 256;
        int gruen = (value * 5) % 256;
        int blau = (value * 11) % 256;

        return rot << 16 | gruen << 8 | blau;




    }
}
