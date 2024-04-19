public abstract class Piece {

    protected int color;
    protected Square occupies;
    
    public int getColor(){
        return color;
    }

    public Square getSquare(){
        return occupies;
    }

    public void setSquare(Square s){
        occupies = s;
    }

    public abstract boolean move(Square s);

    public String convertFile(int n){
        switch(n){
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";
            default:
                return "";
        }
    }
}