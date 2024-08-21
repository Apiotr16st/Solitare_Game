package org.example.bar.stack;

import org.example.card.Color;
import org.example.card.EmptyCard;
import org.example.card.ICard;
import org.example.card.Number;

import java.util.ArrayList;

public class FinalStack {
    private Color color;
    private ArrayList<ICard> cards;

    public FinalStack() {
        this.cards = new ArrayList<>();
        this.addCard(new EmptyCard());
        this.color = null;
    }

    public boolean addCard(ICard card) {
        card.getCardImage().setMovement(0);
        if (this.cards.isEmpty()) {
            return this.cards.add(card);
        }
        else if(this.cards.size()==1 && card.getNumber() == Number.AS){
            this.color = card.getColor();
            return this.cards.add(card);
        }
        else if (this.color != card.getColor()) {
            return false;
        }
        else if (this.cards.get(this.cards.size() - 1).getNumber().getI() + 1 == card.getNumber().getI()) {
            return this.cards.add(card);
        }
        else {
            return false;
        }

    }

    public ICard getUpCard() {
        return this.cards.get(this.cards.size() - 1);
    }

    public void removeCard(ICard cardMoved) {
        this.cards.remove(cardMoved);
    }
}
