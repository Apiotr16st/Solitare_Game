package org.example.model.stack;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.card.Card;
import org.example.model.card.EmptyCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableStackTest {
    @Test
    public void tableStackInitialization() {
        // Given
        TableStack stack = new TableStack();
        // Then
        assertEquals(1, stack.size());
    }

    @Test
    public void addCardCorrectly() {
        // Given
        TableStack stack = new TableStack();
        Card king = new Card(Number.KING, Color.CLUB);
        Card queen = new Card(Number.QUEEN, Color.DIAMOND);
        Card jack = new Card(Number.JACK, Color.SPADE);
        Card ten = new Card(Number.TEN, Color.HEART);
        Card nine = new Card(Number.NINE, Color.CLUB);
        Card eight = new Card(Number.EIGHT, Color.DIAMOND);
        Card seven = new Card(Number.SEVEN, Color.SPADE);
        Card six = new Card(Number.SIX, Color.DIAMOND);
        Card five = new Card(Number.FIVE, Color.SPADE);
        Card four = new Card(Number.FOUR, Color.HEART);
        Card three = new Card(Number.THREE, Color.CLUB);
        Card two = new Card(Number.TWO, Color.DIAMOND);
        Card ace = new Card(Number.ACE, Color.SPADE);

        // When
        var addKing = stack.addCard(king);
        var addQueen = stack.addCard(queen);
        var addJack = stack.addCard(jack);
        var addTen = stack.addCard(ten);
        var addNine = stack.addCard(nine);
        var addEight = stack.addCard(eight);
        var addSeven = stack.addCard(seven);
        var addSix = stack.addCard(six);
        var addFive = stack.addCard(five);
        var addFour = stack.addCard(four);
        var addThree = stack.addCard(three);
        var addTwo = stack.addCard(two);
        var addAce = stack.addCard(ace);

        // Then
        assertTrue(addKing);
        assertTrue(addQueen);
        assertTrue(addJack);
        assertTrue(addTen);
        assertTrue(addNine);
        assertTrue(addEight);
        assertTrue(addSeven);
        assertTrue(addSix);
        assertTrue(addFive);
        assertTrue(addFour);
        assertTrue(addThree);
        assertTrue(addTwo);
        assertTrue(addAce);
    }

    @Test
    public void addWrongCard() {
        // Given
        TableStack stack = new TableStack();
        EmptyCard emptyCard = new EmptyCard();

        // When
        var res1 = stack.addCard(emptyCard);
        var res2 = stack.addCard(null);

        // Then
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    public void addCardToEmptyStack() {
        // Given
        TableStack stack = new TableStack();
        Card ace = new Card(Number.ACE, Color.CLUB);
        Card two = new Card(Number.TWO, Color.DIAMOND);
        Card three = new Card(Number.THREE, Color.HEART);
        Card four = new Card(Number.FOUR, Color.SPADE);
        Card five = new Card(Number.FIVE, Color.CLUB);
        Card six = new Card(Number.SIX, Color.DIAMOND);
        Card seven = new Card(Number.SEVEN, Color.HEART);
        Card eight = new Card(Number.EIGHT, Color.SPADE);
        Card nine = new Card(Number.NINE, Color.CLUB);
        Card ten = new Card(Number.TEN, Color.DIAMOND);
        Card jack = new Card(Number.JACK, Color.HEART);
        Card queen = new Card(Number.QUEEN, Color.SPADE);
        Card king = new Card(Number.KING, Color.CLUB);

        // When

        var addAce = stack.addCard(ace);
        var addTwo = stack.addCard(two);
        var addThree = stack.addCard(three);
        var addFour = stack.addCard(four);
        var addFive = stack.addCard(five);
        var addSix = stack.addCard(six);
        var addSeven = stack.addCard(seven);
        var addEight = stack.addCard(eight);
        var addNine = stack.addCard(nine);
        var addTen = stack.addCard(ten);
        var addJack = stack.addCard(jack);
        var addQueen = stack.addCard(queen);
        var addKing = stack.addCard(king);


        // Then
        assertFalse(addAce);
        assertFalse(addTwo);
        assertFalse(addThree);
        assertFalse(addFour);
        assertFalse(addFive);
        assertFalse(addSix);
        assertFalse(addSeven);
        assertFalse(addEight);
        assertFalse(addNine);
        assertFalse(addTen);
        assertFalse(addJack);
        assertFalse(addQueen);
        assertTrue(addKing);
    }

    @Test
    public void addCardWithSameColors() {
        // Given
        TableStack blackStack = new TableStack();
        TableStack redStack = new TableStack();
        Card kingClub = new Card(Number.KING, Color.CLUB);
        Card kingDiamond = new Card(Number.KING, Color.DIAMOND);
        Card queenClub = new Card(Number.QUEEN, Color.CLUB);
        Card queenDiamond = new Card(Number.QUEEN, Color.DIAMOND);
        Card queenHeart = new Card(Number.QUEEN, Color.HEART);
        Card queenSpade = new Card(Number.QUEEN, Color.SPADE);

        // When
        blackStack.addCard(kingClub);
        redStack.addCard(kingDiamond);
        var addQueenClub = blackStack.addCard(queenClub);
        var addQueenDiamond = redStack.addCard(queenDiamond);
        var addQueenHeart = redStack.addCard(queenHeart);
        var addQueenSpade = blackStack.addCard(queenSpade);

        // Then
        assertFalse(addQueenClub);
        assertFalse(addQueenDiamond);
        assertFalse(addQueenHeart);
        assertFalse(addQueenSpade);
    }

    @Test
    public void addCardWithDifferentColors() {
        // Given
        TableStack blackStack1 = new TableStack();
        TableStack blackStack2 = new TableStack();
        TableStack redStack1 = new TableStack();
        TableStack redStack2 = new TableStack();
        Card kingClub = new Card(Number.KING, Color.CLUB);
        Card kingDiamond = new Card(Number.KING, Color.DIAMOND);
        Card queenClub = new Card(Number.QUEEN, Color.CLUB);
        Card queenSpade = new Card(Number.QUEEN, Color.SPADE);
        Card queenDiamond = new Card(Number.QUEEN, Color.DIAMOND);
        Card queenHeart = new Card(Number.QUEEN, Color.HEART);

        // When
        blackStack1.addCard(kingClub);
        blackStack2.addCard(kingClub);
        redStack1.addCard(kingDiamond);
        redStack2.addCard(kingDiamond);
        var addQueenClub = redStack1.addCard(queenClub);
        var addQueenSpade = redStack2.addCard(queenSpade);
        var addQueenDiamond = blackStack1.addCard(queenDiamond);
        var addQueenHeart = blackStack2.addCard(queenHeart);

        // Then
        assertTrue(addQueenClub);
        assertTrue(addQueenDiamond);
        assertTrue(addQueenHeart);
        assertTrue(addQueenSpade);
    }

    @Test
    public void addCardDirectly() {
        // Given
        TableStack stack = new TableStack();
        Card card = new Card(Number.ACE, Color.CLUB);

        // When
        var res1 = stack.addCardDirectly(card);
        var res2 = stack.addCardDirectly(card);

        // Then
        assertTrue(res1);
        assertTrue(res2);
    }

    @Test
    public void addWrongCardDirectly() {
        // Given
        TableStack stack = new TableStack();
        EmptyCard emptyCard = new EmptyCard();

        // When
        var res1 = stack.addCardDirectly(emptyCard);
        var res2 = stack.addCardDirectly(null);

        // Then
        assertFalse(res1);
        assertFalse(res2);
    }

    @Test
    public void testGetCardsFrom() {
        TableStack stack = new TableStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);

    }

    @Test
    public void testRemoveCard() {
        // Given
        TableStack stack = new TableStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);

        // When
        stack.addCardDirectly(card1);
        stack.addCardDirectly(card2);
        stack.addCardDirectly(card3);
        var res1 = stack.removeCard(card1);
        var res2 = stack.removeCard(card2);
        var res3 = stack.removeCard(card3);
        var res4 = stack.removeCard(card1);
        var res5 = stack.getUpCard().isHidden();

        // Then
        assertTrue(res1);
        assertTrue(res2);
        assertTrue(res3);
        assertFalse(res4);
        assertFalse(res5);
    }

    @Test
    public void getUpCard() {
        // Given
        TableStack stack = new TableStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);

        // When
        stack.addCardDirectly(card1);
        var upCard = stack.getUpCard();
        stack.addCardDirectly(card2);
        var upCard2 = stack.getUpCard();
        stack.addCardDirectly(card3);
        var upCard3 = stack.getUpCard();
        stack.removeCard(card3);
        var upCard4 = stack.getUpCard();

        // Then
        assertEquals(card1, upCard);
        assertEquals(card2, upCard2);
        assertEquals(card3, upCard3);
        assertEquals(card2, upCard4);
    }

    @Test
    public void size() {
        // Given
        TableStack stack = new TableStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);

        // When
        stack.addCardDirectly(card1);
        var size1 = stack.size();
        stack.addCardDirectly(card2);
        var size2 = stack.size();
        stack.removeCard(card2);
        var size3 = stack.size();

        // Then
        assertEquals(2, size1);
        assertEquals(3, size2);
        assertEquals(2, size3);
    }

    @Test
    public void getCardsTest(){
        // Given
        TableStack stack = new TableStack();
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
