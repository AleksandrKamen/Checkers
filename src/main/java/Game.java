import Board.Board;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        GameLoop loop = new GameLoop(board);
        loop.loop();







    }
}
