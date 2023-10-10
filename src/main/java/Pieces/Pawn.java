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
    public Set<CoordinatesShift> getPieceMove(Board board) {
        Set<CoordinatesShift> result = new HashSet<>();
        if (color == Color.White) {
            result.add(new CoordinatesShift(1, 1));
            result.add(new CoordinatesShift(-1, 1));
            try {
                Coordinates coordinates1 = new Coordinates(File.values()[coordinates.file.ordinal() + 1], coordinates.rank + 1);
                Coordinates coordinates2 = new Coordinates(File.values()[coordinates.file.ordinal() - 1], coordinates.rank + 1);
                Coordinates coordinates3 = new Coordinates(File.values()[coordinates.file.ordinal() - 1], coordinates.rank - 1);
                Coordinates coordinates4 = new Coordinates(File.values()[coordinates.file.ordinal() + 1], coordinates.rank - 1);
            if (!board.isSquareEmpty(coordinates1) && board.getPiece(coordinates1).color != color) {
                result.add(new CoordinatesShift(2, 2));
            }
            if (!board.isSquareEmpty(coordinates2) && board.getPiece(coordinates2).color != color) {
                result.add(new CoordinatesShift(-2, 2));
            }
            if (!board.isSquareEmpty(coordinates3) && board.getPiece(coordinates3).color != color) {
                result.add(new CoordinatesShift(-2, -2));
            }
            if (!board.isSquareEmpty(coordinates4) && board.getPiece(coordinates4).color != color) {
                result.add(new CoordinatesShift(2, -2));
            }
        } catch (ArrayIndexOutOfBoundsException e){}
        }
        else {
            result.add(new CoordinatesShift(-1, -1));
            result.add(new CoordinatesShift(1, -1));
            try {
                Coordinates coordinates1 = new Coordinates(File.values()[coordinates.file.ordinal() + 1], coordinates.rank + 1);
                Coordinates coordinates2 = new Coordinates(File.values()[coordinates.file.ordinal() - 1], coordinates.rank + 1);
                Coordinates coordinates3 = new Coordinates(File.values()[coordinates.file.ordinal() - 1], coordinates.rank - 1);
                Coordinates coordinates4 = new Coordinates(File.values()[coordinates.file.ordinal() + 1], coordinates.rank - 1);

                if (!board.isSquareEmpty(coordinates1) && board.getPiece(coordinates1).color != color) {
                    result.add(new CoordinatesShift(2, 2));
                }
                if (!board.isSquareEmpty(coordinates2) && board.getPiece(coordinates2).color != color) {
                    result.add(new CoordinatesShift(-2, 2));
                }
                if (!board.isSquareEmpty(coordinates3) && board.getPiece(coordinates3).color != color) {
                    result.add(new CoordinatesShift(-2, -2));
                }
                if (!board.isSquareEmpty(coordinates4) && board.getPiece(coordinates4).color != color) {
                    result.add(new CoordinatesShift(2, -2));
                }
            } catch (ArrayIndexOutOfBoundsException e){}
        }

        return result;
    }

}
