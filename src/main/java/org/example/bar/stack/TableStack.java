package org.example.bar.stack;

import org.example.card.ICard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class TableStack {
    private Collection<ICard> cards;

    public TableStack() {
        this.cards = new ArrayList<ICard>();
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
}
