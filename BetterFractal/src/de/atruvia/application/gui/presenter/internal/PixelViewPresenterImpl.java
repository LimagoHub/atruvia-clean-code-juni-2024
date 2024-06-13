package de.atruvia.application.gui.presenter.internal;

import de.atruvia.application.converter.ComplexToIntegerConverter;
import de.atruvia.application.converter.IntToRGBConverter;
import de.atruvia.application.converter.PixelToComplexConverter;
import de.atruvia.application.gui.presenter.PixelViewPresenter;
import de.atruvia.application.gui.view.GenericPixelView;
import de.atruvia.application.math.Complex;

import java.util.ArrayDeque;
import java.util.Deque;

public class PixelViewPresenterImpl implements PixelViewPresenter {



    private Deque<PixelToComplexConverter> pixelToComplexConverters = new ArrayDeque<>();
    private GenericPixelView view;
    private ComplexToIntegerConverter complexToIntegerConverter = null;
    private IntToRGBConverter intToRGBConverter = null;
    private PixelToComplexConverter pixelToComplexConverter= null;

    protected PixelViewPresenterImpl() {

    }

    public ComplexToIntegerConverter getComplexToIntegerConverter() {
        return complexToIntegerConverter;
    }

    public void setComplexToIntegerConverter(ComplexToIntegerConverter complexToIntegerConverter) {
        this.complexToIntegerConverter = complexToIntegerConverter;
    }

    public IntToRGBConverter getIntToRGBConverter() {
        return intToRGBConverter;
    }

    public void setIntToRGBConverter(IntToRGBConverter intToRGBConverter) {
        this.intToRGBConverter = intToRGBConverter;
    }

    public PixelToComplexConverter getPixelToComplexConverter() {
        return pixelToComplexConverter;
    }

    public void setPixelToComplexConverter(PixelToComplexConverter pixelToComplexConverter) {
        this.pixelToComplexConverter = pixelToComplexConverter;
    }

    @Override
    public void setGenericPixelView(GenericPixelView view) {
        this.view = view;
    }

    @Override
    public void onClose() {
        view.close();
    }

    @Override
    public void onZoomIn(int x1, int y1, int x2, int y2) {
        Complex linkeUntereEcke = pixelToComplexConverter.convertPixelToComplex(x1,y1);
        Complex rechteObereEcke = pixelToComplexConverter.convertPixelToComplex(x2,y2);
        double neueBreite = getNeueBreite(rechteObereEcke, linkeUntereEcke);
        pixelToComplexConverters.push(pixelToComplexConverter);
        pixelToComplexConverter = PixelToComplexConverter.reset(linkeUntereEcke,neueBreite, view.getSize());
        calculatePixel();
    }

    private static double getNeueBreite(Complex rechteObereEcke, Complex linkeUntereEcke) {
        double breite = rechteObereEcke.re() - linkeUntereEcke.re();
        double hoehe = rechteObereEcke.im() - linkeUntereEcke.im();
        return Math.max(breite,hoehe);

    }

    @Override
    public void onUndoZoom() {
        if( pixelToComplexConverters.isEmpty()) return ;

        setPixelToComplexConverter(pixelToComplexConverters.pop());
        calculatePixel();

    }

    @Override
    public void populateViewWithInitialValues() {
        calculatePixel();
    }

    private void calculatePixel (){

        final int pixelBreite = view.getSize();
        final int [] feld = new int[pixelBreite * pixelBreite];
        for( int x = 0 ; x < pixelBreite ; x ++) {
            for(int y = 0; y < pixelBreite; y ++) {
                Complex c = pixelToComplexConverter.convertPixelToComplex(x,y);

                int pixelValue = complexToIntegerConverter.convertComplexToInt(c);

                int farbwert = intToRGBConverter.convertIntToRGB(pixelValue);
                feld[x + y * pixelBreite] = farbwert;
            }
        }
        view.setPixels(feld);
    }


    public static PixelViewPresenterBuilder builder() {
        return new PixelViewPresenterBuilder();
    }

    public static class PixelViewPresenterBuilder {
        private PixelViewPresenterImpl presenter = new PixelViewPresenterImpl();

        public PixelViewPresenterBuilder complexToIntegerConverter(ComplexToIntegerConverter complexToIntegerConverter){
            presenter.setComplexToIntegerConverter(complexToIntegerConverter);
            return this;
        }
        public PixelViewPresenterBuilder intToRGBConverter(IntToRGBConverter intToRGBConvertern){
            presenter.setIntToRGBConverter(intToRGBConvertern);
            return this;
        }

        public PixelViewPresenterBuilder pixelToComplexConverter(PixelToComplexConverter pixelToComplexConverter){
            presenter.setPixelToComplexConverter(pixelToComplexConverter);
            return this;
        }

        public PixelViewPresenter build() {
            return presenter;
        }
    }
}
