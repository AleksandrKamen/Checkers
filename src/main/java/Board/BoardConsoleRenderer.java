package Board;

import Pieces.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BoardConsoleRenderer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    private static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    private static final String ANSI_GREEN_PIECE_COLOR = "\u001B[32m";
    private static final String ANSI_YELLOW_PIECE_COLOR = "\u001B[33m";

    private static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";
    public static final String ANSI_HIGHTLIGHTED_SQUAR_BACKGROUND = "\u001B[45m";

    public void render(Board board) {
        // format = background color + font color + text + reset
        Set<Coordinates> availableForPick = new HashSet<>();
        renderBorder(board, Color.White);
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
        renderBorder(board, Color.Black);
    }

    public void render(Board board, boolean color) {
        // format = background color + font color + text + reset
        Set<Coordinates> availableForPick = new HashSet<>();
        availableForPick =  color == true?board.getAllPiecesColor(Color.White).stream().filter(c-> !board.getPiece(c).getSquareAvaibleforMove(board).isEmpty()).collect(Collectors.toSet()):
        board.getAllPiecesColor(Color.Black).stream().filter(c-> !board.getPiece(c).getSquareAvaibleforMove(board).isEmpty()).collect(Collectors.toSet());
        renderBorder(board, Color.White);
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
                    line += availableForPick.contains(coordinates)?ANSI_YELLOW_PIECE_COLOR+piece.getUnicod(): board.isWhitePiece(piece) ? ANSI_WHITE_PIECE_COLOR + piece.getUnicod() : ANSI_BLACK_PIECE_COLOR + piece.getUnicod();
                }
            }
            System.out.printf("%d %s %1$d\n", rank, line + ANSI_RESET);

        }
        renderBorder(board, Color.Black);
    }

    public void render(Board board, Coordinates selectedCoordinates, Set<Coordinates> avaibleSquare) {
        // format = background color + font color + text + reset
        renderBorder(board, Color.White);
        for (int rank = 8; rank >= 1; rank--) {
            String line = "";
            for (File file : File.values()) {
                Coordinates coordinates = new Coordinates(file, rank);
                if (avaibleSquare.contains(coordinates)){
                    line += ANSI_HIGHTLIGHTED_SQUAR_BACKGROUND + " ";
                }
                else if (board.isSquareBlack(coordinates)) {
                    line += ANSI_BLACK_SQUARE_BACKGROUND + " ";
                } else line += ANSI_WHITE_SQUARE_BACKGROUND + " ";

                if (board.isSquareEmpty(coordinates)) {
                    line += "  ";
                } else {
                    Piece piece = board.getPiece(coordinates);
                    line += coordinates.equals(selectedCoordinates) ? ANSI_GREEN_PIECE_COLOR + piece.getUnicod() : board.isWhitePiece(piece) ? ANSI_WHITE_PIECE_COLOR + piece.getUnicod() : ANSI_BLACK_PIECE_COLOR + piece.getUnicod();
                }
            }
            System.out.printf("%d %s %1$d\n", rank, line + ANSI_RESET);

        }
        renderBorder(board, Color.Black);
    }

    public void GameoverRender() {
        System.out.println("\033[0;31m" + "GAME OVER" + "\u001B[0m");
    }

    public void renderBorder(Board board, Color color) {
        String borderBoard = "   A  B  C  D  E  F  G  H";
        if (color == Color.White) {
            System.out.println("● ".repeat(board.BlackRemoveCount));
            System.out.println(borderBoard);
        } else {
            System.out.println(borderBoard);
            System.out.println(ANSI_WHITE_PIECE_COLOR + "● ".repeat(board.WhiteRemoveCount) + ANSI_RESET + "\s");
        }
    }
}
