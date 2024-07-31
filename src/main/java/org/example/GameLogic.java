package org.example;

import org.example.bar.LeftStack;
import org.example.card.Card;
import org.example.card.Tail;
import org.example.bar.stack.TableStack;
import org.example.bar.TableBar;

import java.util.ArrayList;

public class GameLogic {

    private TableBar tableBar;
    private LeftStack leftStack;

//    private

    public GameLogic() {
//        new Card(Number.values()[number], Color.values()[color], false);
        Tail tail = new Tail();
        this.tableBar = new TableBar((ArrayList<Card>) tail.getCards(28));
        this.leftStack = new LeftStack(tail.getCards());
    }


    public ArrayList<TableStack> getTable(){
        return this.tableBar.getStacks();
    }

}
