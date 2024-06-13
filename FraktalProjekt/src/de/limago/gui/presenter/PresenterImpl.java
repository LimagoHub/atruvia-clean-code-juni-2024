package de.limago.gui.presenter;

import de.limago.converter.ColorConverter;
import de.limago.converter.ComplexToIntegerConverter;
import de.limago.converter.PixelToComplex;
import de.limago.math.Complex;

public class PresenterImpl {


/*
    private GenericPixelView view;
    private final ColorConverter colorConverter;
    private final ComplexToIntegerConverter complexToIntegerConverter;
    private final PixelToComplex pixelToComplex;

    public GenericPixelView getView() {
        return view;
    }

    public void setView(GenericPixelView view) {
        this.view = view;
    }

    public PresenterImpl(ColorConverter colorConverter, ComplexToIntegerConverter complexToIntegerConverter, PixelToComplex pixelToComplex) {
        this.colorConverter = colorConverter;
        this.complexToIntegerConverter = complexToIntegerConverter;
        this.pixelToComplex = pixelToComplex;
    }

    public void calculatePixel (){

        final int pixelBreite = view.getDimension();
        final int feld[] = new int[pixelBreite * pixelBreite];
        for( int x = 0 ; x < pixelBreite ; x ++) {
            for(int y = 0; y < pixelBreite; y ++) {
                Complex c = pixelToComplex.convert(x,y, pixelBreite);
                complexToIntegerConverter.convert(c);


                int farbwert = colorConverter.convertIntToRGB(complexToIntegerConverter.convert(pixelToComplex.convert(x,y, pixelBreite)));
                feld[x + y * pixelBreite] = farbwert;
            }
        }
        view.setPixels(feld);
    }

*/
}
