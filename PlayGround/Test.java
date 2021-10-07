import java.util.*;

public class Test{
  public static void main(String[] args){
    // int[] arr1 = {1,2,3,4,5};
    // String[] arr2 = {"My", "Name", "is", "Bob"};
    // System.out.println(add(arr2));
    //System.out.println(isValid("()"));
    int [] arr1 = {9,9,9};
    int[] arr = plusOne(arr1);
    for(int i = 0; i < arr.length; i++)
      System.out.println(arr[i]);
  }

  public static int add(int[] arr){
    int sum = 0;
    for(int a : arr) sum += a;
    return sum;
  }
  public static String add(String[] arr){
    String res = new String();
    //String res;
    for(String a : arr) res += a;
    return res;
  }

    public static boolean isPalindrome(int x) {
        int digit = 0;
        int rev = 0;
        int temp = x;

        while(x > 0){
            digit = x % 10;
            x = x /10;
            rev = (rev * 10) + digit;

            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return false;
        }
        System.out.println(rev);

        if(temp == rev) return true;
        else return false;
    }
    public static int precedence(char a){
        switch(a){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;

        }
    }
    public static int romanToInt(String s) {
        int sum  = 0;
        int counter  = 0;
        //System.out.println(s.length());
        for(int i = 0; i < s.length(); i++){
          //System.out.println(counter++);
            char ch = s.charAt(i);
            if(i == s.length() - 1){
              sum += precedence(ch);
              return sum;
            }
            if(precedence(ch) >= precedence(s.charAt(i+1)))
                sum += precedence(ch);
            else{
                sum = sum + (precedence(s.charAt(i+1)) - precedence(ch));
                i = i+1;
            }
        }
        return sum;
    }
    public static boolean isValid(String s) {
        if((s.length() % 2) != 0) return false;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(') stack.push(')');
            else if(ch == '{') stack.push('}');
            else if(ch == '[') stack.push(']');
            else{
                  if(stack.isEmpty() || stack.pop() != s.charAt(i))
                    return false;
                }
            }
            return (stack.isEmpty());
        }

        /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
  // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  //       ListNode ans = new ListNode(0);
  //       ListNode temp = ans;
  //
  //       while(l1 != null && l2 != null){
  //           if(l1.val <= l2.val){
  //               temp.next = l1;
  //               l1 = l1.next;
  //           }else{
  //               temp.next = l2;
  //               l2 = l2.next;
  //           }
  //           temp = temp.next;
  //       }
  //
  //       if(l1 != null) temp.next = l1;
  //       else if(l2 != null) temp.next = l2;
  //
  //       return ans.next;
  //   }

    public static int[] plusOne(int[] digits) {
        int last  = digits[digits.length -1];
        if(last + 1 < 9){
                digits[digits.length -1] = last + 1;
                return digits;
        }
        int carry = 1;
        int sum = 0;
        for(int i = digits.length-1; i >= 0; i--){
            sum = digits[i] + carry;
            System.out.println("Sum: "+ sum);
            digits[i] = sum % 10;
            carry = sum /10;
        }
        for(int j =0; j < digits.length; j++)
        System.out.println(digits[j] + "End in function\n");

        if(carry != 0){
            int[] temp = new int[digits.length+1];
            temp[0] = carry;
            int index = 1;
            for(int i = 0; i < digits.length; i++){
                temp[index++] = digits[i];
            }
            return temp;
        }else return digits;
    }
}
