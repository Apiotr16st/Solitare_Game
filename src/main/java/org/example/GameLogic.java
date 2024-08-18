package org.example;

import org.example.bar.LeftBar;
import org.example.bar.UsedBar;
import org.example.card.Card;
import org.example.card.ICard;
import org.example.card.Tail;
import org.example.bar.stack.TableStack;
import org.example.bar.TableBar;

import java.util.ArrayList;

public class GameLogic {

    private TableBar tableBar;
    private LeftBar leftBar;
    private UsedBar usedBar;

    public GameLogic() {
        Tail tail = new Tail();
        this.tableBar = new TableBar((ArrayList<ICard>) tail.getCards(28));
        this.leftBar = new LeftBar(tail.getCards());
        this.usedBar = new UsedBar();
    }

    public ArrayList<TableStack> getTable(){
        return this.tableBar.getStacks();
    }

    public void moveCard(ICard cardTo, ICard cardMoved) {
        if (cardMoved.getNumber().getI() + 1 == cardTo.getNumber().getI()  && cardTo.colorCompare(cardMoved)) {
            if( tableBar.searchCard(cardMoved)){
                TableStack stack = tableBar.searchStack(cardTo);
                TableStack stackMoved = tableBar.searchStack(cardMoved);
                for(ICard card : stackMoved.getCardsFrom(cardMoved)){
                    stackMoved.removeCard(card);
                    if(stackMoved.getLastCard() != null){
                        stackMoved.getLastCard().setHiddnes(false);
                    }
                    stack.addCard(card);
                }
            }
            else if (leftBar.searchCard(cardMoved)) {
                TableStack stack = tableBar.searchStack(cardTo);
                stack.addCard(cardMoved);
            }
        }
    }

    public void nextCard(){
        leftBar.nextCard();
    }

    public ICard getFirstRightCard(){
        return leftBar.getFirstRightCard();
    }

    public ICard getLeftStack(){
        return leftBar.getLeftStack();
    }
}
