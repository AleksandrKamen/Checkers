package Pieces;

import Board.Board;

import java.util.Set;

public class Queen extends Piece{
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
        unicod =  "© ";
    }

    @Override
    public boolean isSquareAvaibleforMove(Coordinates coordinates, Board board) {
        return super.isSquareAvaibleforMove(coordinates, board);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMove() {
        return null;
    }
}
