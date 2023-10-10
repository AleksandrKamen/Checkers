import Pieces.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        board.setPiece(new Coordinates(File.A, 8), new Pawn(Color.White,new Coordinates(File.A, 8)));
        board.setPiece(new Coordinates(File.B, 8), new Pawn(Color.Black,new Coordinates(File.B, 8)));
        board.setPiece(new Coordinates(File.A, 7), new Queen(Color.White,new Coordinates(File.A, 7)));
        board.setPiece(new Coordinates(File.A, 1), new Queen(Color.Black,new Coordinates(File.A, 1)));

        board.setQueen();
        renderer.render(board);






    }
}
