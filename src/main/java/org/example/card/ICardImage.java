package org.example.card;

import javafx.scene.image.ImageView;

public interface ICardImage {
    void setMovement(int movment);
    void setHidden(boolean isHidden);
    ImageView getView();
}
