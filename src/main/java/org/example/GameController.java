package org.example;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.example.card.CardImage;
import org.example.card.ICard;
import org.example.bar.stack.TableStack;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    public HBox stackPanes;
    public HBox usedStacks;
    private CardImage clicked = null;
    private GameLogic game = new GameLogic();
    private ArrayList<TableStack> tb = game.getTable();

    public void initialize(URL location, ResourceBundle resources){
        drawApp();
    }

    private void drawApp(){
        this.tb = game.getTable();
        for (int i=0; i<7; i++){
            TableStack stack = tb.get(i);
            Collection<ICard> cards = stack.getCards();
            int movment = 0;
            int iter = 0;
            StackPane stackPane = new StackPane();

            for (ICard card : cards){
                CardImage cardImage = new CardImage(card);
                cardImage.setMovment(movment);
                ImageView view = cardImage.getView();
                int isHidden = 1;
                if(iter != i){
                    isHidden  =  0;
                    cardImage.flip();
                }
                if(isHidden==1){
                    view.setOnMouseClicked(e -> {
                        cardClicked(cardImage);
                    });
                    view.setCursor(Cursor.HAND);
                }
                movment += 20;
                iter++;

                stackPane.getChildren().add(view);
            }
            stackPanes.getChildren().add(stackPane);
        }

        for (int i=0; i<4; i++){
            StackPane stackPane = new StackPane();
            Image img = new Image(Objects.requireNonNull(GameController.class.getResource("/images/gray_back.png")).toExternalForm());
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(true);
            imageView.setTranslateY(0);
            imageView.setOpacity(0.5);
            stackPane.getChildren().add(imageView);
            usedStacks.getChildren().add(stackPane);
        }
    }

    private void cardClicked(CardImage cardImage){
        if(clicked == cardImage){
            clicked.getView().setOpacity(1);
            clicked = null;
        }
        else if(clicked == null){
            clicked = cardImage;
            cardImage.getView().setOpacity(0.8);
        }
        else{
            game.moveCard(clicked, cardImage);
            clicked.getView().setOpacity(1);
            clicked = null;
//            drawApp();
        }
    }
}
