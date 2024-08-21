package org.example.bar;

import org.example.bar.stack.FinalStack;
import org.example.card.ICard;

import java.util.ArrayList;


public class UsedBar {
    private ArrayList<FinalStack> stacks;

    public UsedBar() {
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
