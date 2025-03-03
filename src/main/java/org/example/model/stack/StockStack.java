package org.example.model.stack;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.card.ICard;

public class StockStack extends AbstractStack implements IStack {
    public StockStack() {
        super();
    }

    @Override
    public boolean isValidateMove(ICard card) {
        return card != null && card.getNumber() != Number.NONE && card.getColor() != Color.NONE;
    }
}
