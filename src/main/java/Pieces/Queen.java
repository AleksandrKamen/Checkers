package Pieces;
import Board.Board;
import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
        unicod =  "© ";
    }

    @Override
    protected Set<CoordinatesShift> getPieceMove(Board board) {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = 1; i <= 8; i++){
            try {
                Coordinates coordinates1 = new Coordinates(File.values()[coordinates.file.ordinal() + i], coordinates.rank + i);
                if (!board.isSquareEmpty(coordinates1)){
                    if (board.getPiece(coordinates1).color == color) break;
                    else if(!board.isSquareEmpty(new Coordinates(File.values()[coordinates1.file.ordinal()+1],coordinates1.rank+1))) break;
                }
                result.add(new CoordinatesShift(i,i));
            } catch (Exception e){}
        }
        for (int i = 1; i <= 8; i++){
            try {
                Coordinates coordinates2 = new Coordinates(File.values()[coordinates.file.ordinal() - i], coordinates.rank - i);
                if (!board.isSquareEmpty(coordinates2)){
                    if (board.getPiece(coordinates2).color == color) break;
                    else  if (!board.isSquareEmpty(new Coordinates(File.values()[coordinates2.file.ordinal()-1],coordinates2.rank-1))) break;
                }
                result.add(new CoordinatesShift(-i,-i));
            } catch (Exception e){}
        }

        for (int i = 1; i <= 8; i++){
            try {
                Coordinates coordinates2 = new Coordinates(File.values()[coordinates.file.ordinal() - i], coordinates.rank + i);
                if (!board.isSquareEmpty(coordinates2)){
                    if (board.getPiece(coordinates2).color == color) break;
                    else  if (!board.isSquareEmpty(new Coordinates(File.values()[coordinates2.file.ordinal()-1],coordinates2.rank+1))) break;
                }
                result.add(new CoordinatesShift(-i, i));
            } catch (Exception e){}
        }
        for (int i = 1; i <= 8; i++){
            try {
                Coordinates coordinates2 = new Coordinates(File.values()[coordinates.file.ordinal() + i], coordinates.rank - i);
                if (!board.isSquareEmpty(coordinates2)){
                    if (board.getPiece(coordinates2).color == color) break;
                    else  if (!board.isSquareEmpty(new Coordinates(File.values()[coordinates2.file.ordinal()+1],coordinates2.rank-1))) break;
                }
                result.add(new CoordinatesShift(i, -i));
            } catch (Exception e){}
        }
        return result;
    }
}
