package Pieces;

import lombok.EqualsAndHashCode;
@EqualsAndHashCode
public class Coordinates {

  public final File file;
  public final Integer rank;

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }
}
