package org.example.model.panel;

import org.example.model.card.ICard;
import org.example.model.stack.FinalStack;
import org.example.model.stack.IStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UpPanelTest {

    private UpPanel upPanel;
    private ICard mockCard1;
    private ICard mockCard2;
    private ICard mockCard3;
    private ICard mockCard4;
    private ICard mockCard5;

    private FinalStack mockFinalStack1;
    private FinalStack mockFinalStack2;
    private FinalStack mockFinalStack3;
    private FinalStack mockFinalStack4;

    @BeforeEach
    public void setUp() {
        // Given
        mockCard1 = mock(ICard.class);
        mockCard2 = mock(ICard.class);
        mockCard3 = mock(ICard.class);
        mockCard4 = mock(ICard.class);
        mockCard5 = mock(ICard.class);

        mockFinalStack1 = mock(FinalStack.class);
        mockFinalStack2 = mock(FinalStack.class);
        mockFinalStack3 = mock(FinalStack.class);
        mockFinalStack4 = mock(FinalStack.class);

        List <FinalStack> finalStacks = Arrays.asList(mockFinalStack1, mockFinalStack2,
                mockFinalStack3, mockFinalStack4);

        upPanel = new UpPanel(finalStacks);
    }

    @Test
    public void upPanelWrongInitialization(){
        assertThrows(IllegalArgumentException.class, () -> new UpPanel(
                Arrays.asList(mockFinalStack1, mockFinalStack2, mockFinalStack3)));
        assertThrows(IllegalArgumentException.class, () -> new UpPanel(
                Arrays.asList(mockFinalStack1, mockFinalStack2, mockFinalStack3,
                        mockFinalStack4, mock(FinalStack.class))));
    }

    @Test
    public void getStacks() {
        // Given
        ArrayList<IStack> stacks = new ArrayList<>();
        stacks.add(mockFinalStack1);
        stacks.add(mockFinalStack2);
        stacks.add(mockFinalStack3);
        stacks.add(mockFinalStack4);

        // When
        ArrayList<IStack> result = upPanel.getStacks();

        // Then
        assertEquals(4, result.size());
        assertEquals(stacks, result);
    }

    @Test
    public void searchStack(){
        // When
        when(mockFinalStack1.getUpCard()).thenReturn(mockCard1);
        when(mockFinalStack2.getUpCard()).thenReturn(mockCard2);
        when(mockFinalStack3.getUpCard()).thenReturn(mockCard3);
        when(mockFinalStack4.getUpCard()).thenReturn(mockCard4);

        // Then
        assertEquals(mockFinalStack1, upPanel.searchStack(mockCard1));
        assertEquals(mockFinalStack2, upPanel.searchStack(mockCard2));
        assertEquals(mockFinalStack3, upPanel.searchStack(mockCard3));
        assertEquals(mockFinalStack4, upPanel.searchStack(mockCard4));
        assertNull(upPanel.searchStack(mockCard5));
    }

    @Test
    public void getCards(){
        // Given
        List<ICard> cards = new ArrayList<>();
        cards.add(mockCard1);
        cards.add(mockCard2);
        cards.add(mockCard3);
        cards.add(mockCard4);
        cards.add(mockCard5);

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        stack1.push(mockCard1);
        stack1.push(mockCard2);

        stack2.push(mockCard3);
        stack3.push(mockCard4);
        stack3.push(mockCard5);


        // When
        when(mockFinalStack1.getCards()).thenReturn(stack1);
        when(mockFinalStack2.getCards()).thenReturn(stack2);
        when(mockFinalStack3.getCards()).thenReturn(stack3);
        when(mockFinalStack4.getCards()).thenReturn(new Stack<>());

        // Then
        assertEquals(cards, upPanel.getCards());
    }
}
