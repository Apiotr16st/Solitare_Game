package org.example.card;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import org.example.ImageController;


public class CardImage {
    private final ImageView view;
    private final Image front;
    private final Image back;

    public CardImage(ICard card) {
        this.front = ImageController.loadImage(card);
        this.back  = ImageController.loadBackImage();
        this.view = new ImageView(back);
        view.setFitWidth(130);
        view.setPreserveRatio(true);
    }

    public void setMovement(int movment) {
        view.setTranslateY(movment);
    }

    public void setHidden(boolean isHidden) {
        if (isHidden) {
            view.setImage(back);
        } else {
            view.setImage(front);
        }
    }

    public ImageView getView() {
        return this.view;
    }

}
