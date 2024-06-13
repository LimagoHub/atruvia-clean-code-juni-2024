package de.atruvia.application.converter;

import de.atruvia.application.math.Complex;

public class PixelToComplexConverterImpl implements PixelToComplexConverter {

    private Complex linkeUntereEcke;
    private double breite;
    private int size;

    /* */ PixelToComplexConverterImpl(Complex linkeUntereEcke, double breite, int size) {
        this.linkeUntereEcke = linkeUntereEcke;
        this.breite = breite;
        this.size = size;
    }

    public Complex convertPixelToComplex(int x, int y) {
        double delta = breite /  size;
        return new Complex(linkeUntereEcke.re() + x * delta, linkeUntereEcke.im() + y * delta);
    }



}
