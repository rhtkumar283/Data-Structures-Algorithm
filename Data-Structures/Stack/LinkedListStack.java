public class LinkedListStack{
  public Node top;
  private int length = 0;

  class Node{
    int data;
    Node next;
    Node(int data){
      this.data = data;
    }
  }

  //Check if the list is Empty;
  public boolean isEmpty(){
    //return (top.next == null);
    return (length == 0);
  }

  //Add the given data to the stack list;
  public void push(int data){
    Node new_node = new Node(data);
    new_node.next = top;
    top = new_node;
    length++;
  }

  //Remove the element from the stack (from the top or head of list stack);
  public int pop(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return 'N';
    }
    int temp = top.data;
    top = top.next;
    length--;
    return temp;
  }

  //To take a peek at the top element in stack list;
  public int peek(){
    if(isEmpty()){
      //System.out.println("Stack is empty!");
      return 'N';
    }
    return top.data;
  }

  //To get the size of the stack;
  public int size(){
    return length;
  }

  //Print the list;
  public void printStack(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    Node current = top;
    while(current != null){
      System.out.print(current.data+" ->");
      current = current.next;
    }
    System.out.println();
    System.out.println("Size: "+size());
  }

//========================//
//Problem Solving:
//   public boolean checkIfBalancedSymbols(String s){
//     LinkedListStack stack = new LinkedListStack();
//     if(s == null || s.length() == 0){
//       return true;
//     }
//     for(int i = 0; i < s.length(); i++){
//       if(s.charAt(i) == ']'){
//         if(!stack.isEmpty() && stack.peek() == '['){
//           stack.pop();
//         }
//         else{
//           return false;
//         }
//       }else if(s.charAt(i) == ')'){
//         if(!stack.isEmpty() && stack.peek() == '('){
//           stack.pop();
//         }
//         else{
//           return false;
//         }
//     }else if(s.charAt(i) == '}'){
//       if(!stack.isEmpty() && stack.peek() == '{'){
//         stack.pop();
//       }
//       else{
//         return false;
//       }
//   }else{
//     if(s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{'){
//       stack.push(s.charAt(i));
//     }else{
//       continue;
//     }
//   }
// }
//   if(stack.isEmpty())
//     return true;
//   else
//     return false;
//
// }
//
// public boolean isOpeningBracket(char s){
//   if(s == '(' || s == '{' || s == '['){
//     return true;
//   }
//   return false;
// }
//
// public boolean isClosingBracket(char s){
//   if(s == ')' || s == '}' || s == ']'){
//     return true;
//   }
//   return false;
// }
//
// public int precedence(char op){
//   int weight = -1;
//   if(op == '+' || op == '-') return weight = 1;
//   if(op == '*' || op == '/') return weight = 2;
//   if(op == '^') return weight = 3;
//   return weight;
// }
//
// public boolean hasHigherPrecedenceOrEqual(char op1, char op2){
//   int w1 = precedence(op1);
//   int w2 = precedence(op2);
//   if(w1 >= w2){
//     return true;
//   }
//   return false;
// }
//
// public boolean isOperator(char op){
//   if(op == '+' || op == '-' || op == '*' || op == '/' || op == '^'){
//     return true;
//   }
//   return false;
// }

//==================================
//infixToPostfix:
// public String infixToPostfix(String expression){
//   LinkedListStack stack = new LinkedListStack();
//   String postfix = new String("");
//
//   if(expression == null || expression.length() == 0) return "Empty Expression!";
//
//   for(int i =0; i < expression.length(); i++){
//     char exp = expression.charAt(i);
//
//     if(isOperator(exp)){
//       while(!stack.isEmpty() && stack.peek() != '(' && hasHigherPrecedenceOrEqual(stack.peek(), exp)){
//         postfix += stack.peek();
//         stack.pop();
//         printStack();
//       }
//       stack.push(exp);
//       continue;
//
//     }
//     else if(isOpeningBracket(exp)){
//         stack.push(exp);
//         continue;
//       }
//     else if(isClosingBracket(exp)){
//           while(!stack.isEmpty() && !isOpeningBracket(stack.peek())){
//             postfix += stack.peek();
//             stack.pop();
//           }
//           stack.pop();
//         }
//     else{
//         postfix += exp;
//         continue;
//           }
//   }
//   while(!(stack.isEmpty())){
//     postfix += stack.peek();
//     stack.pop();
//   }
//   return postfix;
// }

//=======================
//Evaluating postfix expression:
// public int evalPostFix(String exp){
//   LinkedListStack stack = new LinkedListStack();
//   for(int i = 0; i< exp.length(); i++){
//     char expr = exp.charAt(i);
//     if(expr == '+'){
//       int op1 = stack.pop();
//       int op2 = stack.pop();
//       stack.push(op1 + op2);
//       continue;
//     }
//     if(expr == '-'){
//       int op1 = stack.pop();
//       int op2 = stack.pop();
//       stack.push(op2 - op1);
//       continue;
//     }
//     if(expr == '*'){
//       int op1 = stack.pop();
//       int op2 = stack.pop();
//       stack.push(op1 * op2);
//       continue;
//     }
//     if(expr == '/'){
//       int op1 = stack.pop();
//       int op2 = stack.pop();
//       stack.push(op1 / op2);
//       continue;
//     }
//     stack.push(Integer.parseInt(expr));
//   }
//   int res = stack.pop();
//   return res;
// }

//=======================================//


  public static void main(String[] args){
    LinkedListStack lStk = new LinkedListStack();
    // lStk.push('[');
    // lStk.push('(');
    lStk.push(20);
    lStk.push(10);
    lStk.push(100);
    lStk.push(20);
    lStk.push(10);
    lStk.push(100);
    lStk.pop();
    int top = lStk.peek();
    System.out.println("Top: "+ top);
    //boolean res = lStk.checkIfBalancedSymbols("((A+B)+[A-B]-{A-C})");

    //System.out.println(lStk.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));

    lStk.printStack();
  }
}
