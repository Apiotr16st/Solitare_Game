package org.example.card;

public interface ICard {
    Color getColor();
    Number getNumber();
    boolean isHidden();
    void setHiddnes(boolean isHidden);
    boolean colorCompare(ICard cardTo);
    CardImage getCardImage();
}
