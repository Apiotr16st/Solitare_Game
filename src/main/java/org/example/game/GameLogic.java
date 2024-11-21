package org.example.game;

import org.example.model.CardPlace;
import org.example.model.Move;
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
    private final MoveHistory moveHistory = new MoveHistory();

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

    public void moveCard(Move move){
        ICard cardTo = move.cardTo();
        ICard cardMoved = move.cardMoved();
        CardPlace placeTo = move.placeTo();
        CardPlace placeFrom = move.placeFrom();

        IStack stackTo = searchStack(cardTo, placeTo);
        IStack stackMoved = searchStack(cardMoved, placeFrom);

        boolean hidePrevious = true;

        if(placeFrom == CardPlace.TABLE){
            TableStack stack = (TableStack) stackMoved;
            Collection<ICard> cards = stack.getCardsFrom(cardMoved);
            hidePrevious = stack.getPreviousCard(cardMoved).isHidden();
            for(ICard card : cards){
                if(stackTo.addCard(card)){
                    stackMoved.removeCard(card);
                }
            }
        }
        else {
            if (stackTo.addCard(cardMoved)) {
                stackMoved.removeCard(cardMoved);
            }
        }

        ICard cardFrom = stackMoved.getUpCard();

        if(cardFrom != null) {
            moveHistory.addMove(new Move(cardMoved, placeTo, cardFrom, placeFrom), hidePrevious);
        }
    }

    private void moveCardBack(Move move, boolean hidePrevious) {
        ICard cardTo = move.cardTo();
        ICard cardMoved = move.cardMoved();

        if (cardTo == null || cardMoved == null) {
            stockPanel.backCard();
            return;
        }

        IStack stackFrom = searchStack(cardTo, move.placeTo());
        IStack stackMoved = searchStack(cardMoved, move.placeFrom());

        if(move.placeFrom() == CardPlace.TABLE){
            TableStack stack = (TableStack) stackMoved;
            Collection<ICard> cards = stack.getCardsFrom(cardMoved);
            ICard upCard = stackFrom.getUpCard();

            for(ICard card : cards){
                if(stackFrom.addCardDirectly(card)){
                    stackMoved.removeCard(card);
                }
            }

            for(ICard card : cards) {
                if (!card.equals(cardTo)) {
                    card.setHiddnes(false);
                }
            }
            upCard.setHiddnes(hidePrevious);
        }
        else {
            if(stackFrom.addCardDirectly(cardMoved)) {
                stackMoved.removeCard(cardMoved);
            }
        }
    }

    public void nextCard() {
        stockPanel.nextCard();
        moveHistory.addMove(new Move(null, CardPlace.STOCK,  null,CardPlace.STOCK), false);
    }

    public void undoMove(){
        Move move = moveHistory.undoMove();
        if(move == null){
            return;
        }
        moveCardBack(move, moveHistory.undoHide());
    }

    public ArrayList<IStack> getStock(){
        return stockPanel.getStacks();
    }

    public ArrayList<IStack> getUpStack() {
        return upPanel.getStacks();
    }

    public ArrayList<IStack> getTable(){
        return this.tablePanel.getStacks();
    }
}
