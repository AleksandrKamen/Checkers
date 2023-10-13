import Board.*;
import Pieces.*;

public class GameLoop {
    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public GameLoop(Board board) {
        this.board = board;
    }

    public void loop() {
        while (true) {
            if (InputCoordinates.startOrNot().equals("not"))
                break;
            board.setBlackRemoveCount(0);
            board.setWhiteRemoveCount(0);
            boolean isWhitetoMove = true;
            board.setDefaultPiecesPosition();

            while (true) {
                if (isWhitetoMove) System.out.println("White to move");
                else System.out.println("Black to move");
                renderer.render(board);
                Coordinates sourseCoordinates = InputCoordinates.inputPieceCoordinatesforColors(isWhitetoMove ? Color.White : Color.Black, board);
                Piece piece = board.getPiece(sourseCoordinates);
                var avaibleMoveSquare = piece.getSquareAvaibleforMove(board);
                renderer.render(board, sourseCoordinates, avaibleMoveSquare);
                Coordinates targetCoordinates = InputCoordinates.inputAvaibleSquare(avaibleMoveSquare);
                board.movePiece(sourseCoordinates, targetCoordinates);
                board.setQueen();
                isWhitetoMove = !isWhitetoMove;
                if (isGameOver()) break;
            }
        }
    }

    private boolean isGameOver() {
        if (board.getBlackRemoveCount() == board.getCountALLPiecec() || board.getWhiteRemoveCount() == board.getCountALLPiecec()) {
            renderer.render(board);
            String s = board.getBlackRemoveCount() == board.getCountALLPiecec() ? "White" : "Black";
            renderer.GameoverRender();
            System.out.printf("%s won!\s", s);
            return true;
        }
        return false;
    }


}
