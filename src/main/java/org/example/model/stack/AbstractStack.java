package org.example.model.stack;

import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;

import java.util.Stack;

public abstract class AbstractStack implements IStack {
    Stack<ICard> cards;

    public AbstractStack() {
        this.cards = new Stack<>();
        this.cards.push(new EmptyCard());
    }

    @Override
    abstract public boolean isValidateMove(ICard card);

    @Override
    public boolean addCard(ICard card) {
        this.cards.push(card);
        return true;
    }

    @Override
    public boolean removeCard(ICard card){
        return this.cards.remove(card);
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
    public String toString() {
        return cards.toString();
    }

    @Override
    public Stack<ICard> getCards() {
        return this.cards;
    }
}
