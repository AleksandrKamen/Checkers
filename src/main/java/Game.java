import Board.Board;
import Board.BoardConsoleRenderer;
import Pieces.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        Pawn pawn = new Pawn(Color.White, new Coordinates(File.A, 1));
        board.setPiece(new Coordinates(File.B, 2), pawn);
        renderer.render(board);






    }
}
