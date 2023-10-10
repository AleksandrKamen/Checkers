package Pieces;

import Board.Board;

import java.util.Set;

public class Queen extends Piece{
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
        unicod =  "© ";
    }

    @Override
    protected Set<CoordinatesShift> getPieceMove(Board board) {
        return null;
    }
}
