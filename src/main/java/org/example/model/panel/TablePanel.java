package org.example.model.panel;

import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;
import org.example.model.card.ICard;

import java.util.List;

public class TablePanel extends AbstractPanel {

    public TablePanel(List<ICard> cards, List<TableStack> stacks) {
        super();
        if (stacks.size() != 7) {
            throw new IllegalArgumentException("Must provide exactly 7 TableStack instances");
        }
        if(cards.size() != 28) {
            throw new IllegalArgumentException("Must provide exactly 28 cards");
        }
        this.stacks.addAll(stacks);

        int cardIndex = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < i + 1; j++) {
                if(j == i) {
                    cards.get(cardIndex).setHiddnes(false);
                }
                this.stacks.get(i).addCard(cards.get(cardIndex));
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
