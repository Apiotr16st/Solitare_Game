package org.example.model.image;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import org.example.model.card.ICard;
import org.example.util.ImageHelper;


public class CardImage implements ICardImage {
    private final ImageView view;
    private final Image front;
    private final Image back;

    public CardImage(ICard card) {
        this.front = ImageHelper.loadImage(card);
        this.back  = ImageHelper.loadBackImage();
        this.view = new ImageView(back);
        String path = ImageHelper.parseImage(card);
        if(path.equals("/images/gray_back.png")){
            this.view.setImage(front);
            this.view.setOpacity(0.5);
        }
        this.view.setFitWidth(130);
        this.view.setPreserveRatio(true);
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
