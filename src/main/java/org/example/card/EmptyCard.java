package org.example.card;

public class EmptyCard implements ICard{
    private final EmptyCardImage cardImage;
    private final Number number;
    private final Color color;
    private boolean isHidden;

    public EmptyCard() {
        this.cardImage = new EmptyCardImage();
        this.number = null;
        this.color = null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public Number getNumber() {
        return null;
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
