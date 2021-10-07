public class FixedLengthStack{
  protected int capacity;
  public static final int defaultCapacity = 4;
  protected int[] stack;
  protected int top = -1;
  //To initialize default length stack;
  FixedLengthStack(){
    stack = new int[defaultCapacity];
    capacity = defaultCapacity;
  }
  //Custom Error handling
  class StackException extends Exception{
    StackException(String s){
      super(s);
    }
  }
  //To initialize given length stack;
  FixedLengthStack(int cap){
    capacity = cap;
    stack = new int[capacity];
  }
  //To get the size of the stack;
  public int size(){
    return top+1;
  }
  
  //To check if the stack is empty;
  public boolean isEmpty(){
    return (top < 0);
  }
  //To insert an element in the stack;
  public void push(int data) throws StackException{
    // if(size() == capacity){
    //   System.out.println("Stack is full!");
    //   return;
    // }
    if(size() == capacity){
      throw new StackException("Stack is full!");
    }
    stack[++top] = data;
  }

  //To get the top element of the stack; top() / peek();
  public void top(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    System.out.println("Top element is: "+stack[top]);
  }

  //To remove an element from the stack;
  public void pop(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    stack[top--] = Integer.MIN_VALUE;
  }

  public void printStack(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    for(int i = 0; i <= top; i++){
      System.out.print(stack[i]+" ");
    }
    System.out.println();
  }

  //Main method;
  public static void main(String[] args){
    FixedLengthStack stk = new FixedLengthStack(5);
    try{
      stk.push(10);
      stk.push(20);
      stk.push(80);
      stk.push(90);
      stk.push(100);
      stk.push(50);
    }catch(StackException m){
      System.out.println(m);
    }

    int size = stk.size();
    System.out.println("Size: "+size);
    stk.top();

    stk.printStack();
  }
}
