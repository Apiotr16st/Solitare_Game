package org.example.model.stack;

import org.example.model.card.ICard;

import java.util.Collection;

public interface IStack {
    boolean addCard(ICard card);
    boolean addCardDirectly(ICard card);
    ICard getUpCard();
    boolean removeCard(ICard card);
    int size();
    boolean containsCard(ICard cardTo);
    Collection<ICard> getCards();
}
