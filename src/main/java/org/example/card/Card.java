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
    public boolean colorCompare(ICard cardMoved) {
        return switch (this.color) {
            case PIK, TREFL -> cardMoved.getColor() == Color.KARO  || cardMoved.getColor() == Color.KIER;
            case KARO, KIER -> cardMoved.getColor() == Color.PIK || cardMoved.getColor() == Color.TREFL;
            case GRAY -> true;
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
