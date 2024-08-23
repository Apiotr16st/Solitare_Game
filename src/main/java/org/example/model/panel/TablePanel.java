package org.example.model.panel;

import org.example.model.stack.TableStack;
import org.example.model.card.ICard;

import java.util.ArrayList;

public class TablePanel {
    private final ArrayList<TableStack> stacks;

    public TablePanel(ArrayList<ICard> cards) {
        this.stacks = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            this.stacks.add(new TableStack());
        }

        int cardIndex = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(j == i) {
                    cards.get(cardIndex).setHiddnes(false);
                }
                this.stacks.get(i).addCardToStart(cards.get(cardIndex));
                cardIndex++;
            }
        }

    }

    public ArrayList<TableStack> getStacks() {
        return stacks;
    }

    public boolean searchCard(ICard cardMoved) {
        for (TableStack stack : stacks) {
            if (stack.getCards().contains(cardMoved)) {
                return true;
            }
        }
        return false;
    }

    public TableStack searchStack(ICard cardTo) {
        for (TableStack stack : stacks) {
            if (stack.getCards().contains(cardTo)) {
                return stack;
            }
        }
        return null;
    }
}
