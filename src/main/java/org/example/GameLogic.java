package org.example;

import javafx.scene.image.ImageView;
import org.example.bar.LeftStack;
import org.example.card.Card;
import org.example.card.CardImage;
import org.example.card.ICard;
import org.example.card.Tail;
import org.example.bar.stack.TableStack;
import org.example.bar.TableBar;

import java.util.ArrayList;

public class GameLogic {

    private TableBar tableBar;
    private LeftStack leftStack;

    public GameLogic() {
        Tail tail = new Tail();
        this.tableBar = new TableBar((ArrayList<Card>) tail.getCards(28));
        this.leftStack = new LeftStack(tail.getCards());
    }


    public ArrayList<TableStack> getTable(){
        return this.tableBar.getStacks();
    }


    public void moveCard(CardImage clicked, CardImage cardImage) {
        ICard cardMoved = clicked.getCard();
        ICard cardTo = cardImage.getCard();
        if (cardMoved.getNumber().getI() + 1 == cardTo.getNumber().getI()  && cardMoved.colorCompare(cardTo)) {
            System.out.println("Move card");
        }
    }
}
