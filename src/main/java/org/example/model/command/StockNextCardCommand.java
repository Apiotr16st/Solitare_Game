package org.example.model.command;

import org.example.model.panel.StockPanel;


public class StockNextCardCommand implements ICommand {
    private final StockPanel panel;

    public StockNextCardCommand(StockPanel panel) {
        this.panel = panel;
    }

    @Override
    public void execute() {
        panel.nextCard();
    }

    @Override
    public void undo() {
        panel.backCard();
    }

    @Override
    public void redo() {
        panel.nextCard();
    }

    @Override
    public boolean isExecutable() {
        return true;
    }
}
