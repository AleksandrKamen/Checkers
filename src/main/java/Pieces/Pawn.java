package Pieces;
import Board.Board;
import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
        unicod = "● ";
    }

    @Override
    public Set<CoordinatesShift> getPieceMove(Board board) {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 && j != 0) {
                    try {
                        Coordinates coordinates1 = new Coordinates(File.values()[coordinates.file.ordinal() + i], coordinates.rank + j);
                        if (!board.isSquareEmpty(coordinates1) && board.getPiece(coordinates1).color != color) {
                            result.add(new CoordinatesShift(i * 2, j * 2));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                }
            }
        }
        if (color == Color.White) {
            result.add(new CoordinatesShift(1, 1));
            result.add(new CoordinatesShift(-1, 1));
        } else {
            result.add(new CoordinatesShift(-1, -1));
            result.add(new CoordinatesShift(1, -1));
        }
        return result;
    }
}
