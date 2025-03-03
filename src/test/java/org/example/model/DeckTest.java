package org.example.model;

import org.example.model.card.ICard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeckTest {
    @Test
    public void getCardFromDeck() {
        //given
        Deck deck1 = new Deck();

        //when
        int deckCardsSize = deck1.getCards().size();

        //then
        assertEquals(52, deckCardsSize);
    }

    @Test
    public void getCardFromDeckIllegalArgument() {
        //given
        Deck deck = new Deck();

        //when
        List<ICard> deckCards = deck.getCards();

        //then
        assertThrows(IndexOutOfBoundsException.class, () -> deckCards.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> deckCards.get(53));
    }
}
