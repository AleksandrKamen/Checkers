package Pieces;

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



}
