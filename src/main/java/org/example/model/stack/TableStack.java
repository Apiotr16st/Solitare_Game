package org.example.model.stack;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.card.ICard;

import java.util.ArrayList;
import java.util.List;

public class TableStack extends AbstractStack implements IStack {
    public TableStack() {
        super();
    }

    @Override
    public boolean isValidateMove(ICard card) {
        if(card == null || card.getNumber() == Number.NONE || card.getColor() == Color.NONE){
            return false;
        }
        else if(this.cards.size() == 1 && card.getNumber().getI() == 13){
            return true;
        }
        else return getUpCard().getNumber().getI() - 1 == card.getNumber().getI() && getUpCard().colorCompare(card);
    }

    public List<ICard> getCardsFrom(ICard card) {
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

    public ICard getPreviousCard(ICard cardMoved){
        int i = 0;
        for(ICard card : this.cards){
            if(card.equals(cardMoved)){
                break;
            }
            i++;
        }
        if(i == 0){
            return null;
        }
        return this.cards.get(i - 1);
    }
}
