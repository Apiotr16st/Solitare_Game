package org.example.model;

import org.example.model.card.Card;
import org.example.model.card.ICard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Deck {
    private final ArrayList<ICard> cards;

    public Deck(){
        this.cards = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 14; j++){
                Card card = new Card(Number.values()[j], Color.values()[i]);
                this.cards.add(card);
            }
        }
        Collections.shuffle(this.cards);
    }

    public Collection<ICard> getCards(int i) {
        if(i < 0 || i > cards.size()){
            throw new IllegalArgumentException("Invalid number of cards");
        }
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
}
