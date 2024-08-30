package org.example.util;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.card.Card;
import org.example.model.card.EmptyCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageHelperTest {
    @Test
    public void parseImage() {
        // Given
        Card card1 = new Card(Number.ACE, Color.SPADE);
        Card card2 = new Card(Number.TWO, Color.HEART);
        Card card3 = new Card(Number.THREE, Color.CLUB);
        Card card4 = new Card(Number.FOUR, Color.DIAMOND);
        Card card5 = new Card(Number.FIVE, Color.SPADE);
        Card card6 = new Card(Number.SIX, Color.HEART);
        Card card7 = new Card(Number.SEVEN, Color.CLUB);
        Card card8 = new Card(Number.EIGHT, Color.DIAMOND);
        Card card9 = new Card(Number.NINE, Color.SPADE);
        Card card10 = new Card(Number.TEN, Color.HEART);
        Card card11 = new Card(Number.JACK, Color.CLUB);
        Card card12 = new Card(Number.QUEEN, Color.DIAMOND);
        Card card13 = new Card(Number.KING, Color.SPADE);


        EmptyCard emptyCard = new EmptyCard();

        // When
        String res1 = ImageHelper.parseImage(card1);
        String res2 = ImageHelper.parseImage(card2);
        String res3 = ImageHelper.parseImage(card3);
        String res4 = ImageHelper.parseImage(card4);
        String res5 = ImageHelper.parseImage(card5);
        String res6 = ImageHelper.parseImage(card6);
        String res7 = ImageHelper.parseImage(card7);
        String res8 = ImageHelper.parseImage(card8);
        String res9 = ImageHelper.parseImage(card9);
        String res10 = ImageHelper.parseImage(card10);
        String res11 = ImageHelper.parseImage(card11);
        String res12 = ImageHelper.parseImage(card12);
        String res13 = ImageHelper.parseImage(card13);
        String emptyRes = ImageHelper.parseImage(emptyCard);

        // Then
        assertEquals("/images/AS.png", res1);
        assertEquals("/images/2H.png", res2);
        assertEquals("/images/3C.png", res3);
        assertEquals("/images/4D.png", res4);
        assertEquals("/images/5S.png", res5);
        assertEquals("/images/6H.png", res6);
        assertEquals("/images/7C.png", res7);
        assertEquals("/images/8D.png", res8);
        assertEquals("/images/9S.png", res9);
        assertEquals("/images/10H.png", res10);
        assertEquals("/images/JC.png", res11);
        assertEquals("/images/QD.png", res12);
        assertEquals("/images/KS.png", res13);
        assertEquals("/images/gray_back.png", emptyRes);
    }
}
