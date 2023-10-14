package Pieces;

public enum Color {
    White, Black;

    public Color getOtherColor(){
         return this==White?Black:White;
    }
}


