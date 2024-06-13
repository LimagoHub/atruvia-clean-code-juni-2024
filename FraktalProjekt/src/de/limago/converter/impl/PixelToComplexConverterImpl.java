package de.limago.converter.impl;

import de.limago.converter.PixelToComplex;
import de.limago.math.Complex;

public class PixelToComplexConverterImpl implements PixelToComplex {

    private Complex linkeUntereEcke;
    private double breite;

//    public PixelToComplexConverterImpl() {
//        this(new Complex(-2.0, -1.25), 2.5);
//    }

    public PixelToComplexConverterImpl(Complex linkeUntereEcke, double breite) {
        reset(linkeUntereEcke, breite);
    }
    @Override
    public Complex convert(int x, int y, int size) {
        double delta = breite / (double) size;
        return new Complex(linkeUntereEcke.re() + x * delta, linkeUntereEcke.im() + y * delta);
    }

    @Override
    public final void reset(Complex linkeUntereEcke, double breite) {
        this.linkeUntereEcke = linkeUntereEcke;
        this.breite = breite;
    }
}
