package org.example.model.panel;

import org.example.model.stack.FinalStack;
import org.example.model.card.ICard;

import java.util.ArrayList;


public class UpPanel {
    private final ArrayList<FinalStack> stacks;

    public UpPanel() {
        this.stacks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.stacks.add(new FinalStack());
        }
    }

    public ArrayList<FinalStack> getStacks() {
        return stacks;
    }

    public boolean searchCard(ICard cardMoved) {
        for (FinalStack stack : stacks) {
            if (stack.getUpCard().equals(cardMoved)) {
                return true;
            }
        }
        return false;
    }

    public FinalStack searchStack(ICard cardMoved) {
        for (FinalStack stack : stacks) {
            if (stack.getUpCard().equals(cardMoved)) {
                return stack;
            }
        }
        return null;
    }
}
