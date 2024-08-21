package org.example.bar;

import org.example.card.Card;
import org.example.bar.stack.TableStack;
import org.example.card.EmptyCard;
import org.example.card.ICard;

import java.util.ArrayList;

public class TableBar {
    private final ArrayList<TableStack> stacks;

    public TableBar(ArrayList<ICard> cards) {
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

    @Override
    public String toString() {
        return "Table stacks=" + stacks.get(0) + "\n"
                + stacks.get(1) + "\n"
                + stacks.get(2) + "\n"
                + stacks.get(3) + "\n"
                + stacks.get(4) + "\n"
                + stacks.get(5) + "\n"
                + stacks.get(6) + "\n";
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
