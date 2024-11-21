package org.example.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;
import org.example.util.ImageHelper;


public class CardImage extends ImageView {
    private final Image front;
    private final Image back;

    public CardImage(ICard card) {
        this.front = ImageHelper.loadImage(card);
        if(card instanceof EmptyCard){
            this.setImage(front);
            this.setOpacity(0.5);
            this.back = front;
        }
        else{
            this.back = ImageHelper.loadBackImage();
        }

        this.setImage(ImageHelper.loadImage(card));
        this.setFitWidth(130);
        this.setPreserveRatio(true);
    }

    public void reverseCard(boolean isHidden) {
        if(isHidden)
            this.setImage(back);
        else
            this.setImage(front);
    }
}
