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
    public boolean isValidateMove(ICard card) {
        if(card == null || card.getNumber() == Number.NONE || card.getColor() == Color.NONE){
            return false;
        }
        else if(this.cards.size()==1 && card.getNumber() == Number.ACE){
            this.color = card.getColor();
            return true;
        }
        else if (this.color != card.getColor()) {
            return false;
        }
        else if (getUpCard().getNumber().getI() + 1 == card.getNumber().getI()) {
            return true;
        }
        else {
            return false;
        }
    }
}
