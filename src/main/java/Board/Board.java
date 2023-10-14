package Board;

import Pieces.*;
import java.util.*;
public class Board {

    private final int countALLPiecec = 12;
    HashMap<Coordinates, Piece> pieces = new HashMap<>();
    public Set<Coordinates> mustAttack = new HashSet<>();

    int WhiteRemoveCount = 0, BlackRemoveCount = 0;
    public int getCountALLPiecec() {
        return countALLPiecec;
    }
    public int getWhiteRemoveCount() {
        return WhiteRemoveCount;
    }
    public int getBlackRemoveCount() {
        return BlackRemoveCount;
    }

    public void setPiece(Coordinates coordinates, Piece piece) {
        piece.coordinates = coordinates;
        pieces.put(coordinates, piece);
    }
    public void removePiece(Coordinates coordinates) {
        pieces.remove(coordinates);
    }
    public void setWhiteRemoveCount(int whiteRemoveCount) {
        WhiteRemoveCount = whiteRemoveCount;
    }
    public void setBlackRemoveCount(int blackRemoveCount) {
        BlackRemoveCount = blackRemoveCount;
    }
    public void setDefaultPiecesPosition() {
        for (File file : File.values()) {
            if (file.ordinal() % 2 == 0) {
                setPiece(new Coordinates(file, 1), new Pawn(Color.White, new Coordinates(file, 1)));
                setPiece(new Coordinates(file, 3), new Pawn(Color.White, new Coordinates(file, 3)));
                setPiece(new Coordinates(file, 7), new Pawn(Color.Black, new Coordinates(file, 7)));
            } else {
                setPiece(new Coordinates(file, 2), new Pawn(Color.White, new Coordinates(file, 2)));
                setPiece(new Coordinates(file, 6), new Pawn(Color.Black, new Coordinates(file, 6)));
                setPiece(new Coordinates(file, 8), new Pawn(Color.Black, new Coordinates(file, 8)));
            }
        }
    }

    public Piece getPiece(Coordinates coordinates) {
        return pieces.get(coordinates);
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !pieces.containsKey(coordinates);
    }

    public boolean isSquareBlack(Coordinates coordinates) {
        return (((coordinates.file.ordinal() + 1) + coordinates.rank) % 2) == 0;
    }

    public boolean isWhitePiece(Piece piece) {
        return piece.color == Color.White;
    }

    public void setQueen() {
        for (File file : File.values()) {
            Coordinates coordinatesW = new Coordinates(file, 8);
            if (!isSquareEmpty(coordinatesW) && getPiece(coordinatesW).color == Color.White) {
                removePiece(coordinatesW);
                setPiece(coordinatesW, new Queen(Color.White, coordinatesW));
            }
            Coordinates coordinatesB = new Coordinates(file, 1);
            if (!isSquareEmpty(coordinatesB) && getPiece(coordinatesB).color == Color.Black) {
                removePiece(coordinatesB);
                setPiece(coordinatesB, new Queen(Color.Black, coordinatesB));
            }
        }
    }

    public void movePiece(Coordinates from, Coordinates to) {
        Piece piece = getPiece(from);
        removePiece(from);
        setPiece(to, piece);
        getCoordinatesBetweenSquare(from, to).stream().forEach(c -> removePiece(c));
        WhiteRemoveCount = countALLPiecec - getAllPiecesColor(Color.White).size();
        BlackRemoveCount = countALLPiecec - getAllPiecesColor(Color.Black).size();
    }

    public Set<Coordinates> getAllPiecesColor(Color color) {
        var PiecesCoordinates = new HashSet<Coordinates>();
        for (Map.Entry<Coordinates, Piece> pair : pieces.entrySet()) {
            Coordinates coordinates1 = pair.getKey();
            if (!isSquareEmpty(coordinates1) && getPiece(coordinates1).color == color)
                PiecesCoordinates.add(coordinates1);
        }
        return PiecesCoordinates;
    }

    public Set<Coordinates> getCoordinatesBetweenSquare(Coordinates from, Coordinates to) {

        Set<Coordinates> between = new HashSet<>();
        int firstSquareFile = from.file.ordinal();
        int firstSquareRank = from.rank;
        int diff = Math.abs(to.file.ordinal() - firstSquareFile);
        for (int b = 1; b < diff; b++) {
            firstSquareFile += to.file.ordinal() - firstSquareFile > 0 ? 1 : -1;
            firstSquareRank += to.rank - firstSquareRank > 0 ? 1 : -1;
            between.add(new Coordinates(File.values()[firstSquareFile], firstSquareRank));
        }
        return between;

    }
}
