package org.example.model.card;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.image.CardImage;

public class Card implements ICard {
    private final Number number;
    private final CardImage cardImage;
    private final Color color;
    private boolean isHidden;

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
    public boolean colorCompare(ICard cardMoved) {
        return switch (this.color) {
            case SPADE, CLUB -> cardMoved.getColor() == Color.DIAMOND || cardMoved.getColor() == Color.HEART;
            case DIAMOND, HEART -> cardMoved.getColor() == Color.SPADE || cardMoved.getColor() == Color.CLUB;
            case NONE -> true;
        };
    }

    @Override
    public CardImage getCardImage() {
        return this.cardImage;
    }

    public Card(Number number, Color color) {
        this.number = number;
        this.color = color;
        this.isHidden = true;
        this.cardImage = new CardImage(this);
    }

    public void setHiddnes(boolean isHidden) {
        this.isHidden = isHidden;
        cardImage.setHidden(isHidden);
    }


    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", color=" + color +
                ", isHidden=" + isHidden +
                '}';
    }
}
