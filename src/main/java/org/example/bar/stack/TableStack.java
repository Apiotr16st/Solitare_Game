package org.example.bar.stack;

import org.example.card.EmptyCard;
import org.example.card.ICard;

import java.util.ArrayList;
import java.util.Collection;

public class TableStack {
    private Collection<ICard> cards;

    public TableStack() {
        this.cards = new ArrayList<>();
        this.cards.add(new EmptyCard());
    }

    public Collection<ICard> getCards() {
        return cards;
    }

    public boolean addCard(ICard card) {
        if(this.cards.size() == 1 && card.getNumber().getI() == 13){
            return this.cards.add(card);
        }
        else if(this.cards.size() == 1){
            return false;
        }
        else if(getLastCard().getNumber().getI() - 1 == card.getNumber().getI() && getLastCard().colorCompare(card)){
            return this.cards.add(card);
        }
        else{
            return false;
        }
    }

    public void addCardToStart(ICard card) {
        this.cards.add(card);
    }

    public Collection<ICard> getCardsFrom(ICard card) {
        ArrayList<ICard> list = new ArrayList<>();
        int i =0;
        for (ICard c : cards) {
            if (c.equals(card)) {
                i = 1;
                list.add(c);
            }
            else if (i == 1) {
                list.add(c);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "TableStack{" +
                "cards=" + cards.toString() +
                '}';
    }

    public ICard getLastCard() {
        ArrayList<ICard> list = new ArrayList<>(cards);
        if(list.isEmpty()){
            return null;
        }
        return list.get(list.size() - 1);
    }

    public void removeCard(ICard card) {
        this.cards.remove(card);
        getLastCard().setHiddnes(false);
    }
}
