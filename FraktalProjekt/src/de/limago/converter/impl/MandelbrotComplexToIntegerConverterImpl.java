package de.limago.converter.impl;

import de.limago.converter.ComplexToIntegerConverter;
import de.limago.math.Complex;

public class MandelbrotComplexToIntegerConverterImpl implements ComplexToIntegerConverter {

    private static final int MAXITER = 255;
    @Override
    public int convert(Complex complex) {
        int retval = 0;
        Complex z = new Complex();
        while(z.abs() < 2 ) {
            z = z.times(z);
            z = z.plus(complex);
            retval ++;
            if (retval > MAXITER) return 0;
        }
        return retval;
    }
}
