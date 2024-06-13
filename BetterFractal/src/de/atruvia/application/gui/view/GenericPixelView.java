package de.atruvia.application.gui.view;

import de.atruvia.application.gui.presenter.PixelViewPresenter;

public interface GenericPixelView {

    void setPixelViewPresenter(PixelViewPresenter presenter);

    void show();
    void close();
    void setPixels(int [] bitmap);
    int getSize();
}
