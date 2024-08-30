package org.example.model.stack;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.card.Card;
import org.example.model.card.EmptyCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StockStackTest {
    @Test
    public void stockStackInitialization() {
        // Given
        StockStack stack = new StockStack();
        // Then
        assertEquals(1, stack.size());
    }

    @Test
    public void addCardCorrectly() {
        // Given
        StockStack stack = new StockStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);

        // When
        var res1 = stack.addCard(card1);
        var res2 = stack.addCard(card2);

        // Then
        assertTrue(res1);
        assertTrue(res2);
    }

    @Test
    public void addWrongCard() {
        // Given
        StockStack stack = new StockStack();
        EmptyCard emptyCard = new EmptyCard();

        // When
        var res1 = stack.addCard(emptyCard);
        var res2 = stack.addCard(null);

        // Then
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    public void addCorrectCardDirectly() {
        // Given
        StockStack stack = new StockStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);

        // When
        var res1 = stack.addCardDirectly(card1);
        var res2 = stack.addCardDirectly(card2);

        // Then
        assertTrue(res1);
        assertTrue(res2);
    }

    @Test
    public void addWrongCardDirectly() {
        // Given
        StockStack stack = new StockStack();
        EmptyCard emptyCard = new EmptyCard();

        // When
        var res1 = stack.addCardDirectly(emptyCard);
        var res2 = stack.addCardDirectly(null);

        // Then
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    public void removeCard() {
        // Given
        StockStack stack = new StockStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);
        Card card4 = new Card(Number.FOUR, Color.SPADE);

        // When
        stack.addCardDirectly(card1);
        stack.addCardDirectly(card2);
        stack.addCardDirectly(card3);

        var removeCard1 = stack.removeCard(card1);
        var removeCard2 = stack.removeCard(card2);
        var removeCard3 = stack.removeCard(card3);
        var removeCard4 = stack.removeCard(card4);

        // Then
        assertTrue(removeCard1);
        assertTrue(removeCard2);
        assertTrue(removeCard3);
        assertFalse(removeCard4);

        assertFalse(stack.containsCard(card1));
        assertFalse(stack.containsCard(card2));
        assertFalse(stack.containsCard(card3));
    }

    @Test
    public void getUpCard() {
        // Given
        StockStack stack = new StockStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);

        // When
        stack.addCardDirectly(card1);
        var upCard1 = stack.getUpCard();
        stack.addCardDirectly(card2);
        var upCard2 = stack.getUpCard();
        stack.addCardDirectly(card3);
        var upCard3 = stack.getUpCard();
        stack.removeCard(card3);
        var upCard4 = stack.getUpCard();

        // Then
        assertEquals(card1, upCard1);
        assertEquals(card2, upCard2);
        assertEquals(card3, upCard3);
        assertEquals(card2, upCard4);
    }

    @Test
    public void size() {
        // Given
        StockStack stack = new StockStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);

        // When
        var size1 = stack.size();
        stack.addCardDirectly(card1);
        var size2 = stack.size();
        stack.addCardDirectly(card2);
        var size3 = stack.size();
        stack.addCardDirectly(card3);
        var size4 = stack.size();
        stack.removeCard(card3);
        var size5 = stack.size();

        // Then
        assertEquals(1, size1);
        assertEquals(2, size2);
        assertEquals(3, size3);
        assertEquals(4, size4);
        assertEquals(3, size5);
    }

    @Test
    public void getCards(){
        // Given
        StockStack stack = new StockStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);

        // When
        stack.addCardDirectly(card1);
        stack.addCardDirectly(card2);

        // Then
        assertEquals(3, stack.getCards().size());
        assertEquals(card1, stack.getCards().get(1));
        assertEquals(card2, stack.getCards().get(2));
    }
}
