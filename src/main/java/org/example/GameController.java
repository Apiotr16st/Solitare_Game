package org.example;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.example.card.Card;
import org.example.card.ICard;
import org.example.bar.stack.TableStack;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class GameController implements Initializable {
    public HBox stackPanes;
    public HBox usedStacks;
    public HBox toUseStack;
    private ICard clicked = null;
    private final GameLogic game = new GameLogic();
    private ArrayList<TableStack> tb = game.getTable();
    private final StackPane toUsePane = new StackPane();
    private final StackPane rightCardPane = new StackPane() ;

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
            ArrayList<ICard> cards = (ArrayList<ICard>) stack.getCards();
            if(cards.isEmpty()){
                Image img = ImageController.loadFieldImage();
                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(130);
                imageView.setPreserveRatio(true);
                imageView.setTranslateY(0);
                imageView.setOpacity(0.5);

//                if(clicked!=null && clicked.getNumber()== Number.KING){
//                    imageView.setCursor(Cursor.HAND);
//                    imageView.setOnMouseClicked(e -> {
//                        game.moveCard(clicked, null); // DO ZMIANY
//                        clicked.getCardImage().getView().setOpacity(1);
//                        clicked = null;
//                        drawApp();
//                    });
//                }

                StackPane pane = new StackPane();
                pane.getChildren().add(imageView);
                stackPanes.getChildren().add(pane);
                continue;
            }
            int movment = 0;
            StackPane pane = new StackPane();
            for (ICard card : cards){
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
                movment += extra;
                pane.getChildren().add(view);
            }
            stackPanes.getChildren().add(pane);
        }
    }

    private void drawTopCards(){
        for (int i=0; i<4; i++){
            StackPane pane = new StackPane();
            Image img = ImageController.loadFieldImage();
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(130);
            imageView.setPreserveRatio(true);
            imageView.setOpacity(0.5);
            pane.getChildren().add(imageView);
            usedStacks.getChildren().add(pane);
        }
    }

    private void drawToUseStack(){
        Image img1;
        ImageView toUse;
        ImageView rightCard;
        Card card = game.getFirstRightCard();

        if(game.isToUseEmpty()){
            img1 = ImageController.loadFieldImage();
            toUse = new ImageView(img1);
            toUse.setOpacity(0.5);
        }
        else{
            img1 = ImageController.loadBackImage();
            toUse = new ImageView(img1);
        }

        if(card==null){
            Image img2 = ImageController.loadFieldImage();
            rightCard = new ImageView(img2);
            rightCard.setOpacity(0.5);
        }
        else{
            rightCard = card.getCardImage().getView();
            rightCard.setOnMouseClicked(e -> {
                cardClicked(card);
                rightCard.setCursor(Cursor.HAND);
            });
        }

        toUse.setFitWidth(130);
        rightCard.setFitWidth(130);

        toUse.setPreserveRatio(true);
        rightCard.setPreserveRatio(true);

        toUse.setOnMouseClicked(e -> {
            toUseStackClicked();
        });
        toUse.setCursor(Cursor.HAND);

        toUsePane.getChildren().add(toUse);
        rightCardPane.getChildren().add(rightCard);
        toUseStack.getChildren().add(toUsePane);
        toUseStack.getChildren().add(rightCardPane);
    }

    private void cardClicked(ICard cardImage){
        if(clicked == cardImage){
            clicked.getCardImage().getView().setOpacity(1);
            clicked = null;
        }
        else if(clicked == null){
            clicked = cardImage;
            cardImage.getCardImage().getView().setOpacity(0.8);
        }
        else{
            game.moveCard(cardImage, clicked);
            clicked.getCardImage().getView().setOpacity(1);
            clicked = null;
            drawApp();
        }
    }

    private void toUseStackClicked(){
        game.nextCard();
        drawApp();
    }
}
