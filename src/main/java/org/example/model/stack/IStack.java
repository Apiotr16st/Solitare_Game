package org.example.model.stack;

import org.example.model.card.ICard;

import java.util.List;

public interface IStack {
    boolean addCard(ICard card);
    boolean isValidateMove(ICard card);
    ICard getUpCard();
    boolean removeCard(ICard card);
    int size();
    boolean containsCard(ICard cardTo);
    List<ICard> getCards();
}
