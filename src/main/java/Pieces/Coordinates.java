package Pieces;

import lombok.EqualsAndHashCode;

import java.util.Objects;
@EqualsAndHashCode
public class Coordinates {

  public final File file;
  public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates shift(CoordinatesShift coordinatesShift){
        return new Coordinates(File.values()[this.file.ordinal() + coordinatesShift.getFileShift()], this.rank + coordinatesShift.getRankShift());
    }
    public boolean canShift(CoordinatesShift coordinatesShift){
        int f = file.ordinal() + coordinatesShift.getFileShift();
        int r = this.rank + coordinatesShift.getRankShift();
        if ((f < 0) || (f > 7)) return false;
        if ((r < 1) || (r > 8)) return false;
        return true;
    }

}
