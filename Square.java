public class Square {
    private int rank;
    private int file;

    private Piece occupied;
    private boolean checkedBlack = false;
    private boolean checkedWhite = false;
    private Board board;

    public Square(int r, int f, Piece p, Board b){
        rank = r;
        file = f;
        board = b;
        occupied = p;
        if (p != null) {
            p.setSquare(this);
        }
    }

    public Piece getPiece(){
        return occupied;
    }

    public Board getBoard(){
        return board;
    }

    public int getRank(){
        return rank;
    }

    public int getFile(){
        return file;
    }

    public void setPiece(Piece p){
        occupied = p;
    }

    public boolean equals(Square s){
        return (s.getRank() == rank && s.getFile() == file);
    }

}
