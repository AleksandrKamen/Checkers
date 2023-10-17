package Pieces;

import Board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PieceTest {
    Board board;
    Pawn pawn;
    Pawn pawn2;
    Pawn pawn3;
    Pawn pawn4;
    Pawn pawn5;

    @BeforeEach
    void init(){
        board = new Board();
         pawn = new Pawn(Color.White, new Coordinates(File.A,1));
         pawn2 = new Pawn(Color.Black, new Coordinates(File.B,2));
         pawn3 = new Pawn(Color.White, new Coordinates(File.C,3));
         pawn4 = new Pawn(Color.Black, new Coordinates(File.D,4));
         pawn5 = new Pawn(Color.Black, new Coordinates(File.F,6));


        board.setPiece(new Coordinates(File.A,1),pawn);
        board.setPiece(new Coordinates(File.B,2),pawn2);
        board.setPiece(new Coordinates(File.C,3),pawn3);
        board.setPiece(new Coordinates(File.D,4),pawn4);
        board.setPiece(new Coordinates(File.F,6),pawn5);
    }
    @AfterEach
    void drop(){
        board = null;
        pawn=null;
        pawn2=null;
        pawn3=null;
        pawn4=null;
    }
    @Test
    void isWhitePieceOrNot(){

        assertAll(
                ()-> assertTrue(pawn.isWhitePiece()),
                ()-> assertFalse(pawn2.isWhitePiece())

        );

    }
    @Test
    void isAvaibleForMove(){
        assertAll(
                ()-> assertFalse(pawn.isSquareAvaibleforMove(new Coordinates(File.B,2),board)),
                ()-> assertTrue(pawn.isSquareAvaibleforMove(new Coordinates(File.H,8),board))
        );
    }
    @Test
    void haveAttackOrNot(){
          assertAll(
                  ()-> assertFalse(pawn.isHaveAttackSquare(board)),
                  ()-> assertFalse(pawn2.isHaveAttackSquare(board)),
                  ()-> assertTrue(pawn3.isHaveAttackSquare(board)),
                  ()-> assertFalse(pawn4.isHaveAttackSquare(board))
          );


    }
    @Nested
    class SquareAvaibleforMove{
        @Test
        void blockedPiece(){
            assertThat(pawn.getSquareAvaibleforMove(board)).isEmpty();
        }
        @Test
        void mustAttack(){
            assertAll(
                    ()-> assertThat(pawn3.getSquareAvaibleforMove(board)).hasSize(1),
                    ()-> assertThat(pawn3.getSquareAvaibleforMove(board)).contains(new Coordinates(File.E,5))

            );
        }
        @Test
        void pieceHaveOneMove(){
            assertAll(
                    ()-> assertThat(pawn2.getSquareAvaibleforMove(board)).hasSize(1),
                    ()-> assertThat(pawn2.getSquareAvaibleforMove(board)).contains(new Coordinates(File.C,1)),
                    ()-> assertThat(pawn4.getSquareAvaibleforMove(board)).hasSize(1),
                    ()-> assertThat(pawn4.getSquareAvaibleforMove(board)).contains(new Coordinates(File.E,3))


            );
        }
        @Test
        void pieceHaveTwoMove(){
            assertAll(
                    ()-> assertThat(pawn5.getSquareAvaibleforMove(board)).hasSize(2),
                    ()-> assertThat(pawn5.getSquareAvaibleforMove(board)).contains(new Coordinates(File.G,5), new Coordinates(File.E,5))

            );
        }

    }



}