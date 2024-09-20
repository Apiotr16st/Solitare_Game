package org.example.model.panel;

import org.example.model.card.ICard;
import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TablePanelTest {

    private TableStack mockStack1;
    private TableStack mockStack2;
    private TableStack mockStack3;
    private TableStack mockStack4;
    private TableStack mockStack5;
    private TableStack mockStack6;
    private TableStack mockStack7;
    private TablePanel tablePanel;
    private ICard mockCard1;
    private ICard mockCard2;
    private ICard mockCard3;

    @BeforeEach
    public void setUp() {
        // Given
        mockStack1 = mock(TableStack.class);
        mockStack2 = mock(TableStack.class);
        mockStack3 = mock(TableStack.class);
        mockStack4 = mock(TableStack.class);
        mockStack5 = mock(TableStack.class);
        mockStack6 = mock(TableStack.class);
        mockStack7 = mock(TableStack.class);
        mockCard1 = mock(ICard.class);
        mockCard2 = mock(ICard.class);
        mockCard3 = mock(ICard.class);

        ArrayList<ICard> mockStacks = new ArrayList<>();
        for (int i=0; i<28; i++) {
            mockStacks.add(mock(ICard.class));
        }

        tablePanel = new TablePanel(mockStacks,
                List.of(mockStack1, mockStack2, mockStack3, mockStack4, mockStack5, mockStack6, mockStack7));
    }

    @Test
    public void searchStack() {
        // When
        when(mockStack1.containsCard(mockCard1)).thenReturn(false);
        when(mockStack2.containsCard(mockCard1)).thenReturn(false);
        when(mockStack3.containsCard(mockCard1)).thenReturn(false);
        when(mockStack4.containsCard(mockCard1)).thenReturn(false);
        when(mockStack5.containsCard(mockCard1)).thenReturn(false);
        when(mockStack6.containsCard(mockCard1)).thenReturn(true );
        when(mockStack7.containsCard(mockCard1)).thenReturn(false);

        when(mockStack1.containsCard(mockCard2)).thenReturn(false);
        when(mockStack2.containsCard(mockCard2)).thenReturn(false);
        when(mockStack3.containsCard(mockCard2)).thenReturn(false);
        when(mockStack4.containsCard(mockCard2)).thenReturn(false);
        when(mockStack5.containsCard(mockCard2)).thenReturn(false);
        when(mockStack6.containsCard(mockCard2)).thenReturn(false);
        when(mockStack7.containsCard(mockCard2)).thenReturn(true );

        when(mockStack1.containsCard(mockCard3)).thenReturn(false);
        when(mockStack2.containsCard(mockCard3)).thenReturn(false);
        when(mockStack3.containsCard(mockCard3)).thenReturn(false);
        when(mockStack4.containsCard(mockCard3)).thenReturn(false);
        when(mockStack5.containsCard(mockCard3)).thenReturn(false);
        when(mockStack6.containsCard(mockCard3)).thenReturn(false);
        when(mockStack7.containsCard(mockCard3)).thenReturn(false);

        // Then
        assertEquals(mockStack6, tablePanel.searchStack(mockCard1));
        assertEquals(mockStack7, tablePanel.searchStack(mockCard2));
        assertNull(tablePanel.searchStack(mockCard3));
    }

    @Test
    public void getCards(){
        // Given
        ICard extraCard = mock(ICard.class);
        Stack<ICard> stack1 = new Stack<>();
        Stack<ICard> stack2 = new Stack<>();
        Stack<ICard> stack3 = new Stack<>();
        stack1.push(mockCard1);
        stack2.push(mockCard2);
        stack3.push(mockCard3);
        stack3.push(extraCard);

        List<ICard> expected = new ArrayList<>();
        expected.add(mockCard1);
        expected.add(mockCard2);
        expected.add(mockCard3);
        expected.add(extraCard);

        // When
        when(mockStack1.getCards()).thenReturn(stack1);
        when(mockStack2.getCards()).thenReturn(stack2);
        when(mockStack3.getCards()).thenReturn(stack3);
        when(mockStack4.getCards()).thenReturn(new Stack<>());
        when(mockStack5.getCards()).thenReturn(new Stack<>());
        when(mockStack6.getCards()).thenReturn(new Stack<>());
        when(mockStack7.getCards()).thenReturn(new Stack<>());

        // Then
        List<ICard> cards = tablePanel.getCards();
        assertEquals(expected, cards);
    }

    @Test
    public void getStacks(){
        // Given
        ArrayList<IStack> expected = new ArrayList<>();
        expected.add(mockStack1);
        expected.add(mockStack2);
        expected.add(mockStack3);
        expected.add(mockStack4);
        expected.add(mockStack5);
        expected.add(mockStack6);
        expected.add(mockStack7);

        // When
        ArrayList<IStack> stacks = tablePanel.getStacks();

        // Then
        assertEquals(expected, stacks);
    }
}
