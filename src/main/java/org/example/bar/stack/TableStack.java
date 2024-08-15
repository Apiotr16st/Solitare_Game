package org.example.bar.stack;

import org.example.card.EmptyCard;
import org.example.card.ICard;

import java.util.ArrayList;
import java.util.Collection;

public class TableStack {
    private int stackNumber;
    private Collection<ICard> cards;

    public TableStack(int stackNumber) {
        this.stackNumber = stackNumber;
        this.cards = new ArrayList<>();
        this.cards.add(new EmptyCard());
    }

    public Collection<ICard> getCards() {
        return cards;
    }

    public void addCard(ICard card) {
        this.cards.add(card);
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
}
