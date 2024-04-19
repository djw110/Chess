public class Pawn extends Piece {

    public Pawn(int c){
        super.color = c;
    }
    
    public boolean move(Square o){
        if((o.getPiece() == null && o.getRank() - super.getSquare().getRank() == 1) || 
        (o.getRank() - super.getSquare().getRank() == 1 && 
        o.getFile() - super.getSquare().getFile() == 1 && 
        o.getPiece().getColor() != super.color) && !(o.equals(super.getSquare()))){
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
        return String.format("%s Pawn at %s,%s",c,super.convertFile(super.occupies.getFile()),super.occupies.getRank() + 1 );
    }
}
