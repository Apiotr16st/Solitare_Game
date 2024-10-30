package org.example.model.panel;

import org.example.model.stack.FinalStack;
import org.example.model.stack.IStack;

import java.util.List;


public class UpPanel extends AbstractPanel{
    public UpPanel(List<FinalStack> stacks) {
        super();
        if (stacks.size() != 4) {
            throw new IllegalArgumentException("Must provide exactly 4 FinalStack instances");
        }
        this.stacks.addAll(stacks);
    }

    public boolean isGameWon() {
        for (IStack stack :  stacks) {
            if (stack.size() != 13) {
                return false;
            }
        }
        return true;
    }
}
