package org.example.model.panel;

import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;

import java.util.Collection;
import java.util.Stack;

public class StockPanel {
    private final Stack<ICard> toUse = new Stack<>();
    private final Stack<ICard> rightCards = new Stack<>();

    public StockPanel(Collection<ICard> list) {
        toUse.push(new EmptyCard());
        for (ICard card : list) {
            toUse.push(card);
        }
        rightCards.add(new EmptyCard());
    }

    public void nextCard(){
        if(toUse.size() == 1){
            reschuffle();
        }
        else {
            ICard card = toUse.pop();
            card.setHiddnes(false);
            rightCards.push(card);
        }
    }

    public ICard getFirstRightCard(){
        return rightCards.get(rightCards.size()-1);
    }

    public ICard getLeftStack(){
        return toUse.peek();
    }

    private void reschuffle(){
        int size = rightCards.size();
        for (int i=0; i<size-1; i++){
            ICard card = rightCards.pop();
            card.setHiddnes(true);
            toUse.push(card);
        }
    }

    public boolean searchCard(ICard cardMoved) {
        for (ICard card : rightCards) {
            if (card.equals(cardMoved)) {
                return true;
            }
        }
        return false;
    }

    public void removeCard(ICard cardMoved) {
        rightCards.remove(cardMoved);
    }
}
