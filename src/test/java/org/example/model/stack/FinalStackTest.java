package org.example.model.stack;

import org.example.model.Color;
import org.example.model.Number;
import org.example.model.card.Card;
import org.example.model.card.EmptyCard;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;


public class FinalStackTest {
    @Test
    public void finalStackInitialization() {
        // given
        FinalStack stockStack = new FinalStack();

        // when
        var size = stockStack.size();

        // then
        assertEquals(1, size);
    }

    @Test
    public void addCardCorrectly() {
        //given
        FinalStack stack = new FinalStack();

        Card ace = new Card(Number.ACE, Color.CLUB);
        Card two= new Card(Number.TWO, Color.CLUB);
        Card three = new Card(Number.THREE, Color.CLUB);
        Card four = new Card(Number.FOUR, Color.CLUB);
        Card five = new Card(Number.FIVE, Color.CLUB);
        Card six = new Card(Number.SIX, Color.CLUB);
        Card seven = new Card(Number.SEVEN, Color.CLUB);
        Card eight = new Card(Number.EIGHT, Color.CLUB);
        Card nine = new Card(Number.NINE, Color.CLUB);
        Card ten = new Card(Number.TEN, Color.CLUB);
        Card jack = new Card(Number.JACK, Color.CLUB);
        Card queen = new Card(Number.QUEEN, Color.CLUB);
        Card king = new Card(Number.KING, Color.CLUB);

        //when
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

        //then
        assertTrue(addAce);
        assertTrue(addTwo);
        assertTrue(addThree);
        assertTrue(addFour);
        assertTrue(addFive);
        assertTrue(addSix);
        assertTrue(addSeven);
        assertTrue(addEight);
        assertTrue(addNine);
        assertTrue(addTen);
        assertTrue(addJack);
        assertTrue(addQueen);
        assertTrue(addKing);
    }

    @Test
    public void addIllegalCard(){
        FinalStack stack = new FinalStack();
        EmptyCard emptyCard = new EmptyCard();

        assertFalse(stack.addCard(null));
        assertFalse(stack.addCard(emptyCard));
    }

    @Test
    public void onlyAceCanByAddFirst(){
        //given
        FinalStack stack = new FinalStack();
        Card king = new Card(Number.KING, Color.CLUB);
        Card queen = new Card(Number.QUEEN, Color.CLUB);
        Card jack = new Card(Number.JACK, Color.CLUB);
        Card ten = new Card(Number.TEN, Color.CLUB);
        Card nine = new Card(Number.NINE, Color.CLUB);
        Card eight = new Card(Number.EIGHT, Color.CLUB);
        Card seven = new Card(Number.SEVEN, Color.CLUB);
        Card six = new Card(Number.SIX, Color.CLUB);
        Card five = new Card(Number.FIVE, Color.CLUB);
        Card four = new Card(Number.FOUR, Color.CLUB);
        Card three = new Card(Number.THREE, Color.CLUB);
        Card two= new Card(Number.TWO, Color.CLUB);
        Card ace = new Card(Number.ACE, Color.CLUB);

        //when
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

        //then
        assertFalse(addKing);
        assertFalse(addQueen);
        assertFalse(addJack);
        assertFalse(addTen);
        assertFalse(addNine);
        assertFalse(addEight);
        assertFalse(addSeven);
        assertFalse(addSix);
        assertFalse(addFive);
        assertFalse(addFour);
        assertFalse(addThree);
        assertFalse(addTwo);
        assertTrue(addAce);
    }

    @Test
    public void addCardWrongNumber(){
        //given
        FinalStack stack = new FinalStack();
        Card ace = new Card(Number.ACE, Color.CLUB);
        Card three = new Card(Number.THREE, Color.CLUB);
        Card four = new Card(Number.FOUR, Color.CLUB);
        Card five = new Card(Number.FIVE, Color.CLUB);
        Card six = new Card(Number.SIX, Color.CLUB);
        Card seven = new Card(Number.SEVEN, Color.CLUB);
        Card eight = new Card(Number.EIGHT, Color.CLUB);
        Card nine = new Card(Number.NINE, Color.CLUB);
        Card ten = new Card(Number.TEN, Color.CLUB);
        Card jack = new Card(Number.JACK, Color.CLUB);
        Card queen = new Card(Number.QUEEN, Color.CLUB);
        Card king = new Card(Number.KING, Color.CLUB);

        //when
        stack.addCard(ace);
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

        //then
        assertFalse(addKing);
        assertFalse(addQueen);
        assertFalse(addJack);
        assertFalse(addTen);
        assertFalse(addNine);
        assertFalse(addEight);
        assertFalse(addSeven);
        assertFalse(addSix);
        assertFalse(addFive);
        assertFalse(addFour);
        assertFalse(addThree);
    }

    @Test
    public void addWrongNumber(){
        //given
        FinalStack stack = new FinalStack();
        Card club = new Card(Number.ACE, Color.CLUB);
        Card diamond = new Card(Number.TWO, Color.DIAMOND);
        Card heart = new Card(Number.TWO, Color.HEART);
        Card spade = new Card(Number.TWO, Color.SPADE);

        //when
        stack.addCard(club);
        var addDiamond = stack.addCard(diamond);
        var addHeart = stack.addCard(heart);
        var addSpade = stack.addCard(spade);

        //then
        assertFalse(addDiamond);
        assertFalse(addHeart);
        assertFalse(addSpade);
    }

    @Test
    public void addCardDirectly() {
        //given
        FinalStack stack = new FinalStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.SIX, Color.DIAMOND);
        Card card3 = new Card(Number.KING, Color.HEART);

        //when
        var addCard1 = stack.addCardDirectly(card1);
        var addCard2 = stack.addCardDirectly(card2);
        var addCard3 = stack.addCardDirectly(card3);

        //then
        assertTrue(addCard1);
        assertTrue(addCard2);
        assertTrue(addCard3);
    }

    @Test
    public void addIllegalCardDirectly() {
        FinalStack stack = new FinalStack();
        EmptyCard emptyCard = new EmptyCard();

        assertFalse(stack.addCardDirectly(null));
        assertFalse(stack.addCardDirectly(emptyCard));
    }

    @Test void checkingCard(){
        //given
        FinalStack stack = new FinalStack();
        EmptyCard emptyCard = new EmptyCard();
        Card card = new Card(Number.ACE, Color.CLUB);

        //when
        var checkNull= stack.checkCard(null);
        var checkEmpty = stack.checkCard(emptyCard);
        var checkCard = stack.checkCard(card);

        //then
        assertTrue(checkNull);
        assertTrue(checkEmpty);
        assertFalse(checkCard);
    }

    @Test
    public void containsCard() {
        //given
        FinalStack stack = new FinalStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);

        //when
        stack.addCardDirectly(card1);
        var containsCard1 = stack.containsCard(card1);
        var containsCard2 = stack.containsCard(card2);

        //then
        assertTrue(containsCard1);
        assertFalse(containsCard2);
    }

    @Test
    public void removeCard() {
        //given
        FinalStack stack = new FinalStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);
        Card card4 = new Card(Number.FOUR, Color.SPADE);

        //when
        stack.addCardDirectly(card1);
        stack.addCardDirectly(card2);
        stack.addCardDirectly(card3);

        var removeCard1 = stack.removeCard(card1);
        var removeCard2 = stack.removeCard(card2);
        var removeCard3 = stack.removeCard(card3);
        var removeCard4 = stack.removeCard(card4);

        //then
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
        //given
        FinalStack stack = new FinalStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);

        //when
        stack.addCardDirectly(card1);
        var upCard1 = stack.getUpCard();
        stack.addCardDirectly(card2);
        var upCard2 = stack.getUpCard();
        stack.addCardDirectly(card3);
        var upCard3 = stack.getUpCard();
        stack.removeCard(card3);
        var upCard4 = stack.getUpCard();

        //then
        assertEquals(card1, upCard1);
        assertEquals(card2, upCard2);
        assertEquals(card3, upCard3);
        assertEquals(card2, upCard4);
    }

    @Test
    public void testSize() {
        //given
        FinalStack stack = new FinalStack();
        Card card1 = new Card(Number.ACE, Color.CLUB);
        Card card2 = new Card(Number.TWO, Color.DIAMOND);
        Card card3 = new Card(Number.THREE, Color.HEART);

        //when
        var size1 = stack.size();
        stack.addCardDirectly(card1);
        var size2 = stack.size();
        stack.addCardDirectly(card2);
        var size3 = stack.size();
        stack.addCardDirectly(card3);
        var size4 = stack.size();
        stack.removeCard(card3);
        var size5 = stack.size();

        //then
        assertEquals(1, size1);
        assertEquals(2, size2);
        assertEquals(3, size3);
        assertEquals(4, size4);
        assertEquals(3, size5);
    }

    @Test
    public void getCardsTest(){
        // Given
        FinalStack stack = new FinalStack();
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
