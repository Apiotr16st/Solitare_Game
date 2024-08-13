package org.example;

import javafx.scene.image.Image;
import org.example.card.ICard;

import java.util.Objects;

public class ImageController {
    public static String parseImage(ICard card){
        String res = switch (card.getNumber()) {
            case AS -> "A";
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            case TEN -> "10";
            case WALET -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            default -> "ERROR";
        };
        String res2 = switch (card.getColor()) {
            case PIK -> "S";
            case KIER -> "H";
            case TREFL -> "C";
            case KARO -> "D";
            default -> "ERROR";
        };
        return "/images/" + res + res2 + ".png";
    }

    public static Image loadImage(ICard card){
        return new Image(Objects.requireNonNull(
                GameController.class.getResource(parseImage(card))).toExternalForm());
    }

    public static Image loadFieldImage() {
        return new Image(Objects.requireNonNull(
                GameController.class.getResource("/images/gray_back.png")).toExternalForm());
    }

    public static Image loadBackImage(){
        return new Image(Objects.requireNonNull(
                GameController.class.getResource("/images/red_back.png")).toExternalForm());
    }
}
