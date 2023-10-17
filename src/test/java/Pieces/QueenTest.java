package Pieces;

import Board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    Board board;
    Queen queen;
    @BeforeEach
    void init(){
    board = new Board();
    }

    @AfterEach
    void drop(){
        board = null;
    }


    @Nested
    class QueenMove{
    @Test
    void queenMoveFree(){
     queen = new Queen(Color.White,new Coordinates(File.B,8));
     assertThat(queen.getSquareAvaibleforMove(board)).hasSize(7);

    }
    @Test
    void queenMustAttack(){
        queen = new Queen(Color.White,new Coordinates(File.B,8));
        board.setPiece(new Coordinates(File.B,8),queen);
        board.setPiece(new Coordinates(File.E,5),new Pawn(Color.Black,new Coordinates(File.E,5)));
        assertThat(queen.getSquareAvaibleforMove(board)).hasSize(3);
    }
    @Test
        void queenBlocked(){
            queen = new Queen(Color.White,new Coordinates(File.B,8));
            board.setPiece(new Coordinates(File.B,8),queen);
            board.setPiece(new Coordinates(File.A,7),new Pawn(Color.Black,new Coordinates(File.A,7)));
            board.setPiece(new Coordinates(File.C,7),new Pawn(Color.White,new Coordinates(File.C,7)));
            assertThat(queen.getSquareAvaibleforMove(board)).hasSize(0);
        }



    }

}