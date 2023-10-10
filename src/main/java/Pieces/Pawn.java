package Pieces;

import Board.Board;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece{

    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
        unicod = "● ";
    }
      @Override
    public Set<CoordinatesShift> getPieceMove() {
        Set<CoordinatesShift> result = new HashSet<>();
        result.add(new CoordinatesShift(1,1));
        result.add(new CoordinatesShift(-1,1));

        return result;
    }
}
