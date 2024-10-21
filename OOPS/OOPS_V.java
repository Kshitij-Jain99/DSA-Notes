public class OOPS_V {
    
    public static void main(String args[]){
    Queen q = new Queen();
    q.moves();
    }

}

interface ChessPlayer{  //moves k liye sirf blueprint liya hai define nhi kiya move ko
    void moves();   //satisfy interface properties,have them
}
  //classes of chessplayer defines moves on basis of pieces
class Queen implements ChessPlayer{
    public void moves() { //public nhi likhnege to moves() default type ka ho jayega
        System.out.println("up,down,left,right,diagonal");
    }
}

class Rock implements ChessPlayer{
    public void moves() { //public nhi likhnege to moves() default type ka ho jayega
        System.out.println("up,down,left");
    }
}

class King implements ChessPlayer{
    public void moves() { //public nhi likhnege to moves() default type ka ho jayega
        System.out.println("up,down,left,right,diagonal(all by 1 step only)");
    }
}
