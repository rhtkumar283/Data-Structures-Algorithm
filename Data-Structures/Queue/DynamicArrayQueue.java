public class DynamicArrayQueue{
  int front;
  int rear;
  int[] queue;
  int capacity;
  int size;

  DynamicArrayQueue(int capacity){
    this.capacity = capacity;
    front = 0;
    rear = -1;
    size = 0;
    queue = new int[capacity];
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return (size == 0);
  }

  public boolean isFull(){
    return (size == capacity);
  }

  public void enQueue(int data){
    if(isFull()){
      expand();
    }
    size++;
    rear = (rear+1) % capacity;
    queue[rear] = data;

  }
  public void expand(){
    int curr_size = size();
    int[] new_queue = new int[curr_size * 2];
    System.arraycopy(queue,0,new_queue,0,curr_size);
    queue  = new_queue;
    capacity = curr_size * 2;
  }

  public void reduce(){
    int curr_size = size();
    if(curr_size < capacity/2){
      int[] new_queue = new int[capacity / 2];
      System.arraycopy(queue,0,new_queue,0,new_queue.length);
      queue = new_queue;
      capacity = capacity / 2;
    }
  }
  //-,-,12,3,4,
  public int deQueue(){
    if(isEmpty()){
      System.out.println("Queue is empty - Underflow.");
      return 0;
    }
    size--;
    reduce();
    int item = queue[front];
    queue[front] = Integer.MIN_VALUE;
    front = (front+1) % capacity;
    return item;
  }

  public int front(){
    if(isEmpty()){
      System.out.println("Queue is empty - Underflow.");
      return 0;
    }
    return queue[front];
  }

  public int rear(){
    if(isEmpty()){
      System.out.println("Queue is empty - Underflow.");
      return 0;
    }
    return queue[rear];
  }

  //returns the length of the dArray;
  public int length(){
    return queue.length;
  }

  public static void main(String[] args){
    DynamicArrayQueue dQueue = new DynamicArrayQueue(10);

    dQueue.enQueue(10);
    dQueue.enQueue(20);
    dQueue.enQueue(30);
    dQueue.enQueue(40);


    System.out.println(dQueue.deQueue()+" is deQueued.");
    System.out.println("Front: "+dQueue.front());
    System.out.println("Rear: "+dQueue.rear());
    System.out.println("Length: "+dQueue.length());

  }
}
