public class TwoSum{
  public static void main(String[] args){
    int[] a1 = {1,2,8,9};
    int[] a2 = {5,2,1};

    int ans = twoSumArray(a1, a2);
    System.out.println(ans);
    System.out.println(-321 % 10 + " " + -321 /10);
  }

  public static int twoSumArray(int[] a1, int[] a2){
    int length1 = a1.length;
    int length2 = a2.length;

    if(length1 >= length2){
      return twoSumArrayUtil(a1, a2, length1, length2);
    }else{
      return twoSumArrayUtil(a2, a1, length2, length1);
    }
  }

  public static int twoSumArrayUtil(int[] a1, int[] a2, int length1, int length2){
    int[] sum = new int[length1];
    int s = 0;
    int carry = 0;
    int j = length2 -1;
    int i = length1 -1;
    int k = i;

    while(j >= 0){
        s = a1[i] + a2[j] + carry;
        sum[k] = s % 10;
        carry = s /10;

        i--;
        k--;
        j--;
    }
    while(i >= 0){
      s = a1[i] + carry;
      sum[k] = s%10;
      carry = s/10;
      i--;
      k--;
    }
    int ans = 0;
    if(carry == 1) ans = 10;

    for(int l = 0; l < a1.length; l++){
      ans += sum[l];
      ans *= 10;
    }
      return (ans/10);
  }


}
