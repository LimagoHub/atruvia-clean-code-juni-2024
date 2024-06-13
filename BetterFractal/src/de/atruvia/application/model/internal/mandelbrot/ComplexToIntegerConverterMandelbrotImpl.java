package de.atruvia.application.model.internal.mandelbrot;

import de.atruvia.application.converter.ComplexToIntegerConverter;
import de.atruvia.application.math.Complex;

public class ComplexToIntegerConverterMandelbrotImpl implements ComplexToIntegerConverter {

    private static final int MAXITER = 255;
    public static final int MAX_ABSOLUTE_VALUE = 2;

    @Override
    public int convertComplexToInt(Complex complex) {
        int result = 0;
        Complex z = new Complex();
        while(z.abs() < MAX_ABSOLUTE_VALUE) {
            z = z.times(z);
            z = z.plus(complex);
            result ++;
            if (result > MAXITER) return 0;
        }
        return result;
    }
}
