package de.atruvia.application.gui.presenter;

import de.atruvia.application.gui.view.GenericPixelView;

public interface PixelViewPresenter {

    void setGenericPixelView(GenericPixelView view);


    void onClose();
    void onZoomIn(int x1, int y1, int x2, int y2);
    void onUndoZoom();
    void populateViewWithInitialValues();
}
