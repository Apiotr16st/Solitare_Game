package org.example.model.stack;

import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;

import java.util.Stack;

public abstract class AbstractStack {
    Stack<ICard> cards;

    public AbstractStack() {
        this.cards = new Stack<>();
        addCardToStart(new EmptyCard());
    }

    abstract public boolean addCard(ICard card);

    public void addCardToStart(ICard card) {
        this.cards.push(card);
    }

    public void removeCard(ICard card){
        this.cards.remove(card);
    }

    public ICard getUpCard() {
        return cards.peek();
    }
}
