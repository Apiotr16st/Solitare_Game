package org.example.game;

import org.example.model.Move;

import java.util.LinkedList;

public class MoveHistory {
    private final LinkedList<Move> moves = new LinkedList<>();

    void addMove(Move move){
        this.moves.add(move);
    }

    public Move undoMove(){
        if(this.moves.isEmpty()){
            return null;
        }
        return this.moves.remove(this.moves.size()-1);
    }
}
