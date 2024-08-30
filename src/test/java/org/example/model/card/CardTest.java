package org.example.model.card;

import org.example.model.Color;
import org.example.model.Number;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void cardInitialization() {
        //when given arguments are correct
        Card card1 = new Card(Number.ACE, Color.HEART);

        //then card should be created
        assertEquals(Color.HEART, card1.getColor());
        assertEquals(Number.ACE, card1.getNumber());
        assertTrue(card1.isHidden());
    }

    @Test
    public void illegalCardInitialization() {
        //when wrong arguments are given to the constructor then exception should be thrown
        assertThrows(IllegalArgumentException.class, () -> new Card(Number.NONE, Color.NONE));
        assertThrows(IllegalArgumentException.class, () -> new Card(Number.NONE, Color.DIAMOND));
        assertThrows(IllegalArgumentException.class, () -> new Card(Number.ACE, Color.NONE));
        assertThrows(IllegalArgumentException.class, () -> new Card(Number.ACE, null));
        assertThrows(IllegalArgumentException.class, () -> new Card(null, Color.HEART));
    }

    @Test
    public void cardColorCompare() {
        //given
        Card heart = new Card(Number.ACE, Color.HEART);
        Card spade = new Card(Number.ACE, Color.SPADE);
        Card club = new Card(Number.ACE, Color.CLUB);
        Card diamond = new Card(Number.ACE, Color.DIAMOND);
        EmptyCard emptyCard = new EmptyCard();

        //when
        boolean heartToSpade = heart.colorCompare(spade);
        boolean spadeToHeart = spade.colorCompare(heart);
        boolean clubToDiamond = club.colorCompare(diamond);
        boolean diamondToClub = diamond.colorCompare(club);
        boolean heartToDiamond = heart.colorCompare(diamond);
        boolean diamondToHeart = diamond.colorCompare(heart);
        boolean spadeToClub = spade.colorCompare(club);
        boolean clubToSpade = club.colorCompare(spade);
        boolean emptyToHeart = heart.colorCompare(emptyCard);

        //then
        assertTrue(heartToSpade);
        assertTrue(spadeToHeart);
        assertTrue(clubToDiamond);
        assertTrue(diamondToClub);
        assertFalse(heartToDiamond);
        assertFalse(diamondToHeart);
        assertFalse(spadeToClub);
        assertFalse(clubToSpade);
        assertFalse(emptyToHeart);
    }


    @Test
    public void isHiddnen(){
        //given
        Card card1 = new Card(Number.ACE, Color.HEART);
        Card card2 = new Card(Number.ACE, Color.HEART);

        //when
        card1.setHiddnes(false);

        //then
        assertFalse(card1.isHidden());
        assertTrue(card2.isHidden());
    }
}

