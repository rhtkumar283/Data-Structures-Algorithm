public class DynamicArrayStack{
  private int top = -1;
  private int[] stack;
  private int capacity;
  private int defaultCapacity = 5;

  //To initialize fixed size DArray;
  DynamicArrayStack(){
    stack = new int[defaultCapacity];
    this.capacity = defaultCapacity;
  }

  //To initialize given length DArray;
  DynamicArrayStack(int capacity){
    this.capacity= capacity;
    stack = new int[capacity];
  }

  //To get the size of the DArray
  public int size(){
    return top+1;
  }
  //To check for empty DArray;
  public boolean isEmpty(){
    return (top < 0);
  }

  //To insert element in DArray;
  public void push(int data){
    if(size() == capacity){
      expand();
    }
    stack[++top] = data;
  }

  //To expand the DArray if full;
  private void expand(){
    int curr_size = size();
    int[] new_array = new int[curr_size * 2];
    System.arraycopy(stack, 0, new_array, 0, curr_size);
    stack = new_array;
    capacity = curr_size * 2;
  }

  //To reduce the DArray if we can;
  private void reduce(){
    int curr_size = size();
    if(curr_size < capacity / 2){
      int[] new_array = new int[capacity / 2];
      System.arraycopy(stack,0,new_array,0,new_array.length);
      stack = new_array;
      capacity = new_array.length;
    }
  }

  //To get the top element of the stack;
  public void top(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    System.out.println("Top element is: "+stack[top]);
  }

  //To remove an element from the DArray;
  public void pop(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    stack[top--] = Integer.MIN_VALUE;
    reduce();
  }
  //To print the stack;
  public void printStack(){
    if(isEmpty()){
      System.out.println("Stack is empty!");
      return;
    }
    for(int i = 0; i<=top; i++){
      System.out.print(stack[i]+" ");
    }
    System.out.println();
  }

  public static void main(String[] args){
    DynamicArrayStack dStk = new DynamicArrayStack();
    dStk.push(40);
    dStk.push(30);
    dStk.push(22);
    dStk.push(90);
    dStk.push(100);
    dStk.push(99);
    dStk.push(90);

    //dStk.pop();

    int size = dStk.size();
    System.out.println("Size: "+size);
    dStk.top();

    dStk.printStack();
  }
}
