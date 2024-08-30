package org.example.model.panel;

import org.example.model.card.ICard;
import org.example.model.stack.IStack;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractPanel {
    final ArrayList<IStack> stacks;

    public AbstractPanel() {
        this.stacks = new ArrayList<>();
    }

    public ArrayList<IStack> getStacks() {
        return stacks;
    }

    public IStack searchStack(ICard cardMoved) {
        for (IStack stack : stacks) {
            if (stack.getUpCard().equals(cardMoved)) {
                return stack;
            }
        }
        return null;
    }

    public Collection<ICard> getCards() {
        Collection<ICard> cards = new ArrayList<>();
        for (IStack stack : stacks) {
            cards.addAll(stack.getCards());
        }
        return cards;
    }
}
