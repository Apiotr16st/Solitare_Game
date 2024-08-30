package org.example.model.card;

import org.example.model.Color;
import org.example.model.Number;

public class Card implements ICard {
    private final Number number;
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
            case NONE -> false;
        };
    }

    public Card(Number number, Color color) {
        if(number == null || color == null){
            throw new IllegalArgumentException("Number and color cannot be null");
        }
        if(number == Number.NONE || color == Color.NONE){
            throw new IllegalArgumentException("Number and color cannot be NONE");
        }
        this.number = number;
        this.color = color;
        this.isHidden = true;
    }

    public void setHiddnes(boolean isHidden) {
        this.isHidden = isHidden;
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
