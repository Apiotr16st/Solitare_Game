package org.example.model.stack;

import org.example.model.card.ICard;

public class StockStack extends AbstractStack implements IStack {
    public StockStack() {
        super();
    }

    @Override
    public boolean addCard(ICard card) {
        if(checkCard(card)){
            return false;
        }
        cards.push(card);
        return true;
    }

    @Override
    public boolean addCardDirectly(ICard card) {
        return super.addCardDirectly(card);
    }
}
