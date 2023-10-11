package Board;

import Pieces.*;
import java.util.*;


public class Board {
    HashMap<Coordinates, Piece> pieces = new HashMap<>();
    int WhiteRemoveCount = 0, BlackRemoveCount = 0;

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
    public  boolean isSquareBlack(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }
    public boolean isWhitePiece(Piece piece){
        return piece.color == Color.White;
    }

    public void setQueen(){
        for (File file : File.values()) {
            Coordinates coordinatesW = new Coordinates(file, 8);
            if (!isSquareEmpty(coordinatesW) && getPiece(coordinatesW).color == Color.White){
                removePiece(coordinatesW);
                setPiece(coordinatesW, new Queen(Color.White, coordinatesW));
            }
            Coordinates coordinatesB = new Coordinates(file,1);
            if (!isSquareEmpty(coordinatesB) && getPiece(coordinatesB).color == Color.Black){
                removePiece(coordinatesB);
                setPiece(coordinatesB, new Queen(Color.Black, coordinatesB));
            }
        }
    }
    public void movePiece(Coordinates from, Coordinates to){
        Piece piece =  getPiece(from);
        removePiece(from);
        setPiece(to, piece);
    }

    public Set<Coordinates> getAllPiecesColor(Color color){
        Set<Coordinates> PiecesCoordinates = new HashSet<>();
        for (Map.Entry<Coordinates, Piece> pair : pieces.entrySet()){
            Coordinates coordinates1 = pair.getKey();
            if (!isSquareEmpty(coordinates1) && getPiece(coordinates1).color == color) PiecesCoordinates.add(coordinates1);
        }
        return PiecesCoordinates;
    }
}
