package org.example.card;

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
    public boolean getIsHidden() {
        return this.isHidden;
    }

    @Override
    public boolean colorCompare(ICard cardTo) {
        return switch (this.color) {
            case PIK, TREFL -> cardTo.getColor() == Color.KARO  || cardTo.getColor() == Color.KIER;
            case KARO, KIER -> cardTo.getColor() == Color.PIK || cardTo.getColor() == Color.TREFL;
        };
    }

    public Card(Number number, Color color) {
        this.number = number;
        this.color = color;
        this.isHidden = false;
    }

    public Card(Number number, Color color, boolean isHidden) {
        this.number = number;
        this.color = color;
        this.isHidden = isHidden;
    }

    public void setHidden(boolean isHidden) {
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
