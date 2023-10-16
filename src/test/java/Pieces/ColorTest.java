package Pieces;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ColorTest {

    @ParameterizedTest
    @EnumSource(value = Color.class,names = "White")
    void getOtherColorForWhite(Color white){
        assertTrue(white.getOtherColor() == Color.Black);
    }
    @ParameterizedTest
    @EnumSource(value = Color.class,names = "Black")
    void getOtherColorForBlack(Color black){
        assertTrue(black.getOtherColor() == Color.White);
    }
}