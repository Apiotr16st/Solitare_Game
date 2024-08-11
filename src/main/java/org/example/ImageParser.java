package org.example;

import org.example.card.Card;
import org.example.card.ICard;

import java.awt.*;

public class ImageParser {
    public static String parseImage(ICard card){
        String res;
        switch (card.getNumber()){
            case AS:
                res = "A";
                break;
            case TWO:
                res = "2";
                break;
            case THREE:
                res = "3";
                break;
            case FOUR:
                res = "4";
                break;
            case FIVE:
                res = "5";
                break;
            case SIX:
                res = "6";
                break;
            case SEVEN:
                res = "7";
                break;
            case EIGHT:
                res = "8";
                break;
            case NINE:
                res = "9";
                break;
            case TEN:
                res = "10";
                break;
            case WALET:
                res = "J";
                break;
            case QUEEN:
                res = "Q";
                break;
            case KING:
                res = "K";
                break;
            default:
                res = "ERROR";

        }

        switch (card.getColor()){
            case PIK:
                res += "S";
                break;
            case KIER:
                res += "H";
                break;
            case TREFL:
                res += "C";
                break;
            case KARO:
                res += "D";
                break;
            default:
                res += "ERROR";

        }
        return "/images/" + res + ".png";
    }

}
