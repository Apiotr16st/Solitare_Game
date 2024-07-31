package org.example.bar;

import org.example.bar.stack.WasteStack;
import org.example.bar.stack.ToUseStack;
import org.example.card.Card;
import org.example.card.ICard;

import java.util.ArrayList;
import java.util.Collection;

public class LeftStack {
    private ToUseStack toUseStack;
    private WasteStack wasteStack;


    public LeftStack(Collection<Card> list) {
        this.toUseStack = new ToUseStack(list);
        this.wasteStack = new WasteStack();
    }

    public void addCard(Card card) {
        this.wasteStack.addCard(card);
    }

    public ArrayList<ICard> reschuffle(){
        return this.wasteStack.reschuffle();
    }


}
