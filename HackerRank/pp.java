public class pp {

    public static void main(String[] args) {
        Practice.TOH(10, 'A', 'B', 'C');
    }
}

class Practice{
  public static void TOH(int n, char fromPeg, char toPeg, char auxPeg){
    if(n == 1){
      System.out.println("Move disk from "+fromPeg+" to "+toPeg);
      return;
    }
    TOH(n-1, fromPeg, auxPeg, toPeg);
    System.out.println("Move disk from "+fromPeg+" to "+toPeg);
    TOH(n-1,auxPeg, toPeg, fromPeg);
  }
}
