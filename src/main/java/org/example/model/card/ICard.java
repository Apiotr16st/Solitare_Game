package org.example.model.card;

import org.example.model.Color;
import org.example.model.Number;

public interface ICard {
    Color getColor();
    Number getNumber();
    boolean isHidden();
    void setHiddnes(boolean isHidden);
    boolean colorCompare(ICard cardTo);
}
