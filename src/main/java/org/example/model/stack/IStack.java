package org.example.model.stack;

import org.example.model.card.ICard;

public interface IStack {
    boolean addCard(ICard card);
    void addCardToStart(ICard card);
    ICard getUpCard();
    void removeCard(ICard card);
    int size();
    boolean containsCard(ICard cardTo);
    boolean addCardBack(ICard card);
}
