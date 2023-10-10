import Board.Board;
import Board.BoardConsoleRenderer;
import Pieces.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        Pawn pawn = new Pawn(Color.White, new Coordinates(File.G, 7));
        Pawn pawn2 = new Pawn(Color.White, new Coordinates(File.A, 3));
        Pawn pawnB = new Pawn(Color.Black, new Coordinates(File.F, 6));
        board.setPiece(new Coordinates(File.G, 7), pawn);
        board.setPiece(new Coordinates(File.F, 6), pawnB);
        board.setPiece(new Coordinates(File.A, 3), pawn2);

        pawn.getSquareAvaibleforMove(board).stream().forEach(s-> System.out.println(s.file.name() + " " + s.rank));
        renderer.render(board);






    }
}
