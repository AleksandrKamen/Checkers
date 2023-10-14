package Pieces;

import Board.*;

import java.util.HashSet;
import java.util.Set;

public abstract class Piece {
    public final Color color;
    public Coordinates coordinates;
    protected String unicod;

    public String getUnicod() {
        return unicod;
    }

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }

    public boolean isSquareAvaibleforMove(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates);
    }

    protected abstract Set<CoordinatesShift> getPieceMove(Board board);

    public Set<Coordinates> getSquareAvaibleforMove(Board board) {
        var mustAttackSqyare = new HashSet<Coordinates>();
        var SquareAvaible = new HashSet<Coordinates>();
        var pieceMove = getPieceMove(board);
        for (CoordinatesShift shift : pieceMove) {
            if (coordinates.canShift(shift)) {
                Coordinates newCoordinates = coordinates.shift(shift);
                if (isSquareAvaibleforMove(newCoordinates, board)) {
                    SquareAvaible.add(newCoordinates);
                }
            }
        }

        for (Coordinates coordinates1 : SquareAvaible){
            var coordinatesBetweenSquare = board.getCoordinatesBetweenSquare(coordinates, coordinates1);
            for (Coordinates coordinates2 : coordinatesBetweenSquare){
                if (board.getPiece(coordinates2)!= null) mustAttackSqyare.add(coordinates1);
            }

        }

        return mustAttackSqyare.isEmpty()?SquareAvaible:mustAttackSqyare;
    }


}
