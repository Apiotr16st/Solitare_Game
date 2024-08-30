package org.example.game;

import org.example.model.CardPlace;
import org.example.model.Move;
import org.example.model.panel.StockPanel;
import org.example.model.panel.UpPanel;
import org.example.model.card.ICard;
import org.example.model.Deck;
import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;
import org.example.model.panel.TablePanel;

import java.util.ArrayList;
import java.util.Collection;

public class GameLogic {

    private final TablePanel tablePanel;
    private final StockPanel stockPanel;
    private final UpPanel upPanel;
    private final MoveHistory moveHistory = new MoveHistory();
    private final Collection<ICard> cards = new ArrayList<>();

    public GameLogic() {
        Deck deck = new Deck();
        this.tablePanel = new TablePanel((ArrayList<ICard>) deck.getCards(28));
        this.stockPanel = new StockPanel(deck.getCards());
        this.upPanel = new UpPanel();
    }

    public Collection<ICard> getCards() {
        cards.addAll(tablePanel.getCards());
        cards.addAll(stockPanel.getCards());
        cards.addAll(upPanel.getCards());
        return cards;
    }

    public ArrayList<IStack> getTable(){
        return this.tablePanel.getStacks();
    }

    private IStack searchStack(ICard card, CardPlace place){
        return switch (place) {
            case TABLE -> tablePanel.searchStack(card);
            case UP -> upPanel.searchStack(card);
            case STOCK -> stockPanel.searchStack(card);
        };
    }

    public void moveCard(Move move){
        ICard cardTo = move.cardFrom();
        ICard cardMoved = move.cardMoved();
        CardPlace placeTo = move.placeTo();
        CardPlace placeFrom = move.placeFrom();

        IStack stackTo = searchStack(cardTo, placeTo);
        IStack stackMoved = searchStack(cardMoved, placeFrom);

        if(placeFrom == CardPlace.TABLE){
            TableStack stack = (TableStack) stackMoved;
            Collection<ICard> cards = stack.getCardsFrom(cardMoved);
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
            moveHistory.addMove(new Move(cardFrom, cardMoved, placeFrom, placeTo));
        }
    }

    private void moveCardBack(Move move) { // to fix, moving more than 1 card at table hides the cards
        ICard cardFrom = move.cardFrom();
        ICard cardMoved = move.cardMoved();

        if (cardFrom == null || cardMoved == null) {
            stockPanel.backCard();
            return;
        }

        IStack stackFrom = searchStack(cardFrom, move.placeTo());
        IStack stackMoved = searchStack(cardMoved, move.placeFrom());

        if(move.placeTo() == CardPlace.TABLE){
            TableStack stack = (TableStack) stackMoved;
            Collection<ICard> cards = stack.getCardsFrom(cardMoved);
            for(ICard card : cards){
                if(stackFrom.addCardDirectly(card)){
                    stackMoved.removeCard(card);
                }
            }
        }
        else {
            if(stackFrom.addCardDirectly(cardMoved)) {
                stackMoved.removeCard(cardMoved);
            }
        }
    }

    public void nextCard() {
        stockPanel.nextCard();
        moveHistory.addMove(new Move(null, null, CardPlace.STOCK, CardPlace.STOCK));
    }

    public ArrayList<IStack> getStock(){
        return stockPanel.getStacks();
    }

    public ArrayList<IStack> getUpStack() {
        return upPanel.getStacks();
    }

    public void undoMove(){
        Move move = moveHistory.undoMove();
        if(move == null){
            return;
        }
        moveCardBack(move);
    }
}
