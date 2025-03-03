package org.example.model.panel;

import org.example.model.card.ICard;
import org.example.model.stack.IStack;
import org.example.model.stack.StockStack;

import java.util.List;

public class StockPanel extends AbstractPanel{
    private final IStack toUse;
    private final IStack rightCards;

    public StockPanel(List<ICard> list, List<StockStack> stacks) {
        super();
        if (stacks.size() != 2) {
            throw new IllegalArgumentException("Must provide exactly 2 StockStack instances");
        }
        this.toUse = stacks.get(0);
        this.rightCards = stacks.get(1);
        this.stacks.add(toUse);
        this.stacks.add(rightCards);
        for (ICard card : list) {
            this.toUse.addCard(card);
        }
    }

    public void nextCard(){
        if(toUse.size() == 1){
            reschuffle(toUse, rightCards);
        }
        else {
            ICard card = toUse.getUpCard();
            toUse.removeCard(card);
            card.setHiddnes(false);
            rightCards.addCard(card);
        }
    }

    void reschuffle(IStack emptyStack, IStack fullStack){
        int size = fullStack.size();
        for (int i=0; i <size-1; i++){
            ICard card = fullStack.getUpCard();
            fullStack.removeCard(card);
            card.setHiddnes(true);
            emptyStack.addCard(card);
        }
    }

    public void backCard() {
        if(rightCards.size() == 1){
            reschuffle(rightCards, toUse);
        }
        else {
            ICard card = rightCards.getUpCard();
            rightCards.removeCard(card);
            rightCards.getUpCard().setHiddnes(false);
            card.setHiddnes(true);
            toUse.addCard(card);
        }
    }
}
