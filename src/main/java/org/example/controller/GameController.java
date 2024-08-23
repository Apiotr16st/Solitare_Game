package org.example.controller;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.example.GameLogic;
import org.example.model.stack.FinalStack;
import org.example.model.card.Card;
import org.example.model.card.EmptyCard;
import org.example.model.card.ICard;
import org.example.model.stack.TableStack;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;


public class GameController implements Initializable {
    public HBox stackPanes;
    public HBox usedStacks;
    public HBox toUseStack;
    public Button undoMove;
    private ICard clicked = null;
    private final GameLogic game = new GameLogic();
    private final ArrayList<TableStack> tb = game.getTable();
    private final StackPane toUsePane = new StackPane();
    private final StackPane rightCardPane = new StackPane() ;
    private final ArrayList<FinalStack> finalStacks = game.getFinalStacks();

    public void initialize(URL location, ResourceBundle resources){
        drawApp();
    }

    private void drawApp(){
        clear();
        drawMiddleCards();
        drawTopCards();
        drawToUseStack();
    }

    private void clear(){
        stackPanes.getChildren().clear();
        usedStacks.getChildren().clear();
        toUseStack.getChildren().clear();
        toUsePane.getChildren().clear();
        rightCardPane.getChildren().clear();
    }

    private void drawMiddleCards(){
        for (int i=0; i<7; i++){
            TableStack stack = tb.get(i);
            Stack<ICard> cards = stack.getCards();
            int movment = 0;
            int base = 0;
            StackPane pane = new StackPane();
            for (ICard card : cards){
                base ++;
                ImageView view = card.getCardImage().getView();
                int extra = 0;
                if(!card.isHidden()){
                    view.setOnMouseClicked(e -> {
                        cardClicked(card);
                    });
                    view.setCursor(Cursor.HAND);
                    extra = 20;
                }
                card.getCardImage().setMovement(movment);
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
            StackPane pane = new StackPane();
            FinalStack stack = finalStacks.get(i);

            ImageView view = stack.getUpCard().getCardImage().getView();
            view.setOnMouseClicked(e -> {
                view.setCursor(Cursor.HAND);
                cardClicked(stack.getUpCard());
            });

            pane.getChildren().add(view);
            usedStacks.getChildren().add(pane);
        }
    }

    private void drawToUseStack(){
        ImageView toUse = game.getLeftStack().getCardImage().getView();
        ImageView rightCard = game.getFirstRightCard().getCardImage().getView();

        toUse.setOnMouseClicked(e -> {
            toUseStackClicked();
        });
        toUse.setCursor(Cursor.HAND);

        if(game.getFirstRightCard() instanceof Card){
            rightCard.setCursor(Cursor.HAND);
            rightCard.setOnMouseClicked(e -> {
                cardClicked(game.getFirstRightCard());
            });
        }

        toUsePane.getChildren().add(toUse);
        rightCardPane.getChildren().add(rightCard);
        toUseStack.getChildren().add(toUsePane);
        toUseStack.getChildren().add(rightCardPane);
    }

    private void cardClicked(ICard cardImage){
        if(cardImage instanceof EmptyCard && clicked == null){
            return;
        }
        if(clicked == cardImage){
            clicked.getCardImage().getView().setOpacity(1);
            clicked = null;
        }
        else if(clicked == null){
            clicked = cardImage;
            cardImage.getCardImage().getView().setOpacity(0.8);
        }
        else{
            try{
                game.moveCard(cardImage, clicked);
            }
            catch (IllegalArgumentException e){
                clicked.getCardImage().getView().setOpacity(1);
                clicked = null;
                return;
            }

            clicked.getCardImage().getView().setOpacity(1);
            clicked = null;
            drawApp();
        }
    }

    private void toUseStackClicked(){
        if(clicked != null){
            clicked.getCardImage().getView().setOpacity(1);
            clicked = null;
        }
        game.nextCard();
        drawApp();
    }
}
