package org.example.model.stack;

import org.example.model.Color;
import org.example.model.card.ICard;
import org.example.model.Number;


public class FinalStack extends AbstractStack {
    private Color color;

    public FinalStack() {
        super();
        this.color = null;
    }

    @Override
    public boolean addCard(ICard card) {
        card.getCardImage().setMovement(0);
        if(this.cards.size()==1 && card.getNumber() == Number.ACE){
            System.out.println("AS");
            this.color = card.getColor();
            this.cards.push(card);
            return true;
        }
//        else if (this.cards.size() == 1){
//            System.out.println("Size");
//            return false;
//        }
        else if (this.color != card.getColor()) {
            System.out.println("Color");
            return false;
        }
        else if (getUpCard().getNumber().getI() + 1 == card.getNumber().getI()) {
            System.out.println("Number1");
            this.cards.push(card);
            return true;
        }
        else {
            System.out.println("Number2");
            return false;
        }
    }
}
