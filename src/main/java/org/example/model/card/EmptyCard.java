package org.example.model.card;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.image.EmptyCardImage;

public class EmptyCard implements ICard {
    private final EmptyCardImage cardImage;
    private final Number number;
    private final Color color;
    private boolean isHidden;

    public EmptyCard() {
        this.cardImage = new EmptyCardImage();
        this.number = Number.NONE;
        this.color = Color.NONE;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Number getNumber() {
        return this.number;
    }

    @Override
    public boolean isHidden() {
        return this.isHidden;
    }

    @Override
    public void setHiddnes(boolean isHidden) {
        cardImage.setHidden(isHidden);
        this.isHidden = isHidden;
    }

    @Override
    public boolean colorCompare(ICard cardTo) {
        return true;
    }

    @Override
    public EmptyCardImage getCardImage() {
        return cardImage;
    }
}
