package org.example.model.image;

import javafx.scene.image.ImageView;

public interface ICardImage {
    void setMovement(int movment);
    void setHidden(boolean isHidden);
    ImageView getView();
}
