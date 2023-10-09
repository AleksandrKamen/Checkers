import Pieces.*;
import java.util.HashMap;

public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<Coordinates, Piece>();

    public void setPiece(Coordinates coordinates, Piece piece){
        piece.coordinates = coordinates;
        pieces.put(coordinates,piece);
    }
    public void removePiece(Coordinates coordinates){
        pieces.remove(coordinates);
    }

}
