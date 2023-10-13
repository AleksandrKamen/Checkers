package Board;

import Pieces.*;

public class BoardConsoleRenderer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    private static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    private static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
//    private static final String ANSI_GREEN_PIECE_COLOR =  "\u001B[32m";
//    public static final String ANSI_HIGHTLIGHTED_SQUAR_BACKGROUND = "\u001B[45m";

    public void render(Board board) {
        // format = background color + font color + text + reset
        System.out.println("● ".repeat(board.BlackRemoveCount));
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareBlack(coordinates)) {
                    line += ANSI_BLACK_SQUARE_BACKGROUND + " ";
                } else line += ANSI_WHITE_SQUARE_BACKGROUND + " ";

                if (board.isSquareEmpty(coordinates)) {
                    line += "  ";
                } else {
                    Piece piece = board.getPiece(coordinates);
                    line += board.isWhitePiece(piece) ? ANSI_WHITE_PIECE_COLOR + piece.getUnicod() : ANSI_BLACK_PIECE_COLOR + piece.getUnicod();
                }
            }
            System.out.printf("%d %s %1$d\n", rank, line + ANSI_RESET);

        }
        System.out.println("   A  B  C  D  E  F  G  H");
        System.out.println(ANSI_WHITE_PIECE_COLOR + "● ".repeat(board.WhiteRemoveCount) + ANSI_RESET);
        System.out.println();
    }
}
