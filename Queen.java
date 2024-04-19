public class Queen extends Piece {

    public Queen(int c){
        super.color = c;
    }

    public boolean move(Square o){
        if((super.occupies.getRank() - o.getRank() == 0 || super.occupies.getFile()- o.getFile() == 0 || 
        Math.abs(super.occupies.getRank() - o.getRank()) == Math.abs(super.occupies.getFile()- o.getFile())) && 
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
        return String.format("%s Queen at %s,%s",c,super.convertFile(super.occupies.getFile()),super.occupies.getRank() + 1 );
    }
    
}
