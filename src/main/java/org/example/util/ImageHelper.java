package org.example.util;

import javafx.scene.image.Image;
import org.example.controller.GameController;
import org.example.model.card.ICard;

import java.util.Objects;

public class ImageHelper {
    public static String parseImage(ICard card){
        String res = switch (card.getNumber()) {
            case ACE -> "A";
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            case TEN -> "10";
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            case NONE -> "gray_back";
        };
        String res2 = switch (card.getColor()) {
            case SPADE -> "S";
            case HEART -> "H";
            case CLUB -> "C";
            case DIAMOND -> "D";
            case NONE -> "";
        };
        return "/images/" + res + res2 + ".png";
    }

    public static Image loadImage(ICard card){
        return new Image( ImageHelper.class.getResource(parseImage(card)).toExternalForm());
    }

    public static Image loadFieldImage() {
        return new Image( ImageHelper.class.getResource("/images/gray_back.png").toExternalForm());
    }

    public static Image loadBackImage(){
        return new Image( ImageHelper.class.getResource("/images/red_back.png").toExternalForm() );
    }
}