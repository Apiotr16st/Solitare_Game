package org.example.model.stack;

import org.example.model.Color;
import org.example.model.card.ICard;
import org.example.model.Number;



public class FinalStack extends AbstractStack implements IStack {
    private Color color;

    public FinalStack() {
        super();
        this.color = null;
    }

    @Override
    public boolean addCard(ICard card) {
        card.getCardImage().setMovement(0);
        if(this.cards.size()==1 && card.getNumber() == Number.ACE){
            this.color = card.getColor();
            this.cards.push(card);
            return true;
        }
        else if (this.color != card.getColor()) {
            return false;
        }
        else if (getUpCard().getNumber().getI() + 1 == card.getNumber().getI()) {
            this.cards.push(card);
            return true;
        }
        else {
            return false;
        }
    }
}
