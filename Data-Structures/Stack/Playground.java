//import "D:/Focus/Java/DS_ALGO/Stack/LinkedListStack.java";
//import "./LinkedListStack.java";

public class Playground{
  LinkedListStack stack = new LinkedListStack();
  //Stack<Integer> stk = new Stack<>();

  public boolean isOpeningBracket(char s){
    if(s == '(' || s == '{' || s == '['){
      return true;
    }
    return false;
  }

  public boolean isClosingBracket(char s){
    if(s == ')' || s == '}' || s == ']'){
      return true;
    }
    return false;
  }

  public int precedence(char op){
    int weight = -1;
    if(op == '+' || op == '-') return weight = 1;
    if(op == '*' || op == '/') return weight = 2;
    if(op == '^') return weight = 3;
    //if(op == '(') return weight = 5;
    return weight;
  }

  public boolean hasHigherPrecedence(char op1, char op2){
    int w1 = precedence(op1);
    int w2 = precedence(op2);
    if(w1 >= w2){
      return true;
    }
    return false;
  }

  public boolean isOperator(char op){
    if(op == '+' || op == '-' || op == '*' || op == '/' || op == '^'){
      return true;
    }
    return false;
  }
  public String infixToPostfix(String expression){
    String postfix = new String("");

    if(expression == null || expression.length() == 0) return "Empty Expression!";

    for(int i =0; i < expression.length(); i++){
      char exp = expression.charAt(i);

      if(isOperator(exp)){
        while(!stack.isEmpty() && !isOpeningBracket(stack.peek()) && hasHigherPrecedence(stack.peek(), exp)){
          postfix += stack.peek();
          stack.pop();
        }
        stack.push(exp);
      }
      else if(isOpeningBracket(exp)){
          stack.push(exp);
          //continue;
        }
      else if(isClosingBracket(exp)){
            while(!stack.isEmpty() && !isOpeningBracket(stack.peek())){
              postfix += stack.peek();
              stack.pop();
            }
            stack.pop();
          }
      else{
          postfix += exp;
          //continue;
            }
    }
    while(!(stack.isEmpty())){
      postfix += stack.peek();
      stack.pop();
    }
    return postfix;
  }

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
  //   return = res;
  // }
  //
  // //=======================
  // //Evaluate infix expression in single pass:
  // //Note: use two stacks:
  // public int evalInfix(String exp){
  //   Stack<Character> operator = new Stack<>();
  //   Stack<Integer> operands = new Stack<>();
  //
  //   for(int i =0; i < exp.length(); i++){
  //     char expr = exp.charAt(i);
  //     //check for brackets
  //     if(isOpeningBracket(expr)){
  //       operator.push(expr);
  //       continue;
  //     }else if(isOperand(expr)){
  //       operands.push(expr);
  //       continue;
  //     }else if(isOperator(expr)){
  //       while(!operator.isEmpty() && !isOpeningBracket(operator.peek()) && hasHigherPrecedenceOrEqual(operator.peek(), expr)){
  //         int op1 = operands.pop();
  //         int op2 = operands.pop();
  //         char op = operator.pop();
  //         if(op == '+') operands.push(op1 + op2);
  //         else if(op == '-') operands.push(op2 - op1);
  //         else if(op == '*') operands.push(op1 * op2);
  //         else if(op == '/') operands.push(op2 / op1);
  //       }
  //       operator.push(expr);
  //       continue;
  //     }
  //     else if(isClosingBracket(expr)){
  //       while(!operator.isEmpty() && !isOpeningBracket(operator.peek())){
  //         int op1 = operands.pop();
  //         int op2 = operands.pop();
  //         char op = operator.pop();
  //         if(op == '+') operands.push(op1 + op2);
  //         else if(op == '-') operands.push(op2 - op1);
  //         else if(op == '*') operands.push(op1 * op2);
  //         else if(op == '/') operands.push(op2 / op1);
  //       }
  //       operator.pop();
  //     }
  //   }
  //   while(!operator.isEmpty()){
  //     int op1 = operands.pop();
  //     int op2 = operands.pop();
  //     char op = operator.pop();
  //     if(op == '+') operands.push(op1 + op2);
  //     else if(op == '-') operands.push(op2 - op1);
  //     else if(op == '*') operands.push(op1 * op2);
  //     else if(op == '/') operands.push(op2 / op1);
  //   }
  //   return oprands.pop();
  // }
  //
  // public boolean isOperand(char s){
  //   int s = Integer.parseInt(String.valueOf(s));
  //   if(isOperator(s)){
  //     return false;
  //   }else if(isClosingBracket(s) || isClosingBracket(s)){
  //     return false;
  //   }
  //   return true;
  // }

  public static void main(String[] args){
    Playground obj = new Playground();
    System.out.println(obj.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
  }
}
