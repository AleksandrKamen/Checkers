import Pieces.*;
import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();

    public void setPiece(Coordinates coordinates, Piece piece){
        piece.coordinates = coordinates;
        pieces.put(coordinates,piece);
    }
    public void removePiece(Coordinates coordinates){
        pieces.remove(coordinates);
    }

    public void setDefaultPiecesPosition(){
        for (File file : File.values()) {
            if (file.ordinal() %2 ==0) {
                setPiece(new Coordinates(file, 1), new Pawn(Color.White, new Coordinates(file,1)));
                setPiece(new Coordinates(file, 3), new Pawn(Color.White, new Coordinates(file,3)));
                setPiece(new Coordinates(file, 7), new Pawn(Color.Black, new Coordinates(file,7)));
            } else {
                setPiece(new Coordinates(file, 2), new Pawn(Color.White, new Coordinates(file,2)));
                setPiece(new Coordinates(file, 6), new Pawn(Color.Black, new Coordinates(file,6)));
                setPiece(new Coordinates(file, 8), new Pawn(Color.Black, new Coordinates(file,8)));
            }
        }
    }

    public  Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }
    public boolean isSquareEmpty(Coordinates coordinates){
        return !pieces.containsKey(coordinates);
    } // Метод определения пустая ли клетка
    public static boolean isSquareBlack(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

}
