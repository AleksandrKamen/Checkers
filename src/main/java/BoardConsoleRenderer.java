import Pieces.*;

public class BoardConsoleRenderer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    private static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    private static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
    private static final String pawn = "● ";
    private static final String queen = "© ";

//    public static final String ANSI_HIGHTLIGHTED_SQUAR_BACKGROUND = "\u001B[45m";

    public void render(Board board){
        // format = background color + font color + text
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for(File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                if (board.isSquareBlack(coordinates)){
                    line += ANSI_BLACK_SQUARE_BACKGROUND +" ";
                } else  line += ANSI_WHITE_SQUARE_BACKGROUND + " ";

                if (board.isSquareEmpty(coordinates)){
                    line += "  ";
                } else{
                    line += board.isWhitePiece(board.getPiece(coordinates))? ANSI_WHITE_PIECE_COLOR + pawn: ANSI_BLACK_PIECE_COLOR + pawn;
                }
            }
            System.out.printf("%s\n", line  + ANSI_RESET);
        }

    }
}
