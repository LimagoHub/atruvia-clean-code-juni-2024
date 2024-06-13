package de.limago.converter.impl;

import de.limago.converter.ColorConverter;

import java.awt.*;

public class NewtonColorConverterImpl implements ColorConverter {
    @Override
    public int convertIntToRGB(int value) {
        int result = 0;
        switch (value) {
            case 1:result = 0xff0000; break;
            case 2: result = 0x0000ff; break;
            case 3: result = 0xffff00; break;

        }
        return result;
    }
}
