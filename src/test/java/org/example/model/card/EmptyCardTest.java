package org.example.model.card;

import org.example.model.Color;
import org.example.model.Number;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyCardTest {
    @Test
    public void emptyCardInitialization() {
        //given
        EmptyCard emptyCard = new EmptyCard();

        //when
        //then
        assertEquals(Color.NONE, emptyCard.getColor());
        assertEquals(Number.NONE, emptyCard.getNumber());
        assertFalse(emptyCard.isHidden());
    }

    @Test
    public void cardColorCompare() {
        //given
        EmptyCard emptyCard1 = new EmptyCard();
        EmptyCard emptyCard2 = new EmptyCard();
        Card card1 = new Card(Number.ACE, Color.HEART);
        Card card2 = new Card(Number.ACE, Color.SPADE);
        Card card3 = new Card(Number.ACE, Color.CLUB);
        Card card4 = new Card(Number.ACE, Color.DIAMOND);

        //when
        boolean emptyToEmpty = emptyCard1.colorCompare(emptyCard2);
        boolean emptyToHeart = emptyCard1.colorCompare(card1);
        boolean emptyToSpade = emptyCard1.colorCompare(card2);
        boolean emptyToClub = emptyCard1.colorCompare(card3);
        boolean emptyToDiamond = emptyCard1.colorCompare(card4);

        //then
        assertTrue(emptyToEmpty);
        assertTrue(emptyToHeart);
        assertTrue(emptyToSpade);
        assertTrue(emptyToClub);
        assertTrue(emptyToDiamond);
    }

    @Test
    public void setHiddnes() {
        //given
        EmptyCard emptyCard = new EmptyCard();

        //when
        emptyCard.setHiddnes(true);

        //then
        assertTrue(emptyCard.isHidden());
    }
}
