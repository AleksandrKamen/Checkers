import Board.*;
import Pieces.*;

import java.util.Set;

public class GameLoop {
    private final Board board;
    private  BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public GameLoop(Board board) {
        this.board = board;
    }


    public void loop(){
        boolean isWhitetoMove = true;

        while (true){
            if (isWhitetoMove) System.out.println("White to move");
            else System.out.println("Black to move");
            renderer.render(board);
            Coordinates sourseCoordinates =  InputCoordinates.inputPieceCoordinatesforColors(isWhitetoMove?Color.White:Color.Black, board);
            Piece piece =   board.getPiece(sourseCoordinates);
            Set<Coordinates> avaibleMoveSquare =  piece.getSquareAvaibleforMove(board);
            renderer.render(board);
            Coordinates targetCoordinates =  InputCoordinates.inputAvaibleSquare(avaibleMoveSquare);
            board.movePiece(sourseCoordinates, targetCoordinates);
            isWhitetoMove =! isWhitetoMove;
        }



    }

}
