package Pieces;
import Board.*;

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

    protected abstract Set<CoordinatesShift> getPieceMove();





}
