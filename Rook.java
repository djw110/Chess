public class Rook extends Piece {

    public Rook(int c){
        super.color = c;
    }

    public boolean move(Square o){
        if((super.occupies.getRank() - o.getRank() == 0 || super.occupies.getFile()- o.getFile() == 0) && 
        (o.getPiece() == null || o.getPiece().getColor() != super.color) && !(o.equals(super.getSquare()))){
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
        return String.format("%s Rook at %s,%s",c,super.convertFile(super.occupies.getFile()),super.occupies.getRank() + 1 );
    }
    
}
