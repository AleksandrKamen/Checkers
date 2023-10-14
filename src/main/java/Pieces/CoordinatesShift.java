package Pieces;

import lombok.Getter;

public class CoordinatesShift {
    @Getter private final int fileShift;
    @Getter private final int rankShift;

    public CoordinatesShift(int fileShift, int rankShift) {
        this.fileShift = fileShift;
        this.rankShift = rankShift;
    }
}
