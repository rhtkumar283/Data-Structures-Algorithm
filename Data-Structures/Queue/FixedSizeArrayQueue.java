public class FixedSizeArrayQueue{
  private int size, front, rear;
  private int capacity;
  private int[] qArray;

  FixedSizeArrayQueue(int cap){
    this.capacity = cap;
    size = 0;
    front = 0;
    rear = -1;
    qArray = new int[this.capacity];
  }

  //to see if the queue is empty:
  private boolean isEmpty(){
    return (size == 0);
  }
  //to see if the queue is full:
  private boolean isFull(){
    return (size == capacity);
  }
  //To print the size of the queue;
  public void size(){
    System.out.println("Size : "+(size+1));
  }
  //to EnQueue i.e. to add an element in queue:
  public void enQueue(int data){
    if(isFull()){
      System.out.println("Queue is full - Overflow.");
      return;
    }
    size++;
    rear = (rear+1) % capacity;
    qArray[rear] = data;

    System.out.println(data+" is enQueued.");
  }

  //-,2,3,4,5,
  //to DeQueue i.e. to remove an element from the queue;
  public int deQueue(){
    if(isEmpty()){
      System.out.println("Queue is empty - Underflow.");
      return 0;
    }
    size--;
    int item = qArray[(front % capacity)];
    qArray[front] = Integer.MIN_VALUE;
    front = (front+1) % capacity;
    return item;
  }
  //To get the front of the queue;
  public int qFront(){
    if(isEmpty()){
      System.out.println("Queue is empty.");
      return 0;
    }
    return qArray[front];
  }
  //To get the rear of the queue;
  public int qRear(){
    if(isEmpty()){
      System.out.println("Queue is empty.");
      return 0;
    }
    return qArray[rear];
  }
  //To print the queue;
  public void printQueue(){
    if(isEmpty()){
      System.out.println("Queue is empty.");
      return;
    }
    for(int i = 0; i < size; i++){
      System.out.print(qArray[i]+" ");
    }
  }

  public static void main(String[] args){
    FixedSizeArrayQueue qArr = new FixedSizeArrayQueue(7);
    qArr.enQueue(10);
    qArr.enQueue(20);
    qArr.enQueue(50);
    qArr.enQueue(55);
    qArr.enQueue(40);
    qArr.enQueue(33);
    System.out.println(qArr.deQueue()+" is deQueued.");
    qArr.enQueue(90);
    qArr.enQueue(30);
    //qArr.enQueue(90);
    System.out.println("Front item is - "+qArr.qFront());
    System.out.println("Rear item is - "+qArr.qRear());
    qArr.size();

    qArr.printQueue();
  }
}
