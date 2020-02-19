package com.udacity.chess;

public class Rock extends Piece {
    boolean isValidMove(Position newPosition) {
        if (newPosition.column == this.position.column || newPosition.row == this.position.row) {
            return true;
        } else {
            return false;
        }
    }
}
