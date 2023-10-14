import Pieces.Coordinates;

import Pieces.*;
import java.util.Scanner;
import java.util.Set;

import Board.Board;

public class Inputs {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {

        while (true) {
            System.out.println("Please enter coordinates (ex.A1)");
            String line = scanner.nextLine().toUpperCase();
            if (line.length() != 2) {
                System.out.println("Invalid format");
                continue;
            }
            if (!line.matches("[A-H][1-8]")) {
                System.out.println("Invalid format");
                continue;
            }
            File file = File.fromChar(line.charAt(0));
            int rank = Character.getNumericValue(line.charAt(1));

            return new Coordinates(file, rank);
        }
    }

    public static Coordinates inputPieceCoordinatesforColors(Color color, Board board) {

        while (true) {
            System.out.println("Enter coordinates for a piece to move");
            Coordinates coordinates = input();
            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Empty Square");
                continue;
            }
            Piece piece = board.getPiece(coordinates);
            if (piece.color != color) {
                System.out.println("Wrong color");
                continue;
            }
            if (piece.getSquareAvaibleforMove(board).isEmpty()) {
                System.out.println("Blocked piece");
                continue;
            }
            if (!board.getMustAttack().isEmpty() && !board.getMustAttack().contains(coordinates)){
                System.out.println("You must attack");
                continue;
            }
            return coordinates;
        }
    }
    public static String startOrNot(){
        System.out.println("Do you want to start? Please enter: yeas or not");
        while (true){
            String line = scanner.nextLine();
             if (!line.equalsIgnoreCase("yeas") && !line.equalsIgnoreCase("not")){
                 System.out.println("Invalid format, please enter: yeas or not");
                 continue;
             }
           return line;
        }
    }

    public static Coordinates inputAvaibleSquare(Set<Coordinates> coordinates){
        while (true){
            System.out.println("Enter your move for selected piece");
            Coordinates input = input();
            if (!coordinates.contains(input)) {
                System.out.println("Non available square");
                continue;
            }
            return input;
        }
    }

}
