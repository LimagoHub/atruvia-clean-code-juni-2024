package de.atruvia.application.model.internal.newton;

import de.atruvia.application.converter.IntToRGBConverter;

import java.awt.*;

public class IntToRGBConverterNewtonImpl implements IntToRGBConverter {



    @Override
    public int convertIntToRGB(int value) {
        switch (value) {
            case 1: return 0xff0000;
            case 2: return 0xffff00;
            case 3: return 0x0000ff;
            default: return 0x000000;
        }
    }
}
