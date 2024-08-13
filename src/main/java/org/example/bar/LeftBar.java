package org.example.bar;

import org.example.card.Card;
import org.example.card.ICard;

import java.util.ArrayList;
import java.util.Collection;

public class LeftBar {
    private ArrayList<Card> toUse;
    private ArrayList<Card> rightCards = new ArrayList<>();


    public LeftBar(Collection<Card> list) {
        this.toUse = new ArrayList<>(list);
    }

    public void nextCard(){
        if(toUse.isEmpty()){
            reschuffle();
        }
        else {
            Card card = toUse.get(0);
            card.setHiddnes(false);
            if(!rightCards.isEmpty()){
                rightCards.get(rightCards.size()-1).setHiddnes(false);
            }
            rightCards.add(card);
            toUse.remove(0);
        }
    }

    public Card getFirstRightCard(){
        if(rightCards.isEmpty()){
            return null;
        }
        return rightCards.get(rightCards.size()-1);
    }

    public boolean isEmpty() {
        return toUse.isEmpty();
    }

    private void reschuffle(){
        toUse = new ArrayList<>(rightCards);
        rightCards.clear();
    }

    public boolean searchCard(ICard cardMoved) {
        for (Card card : rightCards) {
            if (card.equals(cardMoved)) {
                rightCards.remove(card);
                return true;
            }
        }
        return false;
    }
}
