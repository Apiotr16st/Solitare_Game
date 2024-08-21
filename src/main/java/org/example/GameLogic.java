package org.example;

import org.example.bar.LeftBar;
import org.example.bar.UsedBar;
import org.example.bar.stack.FinalStack;
import org.example.card.ICard;
import org.example.card.Tail;
import org.example.bar.stack.TableStack;
import org.example.bar.TableBar;

import java.util.ArrayList;

public class GameLogic {

    private final TableBar tableBar;
    private final LeftBar leftBar;
    private final UsedBar usedBar;

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
        boolean movedOnTable = tableBar.searchCard(cardMoved);
        boolean movedOnLeft = leftBar.searchCard(cardMoved);
        boolean movedOnUsed = usedBar.searchCard(cardMoved);

        boolean toOnTable = tableBar.searchCard(cardTo);
        boolean toOnUsed = usedBar.searchCard(cardTo);

        if (movedOnTable && toOnTable) {
            TableStack stackMoved;
            TableStack stack = tableBar.searchStack(cardTo);
            stackMoved = tableBar.searchStack(cardMoved);
            for (ICard card : stackMoved.getCardsFrom(cardMoved)) {
                if(stack.addCard(card)){
                    stackMoved.removeCard(card);
                }
            }
        }
        else if (movedOnTable && toOnUsed){
            TableStack stack = tableBar.searchStack(cardMoved);
            if(stack.getCardsFrom(cardMoved).size() > 1){
                return;
            }
            FinalStack stackMoved = usedBar.searchStack(cardTo);
            if(stackMoved.addCard(cardMoved)){
                stack.removeCard(cardMoved);
            }
        }
        else if (movedOnUsed && toOnTable){
            FinalStack stack = usedBar.searchStack(cardMoved);
            TableStack stackMoved = tableBar.searchStack(cardTo);
            if(stackMoved.addCard(cardMoved)){
                stack.removeCard(cardMoved);
            }
        }
        else if (movedOnLeft && toOnTable){
            TableStack stack = tableBar.searchStack(cardTo);
            if (stack.addCard(cardMoved)) {
               leftBar.removeCard(cardMoved);
            }
        }
        else if (movedOnLeft && toOnUsed){
            FinalStack stack = usedBar.searchStack(cardTo);
            if (stack.addCard(cardMoved)) {
                leftBar.removeCard(cardMoved);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid move");
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

    public ArrayList<FinalStack> getFinalStacks() {
        return usedBar.getStacks();
    }
}
