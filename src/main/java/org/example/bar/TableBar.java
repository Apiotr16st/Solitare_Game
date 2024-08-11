package org.example.bar;

import org.example.card.Card;
import org.example.bar.stack.TableStack;

import java.util.ArrayList;

public class TableBar {
    ArrayList<TableStack> stacks;

    public TableBar(ArrayList<Card> cards) {
        this.stacks = new ArrayList<TableStack>();
        for (int i = 0; i < 7; i++) {
            this.stacks.add(new TableStack(i));
        }

        int cardIndex = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(j != i) {
                    cards.get(cardIndex).setHidden(true);
                }
                this.stacks.get(i).addCard(cards.get(cardIndex));
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
}
