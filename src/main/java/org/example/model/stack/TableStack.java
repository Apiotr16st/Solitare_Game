package org.example.model.stack;

import org.example.model.card.ICard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class TableStack extends AbstractStack implements IStack {
    public TableStack() {
        super();
    }

    public Stack<ICard> getCards() {
        return this.cards;
    }

    @Override
    public boolean addCard(ICard card) {
        if(this.cards.size() == 1 && card.getNumber().getI() == 13){
            this.cards.push(card);
            return true;
        }
        else if(getUpCard().getNumber().getI() - 1 == card.getNumber().getI() && getUpCard().colorCompare(card)){
            this.cards.push(card);
            return true;
        }
        else{
            return false;
        }
    }

    public Collection<ICard> getCardsFrom(ICard card) {
        ArrayList<ICard> list = new ArrayList<>();
        int i = 0;
        while(true){
            ICard c = this.cards.get(cards.size()-1-i);
            list.add(c);
            i++;
            if(c.equals(card)){
                break;
            }
        }
        java.util.Collections.reverse(list);
        return list;
    }

    @Override
    public void removeCard(ICard card) {
        super.removeCard(card);
        getUpCard().setHiddnes(false);
    }

    @Override
    public boolean addCardBack(ICard card) {
        getUpCard().setHiddnes(true);
        return super.addCardBack(card);
    }
}
