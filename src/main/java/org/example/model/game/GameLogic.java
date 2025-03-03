package org.example.model.game;

import org.example.model.CardPlace;
import org.example.model.command.MoveCardCommand;
import org.example.model.command.MoveManager;
import org.example.model.command.MoveManyCardsCommand;
import org.example.model.command.StockNextCardCommand;
import org.example.model.panel.StockPanel;
import org.example.model.panel.UpPanel;
import org.example.model.card.ICard;
import org.example.model.Deck;
import org.example.model.stack.FinalStack;
import org.example.model.stack.IStack;
import org.example.model.stack.StockStack;
import org.example.model.stack.TableStack;
import org.example.model.panel.TablePanel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameLogic {

    private final TablePanel tablePanel;
    private final StockPanel stockPanel;
    private final UpPanel upPanel;
    private final MoveManager moveManager = new MoveManager();

    public GameLogic() {
        Deck deck = new Deck();
        ArrayList<TableStack> panelStacks = new ArrayList<>();
        ArrayList<StockStack> stockStacks = new ArrayList<>();
        ArrayList<FinalStack> finalStacks = new ArrayList<>();

        for(int i=0; i<7; i++){
            panelStacks.add(new TableStack());
        }

        for(int i=0; i<2; i++){
            stockStacks.add(new StockStack());
        }

        for(int i=0; i<4; i++){
            finalStacks.add(new FinalStack());
        }

        this.tablePanel = new TablePanel(deck.getCards().subList(0, 28), panelStacks);
        this.stockPanel = new StockPanel(deck.getCards().subList(28,52), stockStacks);
        this.upPanel = new UpPanel(finalStacks);
    }

    public boolean isGameWon(){
        return upPanel.isGameWon();
    }

    public Collection<ICard> getCards() {
        List<ICard> all_cards = new ArrayList<>();
        all_cards.addAll(tablePanel.getCards());
        all_cards.addAll(stockPanel.getCards());
        all_cards.addAll(upPanel.getCards());
        return all_cards;
    }

    private IStack searchStack(ICard card, CardPlace place){
        return switch (place) {
            case TABLE -> tablePanel.searchStack(card);
            case UP -> upPanel.searchStack(card);
            case STOCK -> stockPanel.searchStack(card);
        };
    }

    public void moveCard(ICard sourceCard, CardPlace sourcePlace, ICard targetCard, CardPlace targetPlace){
        IStack sourceStack = searchStack(sourceCard, sourcePlace);
        IStack targetStack = searchStack(targetCard, targetPlace);

        if(targetStack == null || sourceStack == null){
            return;
        }

        if(sourcePlace == CardPlace.TABLE && targetPlace == CardPlace.TABLE){
            TableStack tableStack = (TableStack) sourceStack;
            MoveManyCardsCommand moveMany = new MoveManyCardsCommand(tableStack.getCardsFrom(sourceCard),
                    sourceStack, targetStack);
            moveManager.executeCommand(moveMany);
            return;
        }

        MoveCardCommand move = new MoveCardCommand(sourceCard, sourceStack, targetStack);
        moveManager.executeCommand(move);
    }

    public void nextCard() {
        moveManager.executeCommand(new StockNextCardCommand(stockPanel));
    }

    public void undoMove(){
        moveManager.undo();
    }

    public void redoMove(){
        moveManager.redo();
    }

    public ArrayList<IStack> getStock(){
        return stockPanel.getStacks();
    }

    public ArrayList<IStack> getUpStack() {
        return upPanel.getStacks();
    }

    public ArrayList<IStack> getTable(){
        return tablePanel.getStacks();
    }
}
