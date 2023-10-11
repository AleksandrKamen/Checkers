package Pieces;

import java.util.Objects;

public class Coordinates {

  public final File file;
  public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    public Coordinates shift(CoordinatesShift coordinatesShift){
        return new Coordinates(File.values()[this.file.ordinal() + coordinatesShift.fileShift], this.rank + coordinatesShift.rankShift);
    }
    public boolean canShift(CoordinatesShift coordinatesShift){
        int f = file.ordinal() + coordinatesShift.fileShift;
        int r = this.rank + coordinatesShift.rankShift;
        if ((f < 0) || (f > 7)) return false;
        if ((r < 1) || (r > 8)) return false;
        return true;
    }

}
