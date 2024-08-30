package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeckTest {
    @Test
    public void getCardFromDeck() {
        //given
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Deck deck3 = new Deck();

        //when
        int deck1TakenAll = deck1.getCards().size();
        int deck1Empty = deck1.getCards().size();
        int deck2Taken25 = deck2.getCards(25).size();
        int deck2Taken27 = deck2.getCards(27).size();
        int deck2Empty = deck2.getCards().size();
        int deck3Taken0 = deck3.getCards(0).size();
        int deck3Taken52 = deck3.getCards(52).size();

        //then
        assertEquals(52, deck1TakenAll);
        assertEquals(0, deck1Empty);
        assertEquals(25, deck2Taken25);
        assertEquals(27, deck2Taken27);
        assertEquals(0, deck2Empty);
        assertEquals(0, deck3Taken0);
        assertEquals(52, deck3Taken52);
    }

    @Test
    public void getCardFromDeckIllegalArgument() {
        //given
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();

        //when
        int deck2Taken25 = deck2.getCards(25).size();

        //then
        assertThrows(IllegalArgumentException.class, () -> deck1.getCards(-1));
        assertThrows(IllegalArgumentException.class, () -> deck1.getCards(53));
        assertThrows(IllegalArgumentException.class, () -> deck2.getCards(28));
    }
}
