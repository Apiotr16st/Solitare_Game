package org.example.model.panel;

import org.example.model.card.ICard;
import org.example.model.stack.IStack;
import org.example.model.stack.StockStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StockPanelTest {

    private StockStack mockToUse;
    private StockStack mockRightCards;
    private StockPanel stockPanel;
    private ICard mockCard1;
    private ICard mockCard2;
    private ICard mockCard3;

    @BeforeEach
    public void setUp() {
        // Given
        mockToUse = mock(StockStack.class);
        mockRightCards = mock(StockStack.class);
        mockCard1 = mock(ICard.class);
        mockCard2 = mock(ICard.class);
        mockCard3 = mock(ICard.class);
        stockPanel = new StockPanel(Arrays.asList(mockCard1, mockCard2, mockCard3), List.of(mockToUse, mockRightCards));
    }

    @Test
    public void stockPanelWrongInitialization(){
        assertThrows(IllegalArgumentException.class, () -> new StockPanel(List.of(),
                Arrays.asList(mockToUse)));
        assertThrows(IllegalArgumentException.class, () -> new StockPanel(List.of(),
                Arrays.asList(mockToUse, mockRightCards, mock(StockStack.class))));
    }


    @Test
    public void nextCardWithMoreThanOneCard() {
        // When
        when(mockToUse.size()).thenReturn(2);
        when(mockToUse.getUpCard()).thenReturn(mockCard1, mockCard2);

//        stockPanel.nextCard();

        // Then
        verify(mockToUse).getUpCard();
        verify(mockToUse).removeCard(mockCard1);
        verify(mockCard1).setHiddnes(false);
        verify(mockRightCards).addCard(mockCard1);
    }

    @Test
    public void nextCardWithOneCard() {
        // When
        when(mockToUse.size()).thenReturn(1);

//        stockPanel.nextCard();

        // Then
        verify(mockToUse).size();
        verify(mockToUse, never()).getUpCard();
        verify(mockToUse, never()).removeCard(any());
        verify(mockCard1, never()).setHiddnes(false);
        verify(mockRightCards, never()).addCard(any());
    }

    @Test
    public void backCardWithMoreThanOneCard() {
        // When
        when(mockRightCards.size()).thenReturn(2);
        when(mockRightCards.getUpCard()).thenReturn(mockCard1, mockCard2, mockCard3);

//        stockPanel.backCard();

        // Then
        verify(mockRightCards, times(2)).getUpCard();
        verify(mockRightCards).removeCard(mockCard1);
        verify(mockCard1).setHiddnes(true);
        verify(mockToUse).addCard(mockCard1);
    }

    @Test
    public void backCardWithOneCard() {
        // When
        when(mockRightCards.size()).thenReturn(1);

//        stockPanel.backCard();

        // Then
        verify(mockRightCards).size();
        verify(mockRightCards, never()).removeCard(any());
        verify(mockCard1, never()).setHiddnes(true);
        verify(mockToUse, never()).addCard(any());
    }

    @Test
    public void reshuffle(){
        // When
        when(mockRightCards.size()).thenReturn(2);
        when(mockRightCards.getUpCard()).thenReturn(mockCard1, mockCard2);

//        stockPanel.reschuffle(mockToUse, mockRightCards);

        // Then
        verify(mockRightCards).removeCard(mockCard1);
        verify(mockCard1).setHiddnes(true);
        verify(mockToUse).addCard(mockCard1);

        verify(mockRightCards, never()).removeCard(mockCard2);
        verify(mockCard2, never()).setHiddnes(true);
        verify(mockToUse, never()).addCard(mockCard2);
    }

    @Test
    public void getCards(){
        // Given
        Stack<ICard> stack1 = new Stack<>();
        Stack<ICard> stack2 = new Stack<>();
        stack1.push(mockCard1);
        stack1.push(mockCard2);
        stack2.push(mockCard3);

        List<ICard> cards = new ArrayList<>();
        cards.add(mockCard1);
        cards.add(mockCard2);
        cards.add(mockCard3);

        // When
        when(mockToUse.getCards()).thenReturn(stack1);
        when(mockRightCards.getCards()).thenReturn(stack2);


        // Then
        assertEquals(cards, stockPanel.getCards());
        verify(mockToUse).getCards();
        verify(mockRightCards).getCards();
    }

    @Test
    public void getCardsWithEmptyStack(){
        // Given
        Stack<ICard> stack1 = new Stack<>();
        Stack<ICard> stack2 = new Stack<>();
        stack1.push(mockCard1);
        stack1.push(mockCard2);
        stack1.push(mockCard3);

        List<ICard> cards = new ArrayList<>();
        cards.add(mockCard1);
        cards.add(mockCard2);
        cards.add(mockCard3);

        // When
        when(mockToUse.getCards()).thenReturn(stack1);
        when(mockRightCards.getCards()).thenReturn(stack2);


        // Then
        assertEquals(cards, stockPanel.getCards());
        verify(mockToUse).getCards();
        verify(mockRightCards).getCards();
    }

    @Test
    public void getStacks(){
        // Given
        List<IStack> stacks = new ArrayList<>();
        stacks.add(mockToUse);
        stacks.add(mockRightCards);

        // When
        List<IStack> result = stockPanel.getStacks();

        // Then
        assertEquals(stacks, result);
    }

    @Test
    public void searchStack(){
        // When
        when(mockToUse.getUpCard()).thenReturn(mockCard1);
        when(mockRightCards.getUpCard()).thenReturn(mockCard2);

        // When
        IStack result = stockPanel.searchStack(mockCard1);

        // Then
        assertEquals(mockToUse, result);
    }

    @Test
    public void searchNullStack(){
        // Given
        when(mockToUse.getUpCard()).thenReturn(mockCard3);
        when(mockRightCards.getUpCard()).thenReturn(mockCard2);

        // When
        IStack result = stockPanel.searchStack(mockCard1);

        // Then
        assertNull(result);
    }
}
