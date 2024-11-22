package org.example.model.command;

import org.example.model.card.ICard;
import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;

public class MoveCardCommand implements ICommand {
    private final ICard card;
    private final IStack sourceStack;
    private final IStack targetStack;
    private boolean hiddePreviousCard;

    public MoveCardCommand(ICard card, IStack sourceStack, IStack targetStack) {
        this.card = card;
        this.sourceStack = sourceStack;
        this.targetStack = targetStack;
        this.hiddePreviousCard = false;
    }

    @Override
    public void execute(){
        if(!isExecutable()){
            throw new IllegalStateException("Move is not executable");
        }
        if(sourceStack instanceof TableStack){
            hiddePreviousCard = ((TableStack) sourceStack).getPreviousCard(card).isHidden();
        }
        sourceStack.removeCard(card);
        targetStack.addCard(card);
    }

    @Override
    public void undo() {
        targetStack.removeCard(card);
        sourceStack.getUpCard().setHiddnes(hiddePreviousCard);
        sourceStack.addCard(card);
    }

    @Override
    public void redo() {
        if(sourceStack instanceof TableStack){
            hiddePreviousCard = ((TableStack) sourceStack).getPreviousCard(card).isHidden();
        }
        sourceStack.removeCard(card);
        targetStack.addCard(card);
    }

    @Override
    public boolean isExecutable() {
        return targetStack.isValidateMove(card);
    }
}
