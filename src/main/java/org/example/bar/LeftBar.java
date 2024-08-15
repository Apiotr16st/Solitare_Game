package org.example.bar;

import org.example.card.EmptyCard;
import org.example.card.ICard;

import java.util.Collection;
import java.util.Stack;

public class LeftBar {
    private final Stack<ICard> toUse;
    private final Stack<ICard> rightCards = new Stack<>();



    public LeftBar(Collection<ICard> list) {
        toUse = new Stack<>();
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
        return toUse.get(toUse.size()-1);
    }

    public boolean isEmpty() {
        return toUse.size()==1;
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
                rightCards.remove(card);
                return true;
            }
        }
        return false;
    }
}
