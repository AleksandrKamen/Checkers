package Pieces;

public enum Color {
    White, Black;

    public Color getOtherColor(){
        if (this == null) throw new NullPointerException("is null");
         return this==White?Black:White;
    }
}


