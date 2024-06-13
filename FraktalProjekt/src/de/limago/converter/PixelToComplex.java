package de.limago.converter;

import de.limago.math.Complex;

public interface PixelToComplex {

    Complex convert(int x, int y, int size);
    void reset(Complex linkeUntereEcke, double breite);
}
