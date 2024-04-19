import java.util.Scanner;


public class Game {
    public static Board board = new Board();
    
    public static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) {
        displayBoard();
        int turn = 1;
        for(int i = 0; i<100; i++){
            playerTurn(turn);
            displayBoard();
            if (turn == 1){
                turn --;
            }
            else{
                turn++;
            }
        }
        inp.close();
    }

    public static void displayBoard(){
        String output = "";
        for (int r = 7; r >= 0; r--){
            for(int f = 0; f < 8; f++){
                Square s = board.find(r, f);
                if (s.getPiece() == null){
                    output += "-";
                }
                else {
                    if (s.getPiece() instanceof King) {
                        output += "K";
                    }
                    else if (s.getPiece() instanceof Queen){
                        output += "Q";
                    }
                    else if (s.getPiece() instanceof Rook){
                        output += "R";
                    }
                    else if (s.getPiece() instanceof Knight){
                        output += "N";
                    }
                    else if (s.getPiece() instanceof Bishop){
                        output += "B";
                    }
                    else if (s.getPiece() instanceof Pawn){
                        output += "P";
                    }
                }
                output += " ";
            }
            output += System.lineSeparator();
        }
        System.out.println(output);
    }

    public static void playerTurn(int c){

        boolean turn = true;
        System.out.println("Your turn");

        while (turn){
            System.out.println("What piece do you wish to move?");
            int fRank = -1;
            int fFile = -1;

            while (fFile < 0 || fFile > 7){
                System.out.println("Enter file: ");
                fFile = inp.nextInt() - 1;
            }

            while (fRank < 0 || fRank > 7){
                System.out.println("Enter rank: ");
                fRank = inp.nextInt() - 1;
            }
            Square sFrom = board.find(fRank, fFile);

            System.out.println("What square do you wish to move to?");
            int tRank = -1;
            int tFile = -1;

            while (tFile < 0 || tFile > 7){
                System.out.println("Enter file: ");
                tFile = inp.nextInt() - 1;
            }
            while (tRank < 0 || tRank > 7){
                System.out.println("Enter rank: ");
                tRank = inp.nextInt() - 1;
            }
            Square sTo = board.find(tRank,tFile);

            if (sFrom.getPiece().getColor() == c && sFrom.getPiece().move(sTo) == true){
                System.out.println("Moved Successfully");
                turn = false;
            }

            else {
                System.out.println("Illegal Move, try again.");
            }
        }

    }
}
