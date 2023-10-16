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
            if (Inputs.startOrNot().equals("not"))
                break;
            board.setBlackRemoveCount(0);
            board.setWhiteRemoveCount(0);
            board.setDefaultPiecesPosition();
            boolean isWhitetoMove = true;


            while (true) {
                board.getMustAttack().clear();
                if (isWhitetoMove) System.out.println("White to move");
                else System.out.println("Black to move");
                renderer.render(board,isWhitetoMove);
                Coordinates sourseCoordinates = Inputs.inputPieceCoordinatesforColors(isWhitetoMove ? Color.White : Color.Black, board);
                Piece piece = board.getPiece(sourseCoordinates);
                var avaibleMoveSquare = piece.getSquareAvaibleforMove(board);
                renderer.render(board, sourseCoordinates, avaibleMoveSquare);
                Coordinates targetCoordinates = Inputs.inputAvaibleSquare(avaibleMoveSquare);

                int countBefore =  board.getAllPiecesByColor(piece.getColor().getOtherColor()).size();
                board.movePiece(sourseCoordinates, targetCoordinates);

                if (countBefore != board.getAllPiecesByColor(piece.getColor().getOtherColor()).size()){
                    while (board.getPiece(targetCoordinates).isHaveAttackSquare(board)){
                        piece = board.getPiece(targetCoordinates);
                        avaibleMoveSquare = piece.getSquareAvaibleforMove(board);
                        renderer.render(board, targetCoordinates, avaibleMoveSquare);
                        Coordinates newTargetCoordinates = Inputs.inputAvaibleSquare(avaibleMoveSquare);
                        board.movePiece(targetCoordinates, newTargetCoordinates);
                        targetCoordinates = newTargetCoordinates;
                    }
                }

                board.setQueen();
                isWhitetoMove = !isWhitetoMove;
                if (isGameOver()) break;
            }
        }
    }

    private boolean isGameOver() {
        if (board.getBlackRemoveCount() == board.getCountALLPiecec() || board.getWhiteRemoveCount() == board.getCountALLPiecec()) {
            renderer.render(board );
            String s = board.getBlackRemoveCount() == board.getCountALLPiecec() ? "White" : "Black";
            renderer.GameoverRender();
            System.out.printf("%s won!\s", s);
            return true;
        }
        return false;
    }


}
