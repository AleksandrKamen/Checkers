package Pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void getOtherColorForWhite() {
        Color color = null;
        Color white = Color.White;
        Color black = Color.Black;

       assertAll(
            ()-> assertThrows(NullPointerException.class, ()-> color.getOtherColor()),
            ()-> assertTrue(white.getOtherColor() == Color.Black),
            ()-> assertTrue(black.getOtherColor() == Color.White)
       );


    }
}