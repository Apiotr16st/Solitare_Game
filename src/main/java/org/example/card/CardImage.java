package org.example.card;

import javafx.scene.Cursor;
import javafx.scene.image.ImageView;
import org.example.GameController;


import javafx.scene.image.Image;
import org.example.ImageParser;

import java.util.Objects;

public class CardImage {
    private final ICard card;
    private final ImageView view;
    private final Image front;
    private final Image back;

    public CardImage(ICard card) {
        this.card = card;
        this.front = new Image(Objects.requireNonNull(GameController.class.getResource(ImageParser.parseImage(this.card))).toExternalForm());
        this.back  = new Image(Objects.requireNonNull(GameController.class.getResource("/images/red_back.png")).toExternalForm());
        this.view = new ImageView(front);
        view.setFitWidth(150);
        view.setPreserveRatio(true);
    }

    public void setMovment(int movment) {
        view.setTranslateY(movment);
    }

    public void flip() {
        if (view.getImage().equals(front)) {
            view.setImage(back);
        } else {
            view.setImage(front);
        }
    }

    public ImageView getView() {
        return this.view;
    }

    public ICard getCard() {
        return this.card;
    }
}
