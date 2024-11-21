package org.example.model;

import org.example.model.card.Card;
import org.example.model.card.ICard;

import java.util.*;

public class Deck {
    private final List<ICard> cards;

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

    public List<ICard> getCards() {
        return cards;
    }
}
