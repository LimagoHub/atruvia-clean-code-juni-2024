package de.atruvia.application;

import de.atruvia.application.converter.ComplexToIntegerConverter;
import de.atruvia.application.converter.IntToRGBConverter;
import de.atruvia.application.converter.PixelToComplexConverter;
import de.atruvia.application.gui.presenter.PixelViewPresenter;
import de.atruvia.application.gui.presenter.internal.PixelViewPresenterImpl;
import de.atruvia.application.gui.view.GenericPixelView;
import de.atruvia.application.gui.view.internal.GenericPixelViewAWTImpl;
import de.atruvia.application.math.Complex;
import de.atruvia.application.model.internal.mandelbrot.ComplexToIntegerConverterMandelbrotImpl;
import de.atruvia.application.model.internal.mandelbrot.IntToRGBConverterMandelbrotImpl;
import de.atruvia.application.model.internal.newton.ComplexToIntegerConverterNewtonImpl;
import de.atruvia.application.model.internal.newton.IntToRGBConverterNewtonImpl;

import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /*
        var complexToIntegerConverter = new ComplexToIntegerConverterMandelbrotImpl();
        var intToRGBConverter = new IntToRGBConverterMandelbrotImpl();
        var pixelToComplexConverter = PixelToComplexConverter.reset(new Complex(-2.0, -1.25), 2.5, 500);
        */

        var complexToIntegerConverter = new ComplexToIntegerConverterNewtonImpl();
        var intToRGBConverter = new IntToRGBConverterNewtonImpl();
        var pixelToComplexConverter = PixelToComplexConverter.reset(new Complex(-2.0, -2.0), 4, 500);

        GenericPixelView genericPixelView = new GenericPixelViewAWTImpl();
        PixelViewPresenter presenter = PixelViewPresenterImpl
                .builder()
                .complexToIntegerConverter(complexToIntegerConverter)
                .intToRGBConverter(intToRGBConverter)
                .pixelToComplexConverter(pixelToComplexConverter)
                .build();

        genericPixelView.setPixelViewPresenter(presenter);
        presenter.setGenericPixelView(genericPixelView);

        presenter.populateViewWithInitialValues();
        genericPixelView.show();
    }


}

