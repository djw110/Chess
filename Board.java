public class Board {
    private Square[][] squares = new Square[8][8];

    public Board(){
        for (int r = 0; r < squares.length; r++){
            switch (r) {
                case 0:
                    squares[r][0] = new Square(r, 0, new Rook(1),this);
                    squares[r][1] = new Square(r, 1, new Knight(1),this);
                    squares[r][2] = new Square(r, 2, new Bishop(1),this);
                    squares[r][3] = new Square(r, 3, new Queen(1),this);
                    squares[r][4] = new Square(r, 4, new King(1),this);
                    squares[r][5] = new Square(r, 5, new Bishop(1),this);
                    squares[r][6] = new Square(r, 6, new Knight(1),this);
                    squares[r][7] = new Square(r, 7, new Rook(1),this);
                    break;

                case 1:
                    for (int f = 0; f < squares.length; f++){
                        squares[r][f] = new Square(r,f, new Pawn(1),this);
                    }
                    break;

                case 6:
                    for (int f = 0; f < squares.length; f++){
                        squares[r][f] = new Square(r,f, new Pawn(0),this);
                    }
                    break;

                case 7:
                    squares[r][0] = new Square(r, 0, new Rook(0),this);
                    squares[r][1] = new Square(r, 1, new Knight(0),this);
                    squares[r][2] = new Square(r, 2, new Bishop(0),this);
                    squares[r][3] = new Square(r, 3, new Queen(0),this);
                    squares[r][4] = new Square(r, 4, new King(0),this);
                    squares[r][5] = new Square(r, 5, new Bishop(0),this);
                    squares[r][6] = new Square(r, 6, new Knight(0),this);
                    squares[r][7] = new Square(r, 7, new Rook(0),this);
                    break;
            
                default:
                    for (int f = 0; f < squares.length; f++){
                        squares[r][f] = new Square(r,f, null,this);
                    }
                    break;
            }
        }
    }

    public Square find(int r, int f){
        return squares[r][f];
    }
}
