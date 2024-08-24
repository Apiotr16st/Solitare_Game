package org.example.model.panel;

import org.example.model.stack.FinalStack;


public class UpPanel extends AbstractPanel{
    public UpPanel() {
        super();
        for (int i = 0; i < 4; i++) {
            this.stacks.add(new FinalStack());
        }
    }
}
