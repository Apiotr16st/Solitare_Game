package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import org.example.model.game.GameLogic;
import org.example.model.CardPlace;
import org.example.model.card.EmptyCard;
import org.example.model.stack.IStack;
import org.example.view.CardImage;
import org.example.model.card.ICard;


import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;


public class GameController implements Initializable {

    @FXML
    private VBox stack_1VBox;

    @FXML
    private VBox stack_2VBox;

    @FXML
    private VBox stack_3VBox;

    @FXML
    private VBox stack_4VBox;

    @FXML
    private VBox stack_5VBox;

    @FXML
    private VBox stack_6VBox;

    @FXML
    private VBox stack_7VBox;

    @FXML
    private HBox Up_stack_1;

    @FXML
    private HBox Up_stack_2;

    @FXML
    private HBox Up_stack_3;

    @FXML
    private HBox Up_stack_4;

    @FXML
    private HBox usedStacks;

    @FXML
    private HBox toUseStack;

    @FXML
    private Button undoMove;

    @FXML
    public Button redoMove;

    @FXML
    private Button newGame;

    @FXML
    private BorderPane main;

    private ICard clicked = null;
    private CardPlace place = null;
    private GameLogic game = new GameLogic();
    private HashMap<ICard, CardImage> cardImages = new HashMap<>();
    private List<VBox> tableStacksList ;
    private List<HBox> upStacksList ;


    public void initialize(URL location, ResourceBundle resources){
        for (ICard card : game.getCards()){
            cardImages.put(card, new CardImage(card));
        }
        this.tableStacksList = List.of(stack_1VBox, stack_2VBox, stack_3VBox, stack_4VBox, stack_5VBox, stack_6VBox, stack_7VBox);
        this.upStacksList = List.of(Up_stack_1, Up_stack_2, Up_stack_3, Up_stack_4);

        undoMove.setOnAction(e -> undoMove());
        redoMove.setOnAction(e -> redoMove());
        newGame.setOnAction(e -> newGame());

        updateTableStacks();
        updateStockPanel();
        upadteUpStacks();
    }

    private void updateStockPanel() {
        toUseStack.getChildren().clear();
        usedStacks.getChildren().clear();

        ICard toUseCard = game.getStock().get(0).getUpCard();
        ICard usedCard = game.getStock().get(1).getUpCard();

        List<ICard> list = List.of(toUseCard, usedCard);

        for(ICard card : list){
            cardImages.get(card).setTranslateY(0);
            cardImages.get(card).reverseCard(card.isHidden());
            toUseStack.getChildren().add(cardImages.get(card));
        }

        cardImages.get(toUseCard).setOnMouseClicked(e -> toUseStackClicked());
        cardImages.get(toUseCard).setCursor(javafx.scene.Cursor.HAND);

        setUpOnMouseClicked(usedCard, CardPlace.STOCK);
    }

    private void upadteUpStacks(){
        for(int i = 0; i<4; i++){
            upStacksList.get(i).getChildren().clear();
            ICard card = game.getUpStack().get(i).getUpCard();
            upStacksList.get(i).getChildren().add(cardImages.get(card));
            cardImages.get(card).setTranslateY(0);
            setUpOnMouseClicked(card, CardPlace.UP);
        }
    }

    private void updateTableStacks(){
        for(int i = 0; i<7; i++) {
            tableStacksList.get(i).getChildren().clear();
            IStack stack = game.getTable().get(i);
            VBox pane = tableStacksList.get(i);

            int transY = 0;
            boolean unhide = false;
            for(int j=0; j<stack.getCards().size(); j++){
                ICard card = stack.getCards().get(j);
                if(!card.isHidden()) {
                    if(unhide)
                        transY += 20;
                    if(j!=0)
                        unhide = true;
                    setUpOnMouseClicked(card, CardPlace.TABLE);
                }
                pane.getChildren().add(cardImages.get(card));
                cardImages.get(card).setTranslateY(transY);
                transY += 20;
                cardImages.get(card).reverseCard(card.isHidden());
            }
            cardImages.get(stack.getCards().get(0)).setTranslateY(20);
        }
    }

    private void update(CardPlace place){
        switch (place){
            case STOCK -> updateStockPanel();
            case UP -> upadteUpStacks();
            case TABLE -> updateTableStacks();
        }
    }

    private void setUpOnMouseClicked(ICard card, CardPlace cardPlace){
        cardImages.get(card).setOnMouseClicked(e -> {
            cardClicked(card, cardPlace);
        });
        cardImages.get(card).setCursor(javafx.scene.Cursor.HAND);
    }

    private void cardClicked(ICard card, CardPlace cardPlace){
        if(card instanceof EmptyCard && clicked == null){
            return;
        }
        if(clicked == card){
            cardImages.get(clicked).setOpacity(1);
            clicked = null;
            place = null;
        }
        else if(clicked == null){
            clicked = card;
            place = cardPlace;
            cardImages.get(card).setOpacity(0.8);
        }
        else{
            cardImages.get(clicked).setOpacity(1);
            game.moveCard(clicked, place, card, cardPlace);
            if(place == cardPlace){
                update(place);
            }
            else{
                update(place);
                update(cardPlace);
            }
            clicked = null;
            place = null;
        }
    }

    private void toUseStackClicked() {
        if (clicked != null) {
            cardImages.get(clicked).setOpacity(1);
            clicked = null;
            place = null;
        }
        game.nextCard();
        updateStockPanel();
    }

    private void undoMove(){
        game.undoMove();
        update(CardPlace.TABLE);
        update(CardPlace.STOCK);
        update(CardPlace.UP);
    }

    private void redoMove() {
        game.redoMove();
        update(CardPlace.TABLE);
        update(CardPlace.STOCK);
        update(CardPlace.UP);
    }

    private void newGame(){
        this.clicked = null;
        this.place = null;
        this.game = new GameLogic();
        this.cardImages = new HashMap<>();
        initialize(null, null);
        update(CardPlace.TABLE);
        update(CardPlace.STOCK);
        update(CardPlace.UP);
    }

}
