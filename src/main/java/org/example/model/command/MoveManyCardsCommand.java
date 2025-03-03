package org.example.model.command;

import org.example.model.card.ICard;
import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;

import java.util.List;

public class MoveManyCardsCommand implements ICommand {
    private final List<ICard> cards;
    private final IStack sourceStack;
    private final IStack targetStack;
    private boolean hiddePreviousCard;

    public MoveManyCardsCommand(List<ICard> cards, IStack sourceStack, IStack targetStack) {
        this.cards = cards;
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
        this.hiddePreviousCard = false;
    }

    @Override
    public void execute() {
        if(!isExecutable()){
            throw new IllegalStateException("Move is not executable");
        }
        for (ICard card : cards) {
            hiddePreviousCard = ((TableStack) sourceStack).getPreviousCard(card).isHidden();
            sourceStack.removeCard(card);
            targetStack.addCard(card);
        }
    }

    @Override
    public void undo() {
        sourceStack.getUpCard().setHiddnes(hiddePreviousCard);
        for (ICard card : cards) {
            targetStack.removeCard(card);
            sourceStack.addCard(card);
        }
    }

    @Override
    public void redo() {
        for (ICard card : cards) {
            sourceStack.removeCard(card);
            targetStack.addCard(card);
        }
    }

    @Override
    public boolean isExecutable() {
        return targetStack.isValidateMove(cards.get(0));
    }
}
