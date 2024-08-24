package org.example.model.stack;

import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;

import java.util.Stack;

public abstract class AbstractStack implements IStack {
    Stack<ICard> cards;

    public AbstractStack() {
        this.cards = new Stack<>();
        addCardToStart(new EmptyCard());
    }

    @Override
    abstract public boolean addCard(ICard card);

    @Override
    public void addCardToStart(ICard card) {
        this.cards.push(card);
    }

    @Override
    public void removeCard(ICard card){
        this.cards.remove(card);
    }

    @Override
    public ICard getUpCard() {
        return cards.peek();
    }

    @Override
    public int size() {
        return cards.size();
    }

    @Override
    public boolean containsCard(ICard cardTo) {
        return cards.contains(cardTo);
    }

    @Override
    public boolean addCardBack(ICard card) {
        this.cards.push(card);
        return true;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
