import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int knight = 2;
        int pawn = 8;

        king = king - scanner.nextInt();
        queen = queen - scanner.nextInt();
        rook = rook - scanner.nextInt();
        bishop = bishop - scanner.nextInt();
        knight = knight - scanner.nextInt();
        pawn = pawn - scanner.nextInt();

        System.out.print(king +" "+ queen +" " + rook+ " " + bishop + " " + knight + " " + pawn);
    }
}
