import java.util.*;

public class Fibonacci{
  static long result = 0;
  public static void main(String[] main){
    int n = 1000;
    long[] memo = new long[n+1];
    Arrays.fill(memo, 0);

    //System.out.println("Naive: "+fibNaive(n));
    System.out.println("DP with recursion: "+fibDP(n, memo));
    System.out.println("DP without recursion: "+fibBottomUp(n));

  }

  //Naive Approach: O(2^n)
  public static int fibNaive(int n){
    if(n == 1 || n == 2){
      return 1;
    }
    else{
      return fibNaive(n-1) + fibNaive(n-2);
    }
  }

  //Dynamic programming approach with recursion: O(n)
  public static long fibDP(int n, long[] memo){
      if(memo[n] != 0){
        return memo[n];
      }
      if(n == 1 || n == 2) result = 1;
      else
        result = fibDP(n-1, memo) + fibDP(n-2, memo);
      memo[n] = result;
      return result;
  }

  //Dynamic programming approach without recursion: O(n)
  public static long fibBottomUp(int n){
    if(n == 1 || n == 2) return 1;
    long[] memo = new long[n+1];

    memo[1] = 1;
    memo[2] = 1;

    for(int i = 3; i <= n; i++){
      memo[i] = memo[i-1] + memo[i-2];
    }
    return memo[n];

  }

}
