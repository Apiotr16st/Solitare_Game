package org.example.model.panel;

import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;
import org.example.model.card.ICard;

import java.util.ArrayList;

public class TablePanel extends AbstractPanel {

    public TablePanel(ArrayList<ICard> cards) {
        super();
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

    @Override
    public IStack searchStack(ICard cardTo) {
        for (IStack stack : stacks) {
            if (stack.containsCard(cardTo)) {
                return stack;
            }
        }
        return null;
    }
}
