package org.example.game;

import org.example.model.Move;

import java.util.LinkedList;

public class MoveHistory {
    private final LinkedList<Move> moves = new LinkedList<>();
    private final LinkedList<Boolean> hidePrevious = new LinkedList<>();

    void addMove(Move move, boolean hiddePrevious){
        this.moves.add(move);
        this.hidePrevious.add(hiddePrevious);
    }

    public Move undoMove(){
        if(this.moves.isEmpty()){
            return null;
        }
        return this.moves.remove(this.moves.size()-1);
    }

    public boolean undoHide(){
        if(this.hidePrevious.isEmpty()){
            return false;
        }
        return this.hidePrevious.remove(this.hidePrevious.size()-1);
    }
}
