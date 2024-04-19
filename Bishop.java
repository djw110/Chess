import java.lang.Math;

public class Bishop extends Piece {
    
    public Bishop(int c){
        super.color = c;
    }

    public boolean move(Square o){
        int currentRank = super.occupies.getRank();
        int currentFile = super.occupies.getFile();

        if(Math.abs(currentRank - o.getRank()) == Math.abs(currentFile- o.getFile()) && 
        (o.getPiece() == null || o.getPiece().getColor() != super.color) && !(o.equals(super.getSquare()))){

            for(int r = 1; r < Math.abs(currentRank - o.getRank()); r++){
                for(int f = 1; f < Math.abs(currentFile - o.getFile()); f++){
                    if(r == f){
                        if (currentRank < o.getRank()){
                            if(currentFile < o.getFile()){
                                if (o.getBoard().find(currentRank+r, currentFile+f).getPiece() != null){
                                    return false;
                                }
                            }
                            else {
                                if (o.getBoard().find(currentRank+r, currentFile-f).getPiece() != null){
                                    return false;
                                }
                            }
                        }
                        else {
                            if(currentFile < o.getFile()){
                                if (o.getBoard().find(currentRank-r, currentFile+f).getPiece() != null){
                                    return false;
                                }
                            }
                            else {
                                if (o.getBoard().find(currentRank-r, currentFile-f).getPiece() != null){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            
            super.occupies.setPiece(null);
            super.occupies = o;
            o.setPiece(this);
            return true;
        }
        return false;
    }

    public String toString(){
        String c = "White";
        if (super.color == 0){
            c = "Black";
        }
        return String.format("%s Bishop at %s,%s",c,super.convertFile(super.occupies.getFile()),super.occupies.getRank() + 1 );
    }
}
