public class Knight extends Piece {

    public Knight(int c){
        super.color = c;
    }

    public boolean move(Square o){
        if(((Math.abs(super.occupies.getRank() - o.getRank()) == 2 && Math.abs(super.occupies.getFile()- o.getFile()) == 1) || 
        (Math.abs(super.occupies.getRank() - o.getRank()) == 1 && Math.abs(super.occupies.getFile()- o.getFile()) == 2)) && 
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
        return String.format("%s Knight at %s,%s",c,super.convertFile(super.occupies.getFile()),super.occupies.getRank() + 1 );
    }
    
}
