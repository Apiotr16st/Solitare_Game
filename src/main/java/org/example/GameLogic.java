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
        this.tableBar = new TableBar((ArrayList<Card>) tail.getCards(28));
        this.leftBar = new LeftBar(tail.getCards());
        this.usedBar = new UsedBar();
    }

    public ArrayList<TableStack> getTable(){
        return this.tableBar.getStacks();
    }

    public void moveCard(ICard cardTo, ICard cardMoved) {
        if (cardMoved.getNumber().getI() + 1 == cardTo.getNumber().getI()  && cardMoved.colorCompare(cardTo)) {
            if( tableBar.searchCard(cardMoved)){
                TableStack stack = tableBar.searchStack(cardTo);
                stack.addCard(cardMoved);
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

    public Card getFirstRightCard(){
        return leftBar.getFirstRightCard();
    }

    public boolean isToUseEmpty(){
        return leftBar.isEmpty();
    }
}
