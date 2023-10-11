import Board.Board;
import Board.BoardConsoleRenderer;
import Pieces.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        Queen pawn = new Queen(Color.White, new Coordinates(File.A, 1));
        board.setPiece(new Coordinates(File.A, 1), pawn);
//        board.setPiece(new Coordinates(File.F, 6), new Pawn(Color.Black, new Coordinates(File.F, 6)));
        board.setPiece(new Coordinates(File.E, 5), new Pawn(Color.Black, new Coordinates(File.E, 5)));
        board.setPiece(new Coordinates(File.F, 6), new Pawn(Color.Black, new Coordinates(File.F, 6)));
        board.setPiece(new Coordinates(File.B, 2), new Pawn(Color.White, new Coordinates(File.B, 2)));
        board.setQueen();
        Queen queen = (Queen) board.getPiece(new Coordinates(File.A ,1));
        queen.getSquareAvaibleforMove(board);
        queen.getSquareAvaibleforMove(board).stream().forEach(i-> System.out.println(i.file + " " + i.rank));
        renderer.render(board);







    }
}
