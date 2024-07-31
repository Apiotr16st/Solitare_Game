package org.example.bar.stack;

import org.example.card.ICard;

import java.util.ArrayList;

public class WasteStack {
    private ArrayList<ICard> cards;

    public WasteStack() {
        this.cards = new ArrayList<ICard>();
    }


    public void addCard(ICard card) {
        this.cards.add(card);
    }

    public ArrayList<ICard> reschuffle(){
        ArrayList<ICard> reschuffled = new ArrayList<ICard>();
        for (int i = this.cards.size() - 1; i >= 0 ; i--) {
            reschuffled.add(this.cards.get(i));
        }
        this.cards.clear();
        return reschuffled;
    }

}
