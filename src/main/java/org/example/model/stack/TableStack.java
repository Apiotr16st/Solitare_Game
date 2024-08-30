package org.example.model.stack;

import org.example.model.card.ICard;

import java.util.ArrayList;
import java.util.Collection;

public class TableStack extends AbstractStack implements IStack {
    public TableStack() {
        super();
    }

    @Override
    public boolean addCard(ICard card) {
        if(checkCard(card)){
            return false;
        }
        else if(this.cards.size() == 1 && card.getNumber().getI() == 13){
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

    @Override
    public boolean addCardDirectly(ICard card) {
        getUpCard().setHiddnes(true);
        return super.addCardDirectly(card);
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
    public boolean removeCard(ICard card) {
        boolean check = super.removeCard(card);
        if(check){
            getUpCard().setHiddnes(false);
            return true;
        }
        return false;
    }
}
