package Board;

import Pieces.*;
import org.junit.jupiter.api.*;
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

    private Board board;
    @BeforeEach
    void init(){
        board = new Board();
    }
    @AfterEach
    void drop(){
        board = null;
    }
    @Nested
    class setAndRemovePiece {
        @ParameterizedTest
        @MethodSource("Board.BoardTest#getPiece")
        @DisplayName("Correct set Piece on Board")
        void setPiece(Piece piece, Coordinates coordinates) {
            Board board = new Board();
            board.setPiece(coordinates, piece);
            assertThat(board.getPieces()).containsKey(coordinates);


        }

        @ParameterizedTest
        @MethodSource("Board.BoardTest#getCoordinates")
        @DisplayName("Correct remove Piece from Board")
        void removePiece(Coordinates coordinates) {
//            Board board = new Board();
            board.setDefaultPiecesPosition();
            board.removePiece(coordinates);
            assertAll(
                    () -> assertNull(board.getPieces().get(coordinates)),
                    () -> assertEquals(board.getPieces().size(), 23)
            );


        }

        @ParameterizedTest
        @MethodSource("Board.BoardTest#getCoordinates")
        @DisplayName("Correct set default Position on board")
        void correctSetDefaultPosition(Coordinates coordinates, Color color) {
//            Board board = new Board();
            board.setDefaultPiecesPosition();
            assertAll(
                    () -> assertEquals(board.getPieces().size(), 24),
                    () -> assertThat(board.getPieces()).containsKey(coordinates),
                    () -> assertEquals(board.getPiece(coordinates).getColor(), color)
            );
        }


    }

    @Nested
    class CheckSquare{
    @Test
    @DisplayName("Test is Empty Square")
    void isEmptySquare(){
       board.setDefaultPiecesPosition();
       assertTrue(board.isSquareEmpty(new Coordinates(File.B,4)));
       assertTrue(board.isSquareEmpty(new Coordinates(File.E,5)));
       assertTrue(board.isSquareEmpty(new Coordinates(File.H,4)));
    }
    @Test
    @DisplayName("Test is not Empty Square")
    void isNotEmptySquare(){
        board.setDefaultPiecesPosition();
        assertFalse(board.isSquareEmpty(new Coordinates(File.A,1)));
        assertFalse(board.isSquareEmpty(new Coordinates(File.B,6)));
        assertFalse(board.isSquareEmpty(new Coordinates(File.E,3)));

    }

    @ParameterizedTest
    @ValueSource(chars = {'B','D','F','H'})
    @DisplayName("check is square Black or not for B,D,F,H file ")
    void isSquareBlackBDFH(char ch){
           for (int i = 1; i <= 8; i++) {
               if (i%2 == 0){
                   assertTrue(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));
               } else assertFalse(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));

           }
    }
    @ParameterizedTest
    @ValueSource(chars = {'A','C','E','G'})
    @DisplayName("check is square Black or not for A,C,E,G file ")
    void isSquareBlackACEG(char ch){
           for (int i = 1; i <= 8; i++) {
               if (i%2 == 0){
                   assertFalse(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));
               } else assertTrue(board.isSquareBlack(new Coordinates(File.fromChar(ch), i)));

           }

    }
    }
    @Nested
    class setQueen {
        @ParameterizedTest
        @ValueSource(chars = {'B', 'D', 'F', 'H'})
        void setQueenForWhite(char ch) {
            Coordinates coordinates = new Coordinates(File.fromChar(ch), 8);
            board.setPiece(coordinates, new Pawn(Color.White, coordinates));
            board.setQueen();
            assertTrue(board.getPiece(coordinates) instanceof Queen);
        }

        @ParameterizedTest
        @ValueSource(chars = {'A', 'C', 'E', 'G'})
        void setQueenForBlack(char ch) {
            Coordinates coordinates = new Coordinates(File.fromChar(ch), 1);
            board.setPiece(coordinates, new Pawn(Color.Black, coordinates));
            board.setQueen();
            assertTrue(board.getPiece(coordinates) instanceof Queen);
        }

        @ParameterizedTest
        @ValueSource(chars = {'B', 'D', 'F', 'H'})
        void setQueenForWhiteNegative(char ch) {
            Coordinates coordinates = new Coordinates(File.fromChar(ch), 8);
            board.setPiece(coordinates, new Pawn(Color.Black, coordinates));
            board.setQueen();
            assertFalse(board.getPiece(coordinates) instanceof Queen);
        }

        @ParameterizedTest
        @ValueSource(chars = {'A', 'C', 'E', 'G'})
        void setQueenForBlackNegative(char ch) {
            Coordinates coordinates = new Coordinates(File.fromChar(ch), 1);
            board.setPiece(coordinates, new Pawn(Color.White, coordinates));
            board.setQueen();
            assertFalse(board.getPiece(coordinates) instanceof Queen);
        }
    }

    @Test
    @DisplayName("Check count white pieces")
    void getAllWhiteColorPiece(){
      assertThat(board.getAllPiecesByColor(Color.White)).hasSize(0);
      board.setDefaultPiecesPosition();
      assertThat(board.getAllPiecesByColor(Color.White)).hasSize(12);
      board.setPiece(new Coordinates(File.B, 4), new Queen(Color.White, new Coordinates(File.B,4)));
      board.setPiece(new Coordinates(File.D, 4), new Pawn(Color.Black, new Coordinates(File.D,4)));
      assertThat(board.getAllPiecesByColor(Color.White)).hasSize(13);
      board.removePiece(new Coordinates(File.A,1));
      assertThat(board.getAllPiecesByColor(Color.White)).hasSize(12);
    }
    @Test
    @DisplayName("Check count black pieces")
    void getAllBlackColorPiece(){
      assertThat(board.getAllPiecesByColor(Color.Black)).hasSize(0);
      board.setDefaultPiecesPosition();
      assertThat(board.getAllPiecesByColor(Color.Black)).hasSize(12);
      board.setPiece(new Coordinates(File.B, 4), new Queen(Color.Black, new Coordinates(File.B,4)));
      board.setPiece(new Coordinates(File.D, 4), new Queen(Color.White, new Coordinates(File.D,4)));
      assertThat(board.getAllPiecesByColor(Color.Black)).hasSize(13);
      board.removePiece(new Coordinates(File.A,7));
      assertThat(board.getAllPiecesByColor(Color.Black)).hasSize(12);
    }
     @Nested
     class coordinatesBetween {
       @Test
         void leftButtomToRight(){
           Coordinates from = new Coordinates(File.C,3);
           Coordinates to = new Coordinates(File.G,7);
           assertAll(
                   ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).hasSize(3),
                   ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).contains(new Coordinates(File.D,4), new Coordinates(File.E,5), new Coordinates(File.F,6))
           );
       }

         @Test
         void rightTopToLeft(){
           Coordinates from = new Coordinates(File.F,8);
           Coordinates to = new Coordinates(File.A,3);
           assertAll(
                   ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).hasSize(4),
                   ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).contains(new Coordinates(File.B,4), new Coordinates(File.C,5), new Coordinates(File.D,6),new Coordinates(File.E,7))
           );
       }
       @Test
       void rightButtomToLeft(){
           Coordinates from = new Coordinates(File.G,1);
           Coordinates to = new Coordinates(File.C,5);
           assertAll(
                   ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).hasSize(3),
                   ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).contains(new Coordinates(File.F,2), new Coordinates(File.E,3), new Coordinates(File.D,4))
           );
       }
         @Test
         void leftTopToRight(){
             Coordinates from = new Coordinates(File.A,5);
             Coordinates to = new Coordinates(File.C,3);
             assertAll(
                     ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).hasSize(1),
                     ()-> assertThat(board.getCoordinatesBetweenSquare(from,to)).contains(new Coordinates(File.B,4))
             );
         }
         @Test
         void nullSquareBetween(){
             Coordinates from = new Coordinates(File.A,5);
             Coordinates to = new Coordinates(File.B,6);
             assertThat(board.getCoordinatesBetweenSquare(from,to)).hasSize(0);
         }




     }

    @Nested
    class movePiece {
        @ParameterizedTest
        @MethodSource("Board.BoardTest#getCoordinatesFromAndTo")
        @DisplayName("Only move, not drop")
        void onlyMove(Coordinates from, Coordinates to){
            board.setDefaultPiecesPosition();
            board.movePiece(from,to);
            assertAll(
                    ()-> assertNull(board.getPiece(from)),
                    ()-> assertNotNull(board.getPiece(to)),
                    ()->assertEquals(0,board.getWhiteRemoveCount()),
                    ()->assertEquals(0,board.getBlackRemoveCount())
            );
        }
        @Test
        @DisplayName("Pawn move and drop 1 pawn")
        void MoveAndDropPawn(){
            Coordinates from = new Coordinates(File.C,3);
            Coordinates to = new Coordinates(File.E,5);
            Coordinates between = new Coordinates(File.D,4);
            board.setPiece(from, new Pawn(Color.White, from));
            board.setPiece(between, new Pawn(Color.Black, between));
            board.movePiece(from,to);
            assertAll(
                    ()-> assertNull(board.getPiece(from)),
                    ()-> assertNull(board.getPiece(between)),
                    ()-> assertNotNull(board.getPiece(to)),
                    ()->assertEquals(11,board.getWhiteRemoveCount()),
                    ()->assertEquals(12,board.getBlackRemoveCount())
            );
        }
        @Test
        @DisplayName("Queen move and drop 2 pawn")
        void MoveAndDropQueen(){
            Coordinates from = new Coordinates(File.A,1);
            Coordinates to = new Coordinates(File.E,5);
            Coordinates between1 = new Coordinates(File.D,4);
            Coordinates between2 = new Coordinates(File.B,2);

            board.setPiece(from, new Queen(Color.White, from));
            board.setPiece(between1, new Pawn(Color.Black, between1));
            board.setPiece(between2, new Pawn(Color.Black, between2));
            board.movePiece(from,to);
            assertAll(
                    ()-> assertNull(board.getPiece(from)),
                    ()-> assertNull(board.getPiece(between1)),
                    ()-> assertNull(board.getPiece(between2)),
                    ()-> assertNotNull(board.getPiece(to)),
                    ()->assertEquals(11,board.getWhiteRemoveCount()),
                    ()->assertEquals(12,board.getBlackRemoveCount())
            );
        }






    }


    static Stream<Arguments> getPiece() {
        return Stream.of(
                Arguments.of(new Pawn(Color.White, new Coordinates(File.A, 3)), new Coordinates(File.A, 5)),
                Arguments.of(new Pawn(Color.Black, new Coordinates(File.A, 3)), new Coordinates(File.B, 1)),
                Arguments.of(new Pawn(Color.White, new Coordinates(File.D, 4)), new Coordinates(File.E, 5)),
                Arguments.of(new Queen(Color.White, new Coordinates(File.C, 5)), new Coordinates(File.H, 8)),
                Arguments.of(new Queen(Color.Black, new Coordinates(File.A, 3)), new Coordinates(File.A, 7))

        );
    }
    static Stream<Arguments> getCoordinates() {
        return Stream.of(
                Arguments.of(new Coordinates(File.A, 1), Color.White),
                Arguments.of(new Coordinates(File.A, 3), Color.White),
                Arguments.of(new Coordinates(File.B, 2), Color.White),
                Arguments.of(new Coordinates(File.C, 1), Color.White),
                Arguments.of(new Coordinates(File.C, 3), Color.White),
                Arguments.of(new Coordinates(File.D, 2), Color.White),
                Arguments.of(new Coordinates(File.E, 1), Color.White),
                Arguments.of(new Coordinates(File.E, 3), Color.White),
                Arguments.of(new Coordinates(File.F, 2), Color.White),
                Arguments.of(new Coordinates(File.G, 1), Color.White),
                Arguments.of(new Coordinates(File.G, 3), Color.White),
                Arguments.of(new Coordinates(File.H, 2), Color.White),

                Arguments.of(new Coordinates(File.A, 7), Color.Black),
                Arguments.of(new Coordinates(File.B, 8), Color.Black),
                Arguments.of(new Coordinates(File.B, 6), Color.Black),
                Arguments.of(new Coordinates(File.C, 7), Color.Black),
                Arguments.of(new Coordinates(File.D, 8), Color.Black),
                Arguments.of(new Coordinates(File.D, 6), Color.Black),
                Arguments.of(new Coordinates(File.E, 7), Color.Black),
                Arguments.of(new Coordinates(File.F, 8), Color.Black),
                Arguments.of(new Coordinates(File.F, 6), Color.Black),
                Arguments.of(new Coordinates(File.G, 7), Color.Black),
                Arguments.of(new Coordinates(File.H, 8), Color.Black),
                Arguments.of(new Coordinates(File.H, 6), Color.Black)
        );

    }

    static Stream<Arguments> getCoordinatesFromAndTo() {
        return Stream.of(
                Arguments.of(new Coordinates(File.A, 3), new Coordinates(File.B,4)),
                Arguments.of(new Coordinates(File.C, 3), new Coordinates(File.D,4)),
                Arguments.of(new Coordinates(File.B, 6), new Coordinates(File.C,5)),
                Arguments.of(new Coordinates(File.F, 6), new Coordinates(File.G,5))


        );

    }



}