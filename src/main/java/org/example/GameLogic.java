package org.example;

import org.example.model.panel.StockPanel;
import org.example.model.panel.UpPanel;
import org.example.model.stack.FinalStack;
import org.example.model.card.ICard;
import org.example.model.Deck;
import org.example.model.stack.TableStack;
import org.example.model.panel.TablePanel;

import java.util.ArrayList;

public class GameLogic {

    private final TablePanel tablePanel;
    private final StockPanel stockPanel;
    private final UpPanel upPanel;

    public GameLogic() {
        Deck deck = new Deck();
        this.tablePanel = new TablePanel((ArrayList<ICard>) deck.getCards(28));
        this.stockPanel = new StockPanel(deck.getCards());
        this.upPanel = new UpPanel();
    }

    public ArrayList<TableStack> getTable(){
        return this.tablePanel.getStacks();
    }

    public void moveCard(ICard cardTo, ICard cardMoved) {
        boolean movedOnTable = tablePanel.searchCard(cardMoved);
        boolean movedOnStock = stockPanel.searchCard(cardMoved);
        boolean movedOnUp = upPanel.searchCard(cardMoved);

        boolean toOnTable = tablePanel.searchCard(cardTo);
        boolean toOnUp = upPanel.searchCard(cardTo);

        if (movedOnTable && toOnTable) {
            TableStack stackMoved;
            TableStack stack = tablePanel.searchStack(cardTo);
            stackMoved = tablePanel.searchStack(cardMoved);
            for (ICard card : stackMoved.getCardsFrom(cardMoved)) {
                if(stack.addCard(card)){
                    stackMoved.removeCard(card);
                }
            }
        }
        else if (movedOnTable && toOnUp){
            TableStack stack = tablePanel.searchStack(cardMoved);
            if(stack.getCardsFrom(cardMoved).size() > 1){
                return;
            }
            FinalStack stackMoved = upPanel.searchStack(cardTo);
            if(stackMoved.addCard(cardMoved)){
                stack.removeCard(cardMoved);
            }
        }
        else if (movedOnUp && toOnTable){
            FinalStack stack = upPanel.searchStack(cardMoved);
            TableStack stackMoved = tablePanel.searchStack(cardTo);
            if(stackMoved.addCard(cardMoved)){
                stack.removeCard(cardMoved);
            }
        }
        else if (movedOnStock && toOnTable){
            TableStack stack = tablePanel.searchStack(cardTo);
            if (stack.addCard(cardMoved)) {
               stockPanel.removeCard(cardMoved);
            }
        }
        else if (movedOnStock && toOnUp){
            FinalStack stack = upPanel.searchStack(cardTo);
            if (stack.addCard(cardMoved)) {
                stockPanel.removeCard(cardMoved);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    public void nextCard(){
        stockPanel.nextCard();
    }

    public ICard getFirstRightCard(){
        return stockPanel.getFirstRightCard();
    }

    public ICard getLeftStack(){
        return stockPanel.getLeftStack();
    }

    public ArrayList<FinalStack> getFinalStacks() {
        return upPanel.getStacks();
    }
}
