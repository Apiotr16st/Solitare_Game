package org.example.card;

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
    public boolean colorCompare(ICard cardTo) {
        return switch (this.color) {
            case PIK, TREFL -> cardTo.getColor() == Color.KARO  || cardTo.getColor() == Color.KIER;
            case KARO, KIER -> cardTo.getColor() == Color.PIK || cardTo.getColor() == Color.TREFL;
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
