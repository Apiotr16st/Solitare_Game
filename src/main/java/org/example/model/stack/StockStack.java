package org.example.model.stack;

import org.example.model.card.ICard;

public class StockStack extends AbstractStack implements IStack {
    public StockStack() {
        super();
    }

    @Override
    public boolean addCard(ICard card) {
        cards.push(card);
        return true;
    }

    @Override
    public boolean addCardBack(ICard card) {
        card.getCardImage().setMovement(0);
        return super.addCardBack(card);
    }
}
