package org.example.controller;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.example.game.GameLogic;
import org.example.model.CardPlace;
import org.example.model.Move;
import org.example.model.image.CardImage;
import org.example.model.image.ICardImage;
import org.example.model.stack.FinalStack;
import org.example.model.card.Card;
import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;
import org.example.model.stack.IStack;
import org.example.model.stack.TableStack;


import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Stack;


public class GameController implements Initializable {
    public HBox stackPanes;
    public HBox usedStacks;
    public HBox toUseStack;
    public Button undoMove;
    private ICard clicked = null;
    private CardPlace place = null;
    private final GameLogic game = new GameLogic();
    private final StackPane toUsePane = new StackPane();
    private final StackPane rightCardPane = new StackPane() ;
    private final HashMap<ICard, ICardImage> cardImages = new HashMap<>();

    public void initialize(URL location, ResourceBundle resources){
        for (ICard card : game.getCards()){
            cardImages.put(card, new CardImage(card));
        }

        drawApp();
        undoMove.setOnAction(e -> {
            game.undoMove();
            drawApp();
        });
    }

    private void drawApp(){
        clear();
        drawTableCards();
        drawTopCards();
        drawStock();
    }

    private void clear(){
        stackPanes.getChildren().clear();
        usedStacks.getChildren().clear();
        toUseStack.getChildren().clear();
        toUsePane.getChildren().clear();
        rightCardPane.getChildren().clear();
    }

    private void drawTableCards(){
        ArrayList<IStack> tb = game.getTable();
        for (int i=0; i<7; i++){
            TableStack stack = (TableStack) tb.get(i);
            Stack<ICard> cards = stack.getCards();
            int movment = 0;
            int base = 0;
            StackPane pane = new StackPane();
            for (ICard card : cards){
                base ++;
                ICardImage cardimg = cardImages.get(card);
                ImageView view = cardimg.getView();
                int extra = 0;
                if(!card.isHidden()){
                    cardimg.setHidden(false);
                    view.setOnMouseClicked(e -> {
                        cardClicked(card, CardPlace.TABLE);
                    });
                    view.setCursor(Cursor.HAND);
                    extra = 20;
                }
                else{
                    cardimg.setHidden(true);
                }

                cardImages.get(card).setMovement(movment);
                movment += 20;
                if(base==1){
                    movment = 0;
                    extra = 0;
                }
                movment += extra;
                pane.getChildren().add(view);
            }
            stackPanes.getChildren().add(pane);
        }
    }

    private void drawTopCards(){
        for (int i=0; i<4; i++){
            ArrayList<IStack> finalStacks = game.getUpStack();
            StackPane pane = new StackPane();
            FinalStack stack = (FinalStack) finalStacks.get(i);
            cardImages.get(stack.getUpCard()).setMovement(0);
            ImageView view = cardImages.get(stack.getUpCard()).getView();
            view.setOnMouseClicked(e -> {
                view.setCursor(Cursor.HAND);
                cardClicked(stack.getUpCard(), CardPlace.UP);
            });

            pane.getChildren().add(view);
            usedStacks.getChildren().add(pane);
        }
    }

    private void drawStock(){
        ArrayList<IStack> stockStacks = game.getStock();
        ICard toUse = stockStacks.get(0).getUpCard();
        ICard rightCard = stockStacks.get(1).getUpCard();

        ICardImage rightImg = cardImages.get(rightCard);
        ICardImage toUseImg = cardImages.get(toUse);

        toUseImg.setMovement(0);
        rightImg.setMovement(0);
        toUseImg.setHidden(toUse.isHidden());
        rightImg.setHidden(rightCard.isHidden());

        ImageView toUseView = toUseImg.getView();
        ImageView rightCardView = rightImg.getView();

        toUseView.setOnMouseClicked(e -> {
            toUseStackClicked();
        });
        toUseView.setCursor(Cursor.HAND);

        if(rightCard instanceof Card){
            rightCardView.setCursor(Cursor.HAND);
            rightCardView.setOnMouseClicked(e -> {
                cardClicked(rightCard, CardPlace.STOCK);
            });
        }

        toUsePane.getChildren().add(toUseView);
        rightCardPane.getChildren().add(rightCardView);
        toUseStack.getChildren().add(toUsePane);
        toUseStack.getChildren().add(rightCardPane);
    }

    private void cardClicked(ICard card, CardPlace cardPlace){
        if(card instanceof EmptyCard && clicked == null){
            return;
        }
        if(clicked == card){
            cardImages.get(clicked).getView().setOpacity(1);
            clicked = null;
            place = null;
        }
        else if(clicked == null){
            clicked = card;
            place = cardPlace;
            cardImages.get(card).getView().setOpacity(0.8);
        }
        else{
            game.moveCard(new Move(clicked, place, card, cardPlace));
            cardImages.get(clicked).getView().setOpacity(1);
            clicked = null;
            place = null;
            drawApp();
        }
    }

    private void toUseStackClicked(){
        if(clicked != null){
            cardImages.get(clicked).getView().setOpacity(1);
            clicked = null;
            place = null;
        }
        game.nextCard();
        drawApp();
    }
}
