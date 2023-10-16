package Board;

import Pieces.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({
        ParametrResolverBoard.class
})
class BoardTest {

   @ParameterizedTest
   @MethodSource("Board.BoardTest#getPiece")
   @DisplayName("Correct set Piece on Board")
   void setPiece(Piece piece, Coordinates coordinates){
     Board board = new Board();
     board.setPiece(coordinates, piece);
     assertThat(board.getPieces()).containsKey(coordinates);


   }

   static Stream<Arguments> getPiece(){
       return Stream.of(
               Arguments.of(new Pawn(Color.White, new Coordinates(File.A,3)),new Coordinates(File.A, 5)),
               Arguments.of(new Pawn(Color.Black, new Coordinates(File.A,3)),new Coordinates(File.B, 1)),
               Arguments.of(new Pawn(Color.White, new Coordinates(File.D,4)),new Coordinates(File.E, 5)),
               Arguments.of(new Queen(Color.White, new Coordinates(File.C,5)),new Coordinates(File.H, 8)),
               Arguments.of( new Queen(Color.Black, new Coordinates(File.A,3)),new Coordinates(File.A, 7))

       );
   }

    @ParameterizedTest
    @MethodSource("Board.BoardTest#get")
    @DisplayName("Correct remove Piece from Board")
    void removePiece(Coordinates coordinates){
       Board board = new Board();
       board.setDefaultPiecesPosition();
        board.removePiece(coordinates);
       assertAll(
               ()-> assertNull(board.getPieces().get(coordinates)),
               ()-> assertEquals(board.getPieces().size(), 23)
       );


    }

    @ParameterizedTest
    @MethodSource("Board.BoardTest#get")
    @DisplayName("Correct set default Position on board")
    void correctSetDefaultPosition(Coordinates coordinates, Color color){
       Board board = new Board();
       board.setDefaultPiecesPosition();
       assertAll(
               ()-> assertEquals(board.getPieces().size(), 24),
               ()-> assertThat(board.getPieces()).containsKey(coordinates),
               ()-> assertEquals(board.getPiece(coordinates).getColor(),color)
       );
    }

    static Stream<Arguments> get(){
       return Stream.of(
               Arguments.of(new Coordinates(File.A,1), Color.White),
               Arguments.of(new Coordinates(File.A,3), Color.White),
               Arguments.of(new Coordinates(File.B,2), Color.White),
               Arguments.of(new Coordinates(File.C,1), Color.White),
               Arguments.of(new Coordinates(File.C,3), Color.White),
               Arguments.of(new Coordinates(File.D,2), Color.White),
               Arguments.of(new Coordinates(File.E,1), Color.White),
               Arguments.of(new Coordinates(File.E,3), Color.White),
               Arguments.of(new Coordinates(File.F,2), Color.White),
               Arguments.of(new Coordinates(File.G,1), Color.White),
               Arguments.of(new Coordinates(File.G,3), Color.White),
               Arguments.of(new Coordinates(File.H,2), Color.White),

               Arguments.of(new Coordinates(File.A,7), Color.Black),
               Arguments.of(new Coordinates(File.B,8), Color.Black),
               Arguments.of(new Coordinates(File.B,6), Color.Black),
               Arguments.of(new Coordinates(File.C,7), Color.Black),
               Arguments.of(new Coordinates(File.D,8), Color.Black),
               Arguments.of(new Coordinates(File.D,6), Color.Black),
               Arguments.of(new Coordinates(File.E,7), Color.Black),
               Arguments.of(new Coordinates(File.F,8), Color.Black),
               Arguments.of(new Coordinates(File.F,6), Color.Black),
               Arguments.of(new Coordinates(File.G,7), Color.Black),
               Arguments.of(new Coordinates(File.H,8), Color.Black),
               Arguments.of(new Coordinates(File.H,6), Color.Black)
       );

    }

    @Test
    @DisplayName("Test is Empty Square")
    void isEmptySquare(Board board){
       assertTrue(board.isSquareEmpty(new Coordinates(File.B,4)));
       assertTrue(board.isSquareEmpty(new Coordinates(File.E,5)));
       assertTrue(board.isSquareEmpty(new Coordinates(File.H,4)));
    }
    @Test
    @DisplayName("Test is not Empty Square")
    void isNotEmptySquare(Board board){
        assertFalse(board.isSquareEmpty(new Coordinates(File.A,1)));
        assertFalse(board.isSquareEmpty(new Coordinates(File.B,6)));
        assertFalse(board.isSquareEmpty(new Coordinates(File.E,3)));

    }

    @ParameterizedTest
    @ValueSource(chars = {'B','D','F','H'})
    void isSquareBlackBDFH(char ch){
           Board board = new Board();
           for (int i = 1; i <= 8; i++) {
               if (i%2 == 0){
                   assertTrue(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));
               } else assertFalse(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));

           }
    }
    @ParameterizedTest
    @ValueSource(chars = {'A','C','E','G'})
    void isSquareBlackACEG(char ch){
           Board board = new Board();
           for (int i = 1; i <= 8; i++) {
               if (i%2 == 0){
                   assertFalse(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));
               } else assertTrue(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));

           }

    }






}