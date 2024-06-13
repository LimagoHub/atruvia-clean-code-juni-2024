package de.atruvia.application.converter;

import de.atruvia.application.math.Complex;

public interface PixelToComplexConverter {
    Complex convertPixelToComplex(int x, int y);

    public static PixelToComplexConverter reset(Complex linkeUntereEcke, double breite, int size) {
        return new PixelToComplexConverterImpl(linkeUntereEcke, breite, size) ;
    }
}
