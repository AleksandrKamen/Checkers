package Pieces;

import lombok.Getter;
import lombok.ToString;


public class CoordinatesShift {
    @Getter private final int fileShift;
    @Getter private final int rankShift;

    public CoordinatesShift(int fileShift, int rankShift) {
        this.fileShift = fileShift;
        this.rankShift = rankShift;
    }

    @Override
    public String toString() {
        return  fileShift +  "" + rankShift;
    }
}
