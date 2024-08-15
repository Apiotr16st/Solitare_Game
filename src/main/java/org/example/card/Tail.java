package org.example.card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Tail {
    private ArrayList<ICard> cards;

    public Tail(){
        this.cards = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++){
                Card card = new Card(Number.values()[j], Color.values()[i]);
                this.cards.add(card);
            }
        }
        Collections.shuffle(this.cards);
    }

    public Collection<ICard> getCards(int i) {
        Iterator<ICard> iterator = cards.iterator();
        Collection<ICard> removed_cards = new ArrayList<>();
        while (iterator.hasNext() && i > 0) {
            ICard card = iterator.next();
            removed_cards.add(card);
            iterator.remove();
            i--;
        }
        return removed_cards;
    }

    public Collection<ICard> getCards() {
        Collection<ICard> removed_cards = new ArrayList<>(cards);
        cards.clear();
        return removed_cards;
    }

    @Override
    public String toString() {
        return "Tail cards=" + cards;
    }
}
