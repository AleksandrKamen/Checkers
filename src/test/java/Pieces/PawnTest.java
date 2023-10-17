package Pieces;

import Board.Board;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PawnTest {
    Board board;
    @BeforeEach
    void init(){
        board = new Board();
    }
    @AfterEach
    void drop(){
        board = null;
    }
    @Test
    void getPieceMove(){
    board.setPiece(new Coordinates(File.D,4), new Pawn(Color.White, new Coordinates(File.D,4)));
    board.setPiece(new Coordinates(File.A,1), new Pawn(Color.White, new Coordinates(File.A,1)));
    board.setPiece(new Coordinates(File.B,2), new Pawn(Color.Black, new Coordinates(File.B,2)));


    Pawn white1 = (Pawn) board.getPiece(new Coordinates(File.D,4));
    Pawn white2 = (Pawn) board.getPiece(new Coordinates(File.A,1));
    Pawn black1 = (Pawn) board.getPiece(new Coordinates(File.B,2));

        Set<String> set1 = white1.getPieceMove(board).stream().map(c -> c.toString()).collect(Collectors.toSet());
        Set<String> set2 = white2.getPieceMove(board).stream().map(c -> c.toString()).collect(Collectors.toSet());
        Set<String> set3 = black1.getPieceMove(board).stream().map(c -> c.toString()).collect(Collectors.toSet());



        assertAll(
            ()-> assertThat(set1).hasSize(2),
            ()-> assertThat(set1).contains("11","-11"),
            ()-> assertThat(set2).hasSize(3),
            ()-> assertThat(set2).contains("22","-11","11"),
            ()-> assertThat(set3).hasSize(3),
            ()-> assertThat(set3).contains("-2-2", "1-1","-1-1")

    );



}


}