class BinarySum {

    public static void main(String[] args){
      String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
      String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
      //String b = "1100011110011010010011000000000";

      System.out.println(addBinary(a,b));
    }

    public static int binarySum(String str){
        int sum = 0;
        int base = 1;
          System.out.println(str);
        for(int i = str.length()-1; i >= 0; i--){
              //System.out.println(str.charAt(i));
            sum = sum + (str.charAt(i) == '1' ? base * 1 : 0);

            base = base * 2;
        }
        System.out.println("Int: "+sum);
        return sum;
    }

    public static String intToBinary(long num){
        System.out.println(num);
        String ans = new String();
        long rem = 0;
        long count = 0;
        while(num != 0){
            rem = num % 2;
            ans += (rem == 1 ? "1" : "0");
            num = num / 2;
            System.out.print(num +" ");
            count++;
        }
          System.out.println("Count: " + count);

        char[] res = ans.toCharArray();
        //System.out.println(res.length);
        String finalres = new String();
        for(int j = res.length-1; j >= 0; j--){
            finalres += res[j];
        }
        //System.out.println(finalres);
        return finalres;
    }

    public static String addBinary(String a, String b) {
        int sumA = binarySum(a);
        int sumB = binarySum(b);
        long total = sumA + sumB;
        return intToBinary(total);

    }
}
