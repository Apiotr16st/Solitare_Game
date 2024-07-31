package org.example;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

    public void initialize(URL location, ResourceBundle resources){
        GameLogic gameLogic = new GameLogic();
        ArrayList<TableStack> tb = gameLogic.getTable();

        for (int i=0; i<7; i++){
            TableStack stack = tb.get(i);
            Collection<ICard> cards = stack.getCards();
            int movment = 0;
            int iter = 0;
            StackPane stackPane = new StackPane();

            for (ICard card : cards){
                Image img;
                int flag;
                if(iter != i){
                    img = new Image(Objects.requireNonNull(GameController.class.getResource("/images/red_back.png")).toExternalForm());
                    flag  =  0;
                }
                else {
                    img = new Image(Objects.requireNonNull(GameController.class.getResource(ImageParser.parseImage(card))).toExternalForm());
                    flag  =  1;
                }

                ImageView imageView = new ImageView(img);
                imageView.setFitWidth(150);
                imageView.setFitHeight(150);
                imageView.setPreserveRatio(true);
                imageView.setTranslateY(movment);
                if(flag==1){
                    imageView.setOnMouseClicked(e -> {
                        border(imageView);

                    });
                    imageView.setCursor(Cursor.HAND);
                }
                movment += 20;
                iter++;
                stackPane.getChildren().add(imageView);
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

    private void border(ImageView imageView){
        imageView.setStyle("-fx-border-color: red; -fx-border-width: 50px;"); // NIE DZIAlA
        System.out.println("Clicked");
    }
}
