package Pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinatesTest {


    @ParameterizedTest
    @MethodSource("Pieces.CoordinatesTest#getArgumentsNegative")
    @DisplayName("Invalid values for Coordinates after shift")
    void InvalidValuesForCoordinatesShift(CoordinatesShift coordinatesShift, Coordinates coordinates) {
        assertThat(coordinates.canShift(coordinatesShift)).isEqualTo(false);
    }
    static Stream<Arguments> getArgumentsNegative(){
        return Stream.of(
                //f<1
                Arguments.of(new CoordinatesShift(-1,1), new Coordinates(File.A, 1)),
                //f>7
                Arguments.of(new CoordinatesShift(8,1), new Coordinates(File.A, 1)),
                //r>8
                Arguments.of(new CoordinatesShift(1,8), new Coordinates(File.A, 1)),
                //r<1
                Arguments.of(new CoordinatesShift(1,-1), new Coordinates(File.A, 1)),
                //f<1 && rank >8
                Arguments.of(new CoordinatesShift(-1,7), new Coordinates(File.A, 1)),

                Arguments.of(new CoordinatesShift(-2,2), new Coordinates(File.B, 2)),
                Arguments.of(new CoordinatesShift(7,2), new Coordinates(File.B, 2)),
                Arguments.of(new CoordinatesShift(2,7), new Coordinates(File.B, 2)),
                Arguments.of(new CoordinatesShift(2,-4), new Coordinates(File.B, 2)),
                Arguments.of(new CoordinatesShift(-2,7), new Coordinates(File.B, 2)),


                Arguments.of(new CoordinatesShift(-3,1), new Coordinates(File.C, 1)),
                Arguments.of(new CoordinatesShift(6,1), new Coordinates(File.C, 1)),
                Arguments.of(new CoordinatesShift(3,10), new Coordinates(File.C, 1)),
                Arguments.of(new CoordinatesShift(3,-3), new Coordinates(File.C, 2)),
                Arguments.of(new CoordinatesShift(-3,10), new Coordinates(File.C, 1)),


                Arguments.of(new CoordinatesShift(-4,1), new Coordinates(File.D, 4)),
                Arguments.of(new CoordinatesShift(2,6), new Coordinates(File.D, 4)),
                Arguments.of(new CoordinatesShift(-4,6), new Coordinates(File.D, 4)),


                Arguments.of(new CoordinatesShift(-5,5), new Coordinates(File.E, 3)),
                Arguments.of(new CoordinatesShift(-2,7), new Coordinates(File.E, 3)),
                Arguments.of(new CoordinatesShift(-5,8), new Coordinates(File.E, 3)),

                Arguments.of(new CoordinatesShift(-6,3), new Coordinates(File.F, 4)),
                Arguments.of(new CoordinatesShift(-2,5), new Coordinates(File.F, 6)),
                Arguments.of(new CoordinatesShift(-6,5), new Coordinates(File.F, 4)),


                Arguments.of(new CoordinatesShift(-7,2), new Coordinates(File.G, 3)),
                Arguments.of(new CoordinatesShift(-3,2), new Coordinates(File.G, 7)),
                Arguments.of(new CoordinatesShift(-7,2), new Coordinates(File.G, 7)),

                Arguments.of(new CoordinatesShift(-8,1), new Coordinates(File.H, 4)),
                Arguments.of(new CoordinatesShift(-4,5), new Coordinates(File.H, 4)),
                Arguments.of(new CoordinatesShift(-8,5), new Coordinates(File.H, 4))

        );
    }
    @ParameterizedTest
    @MethodSource("Pieces.CoordinatesTest#getArgymentsPositive")
    @DisplayName("Valid values for Coordinates after shift")
    void ValidValuesForCoordinatesShift(CoordinatesShift coordinatesShift, Coordinates coordinates) {
        assertThat(coordinates.canShift(coordinatesShift)).isEqualTo(true);
    }
    static Stream<Arguments> getArgymentsPositive(){
     return Stream.of(
             Arguments.of(new CoordinatesShift(1,2), new Coordinates(File.A, 1)),
             Arguments.of(new CoordinatesShift(3,4), new Coordinates(File.A, 1)),
             Arguments.of(new CoordinatesShift(7,7), new Coordinates(File.A, 1)),
             Arguments.of(new CoordinatesShift(4,-1), new Coordinates(File.A, 3)),
             Arguments.of(new CoordinatesShift(3,5), new Coordinates(File.A, 1)),

             Arguments.of(new CoordinatesShift(6,1), new Coordinates(File.B, 6)),
             Arguments.of(new CoordinatesShift(5,-2), new Coordinates(File.B, 6)),
             Arguments.of(new CoordinatesShift(4,2), new Coordinates(File.B, 6)),
             Arguments.of(new CoordinatesShift(3,-3), new Coordinates(File.B, 6)),
             Arguments.of(new CoordinatesShift(-1,1), new Coordinates(File.B, 6)),


             Arguments.of(new CoordinatesShift(-2,-1), new Coordinates(File.C, 5)),
             Arguments.of(new CoordinatesShift(5,2), new Coordinates(File.C, 5)),
             Arguments.of(new CoordinatesShift(3,3), new Coordinates(File.C, 5)),
             Arguments.of(new CoordinatesShift(3,-3), new Coordinates(File.C, 4)),
             Arguments.of(new CoordinatesShift(-1,4), new Coordinates(File.C, 3)),


             Arguments.of(new CoordinatesShift(-2,4), new Coordinates(File.D, 4)),
             Arguments.of(new CoordinatesShift(-3,2), new Coordinates(File.D, 4)),
             Arguments.of(new CoordinatesShift(2,-2), new Coordinates(File.D, 4)),


             Arguments.of(new CoordinatesShift(-1,5), new Coordinates(File.E, 2)),
             Arguments.of(new CoordinatesShift(-3,6), new Coordinates(File.E, 2)),
             Arguments.of(new CoordinatesShift(2,-1), new Coordinates(File.E, 2)),

             Arguments.of(new CoordinatesShift(1,1), new Coordinates(File.F, 4)),
             Arguments.of(new CoordinatesShift(2,2), new Coordinates(File.F, 6)),
             Arguments.of(new CoordinatesShift(-5,4), new Coordinates(File.F, 4)),


             Arguments.of(new CoordinatesShift(-6,2), new Coordinates(File.G, 3)),
             Arguments.of(new CoordinatesShift(-6,1), new Coordinates(File.G, 7)),
             Arguments.of(new CoordinatesShift(1,-5), new Coordinates(File.G, 7)),

             Arguments.of(new CoordinatesShift(-7,-1), new Coordinates(File.H, 4)),
             Arguments.of(new CoordinatesShift(-4,2), new Coordinates(File.H, 4)),
             Arguments.of(new CoordinatesShift(-5,3), new Coordinates(File.H, 4))

     );
    }

    @ParameterizedTest
    @MethodSource("Pieces.CoordinatesTest#getCoordinates")
    @DisplayName("Correct Coordinates after shift")
    void CorrectCoordinates(Coordinates coordinates, CoordinatesShift shift, Coordinates newCoordinates){
        assertThat(coordinates.shift(shift)).isEqualTo(newCoordinates);
    }

    static Stream<Arguments> getCoordinates(){
        return Stream.of(
                Arguments.of(new Coordinates(File.A, 3), new CoordinatesShift(2,2), new Coordinates(File.C, 5)),
                Arguments.of(new Coordinates(File.B, 2), new CoordinatesShift(-1,1), new Coordinates(File.A, 3)),
                Arguments.of(new Coordinates(File.C, 3), new CoordinatesShift(3,3), new Coordinates(File.F, 6)),
                Arguments.of(new Coordinates(File.E, 5), new CoordinatesShift(2,2), new Coordinates(File.G, 7)),
                Arguments.of(new Coordinates(File.D, 4), new CoordinatesShift(-3,3), new Coordinates(File.A, 7)),
                Arguments.of(new Coordinates(File.F, 6), new CoordinatesShift(-1,-1), new Coordinates(File.E, 5)),
                Arguments.of(new Coordinates(File.H, 2), new CoordinatesShift(-6,6), new Coordinates(File.B, 8))
        );
    }
}