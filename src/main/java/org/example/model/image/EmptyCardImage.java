package org.example.model.image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.example.util.ImageHelper;

public class EmptyCardImage implements ICardImage {
    private final ImageView view;

    public EmptyCardImage() {
        Image img = ImageHelper.loadFieldImage();
        this.view = new ImageView(img);
        view.setFitWidth(130);
        view.setPreserveRatio(true);
        view.setOpacity(0.5);
    }

    @Override
    public void setMovement(int movment) {
        view.setTranslateY(movment);
    }

    @Override
    public void setHidden(boolean isHidden) {
    }

    @Override
    public ImageView getView() {
        return this.view;
    }
}
