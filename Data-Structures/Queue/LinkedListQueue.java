public class LinkedListQueue{
  Node front, rear;
  int length;

  class Node{
    int data;
    Node next;
    Node(int data){
      this.data = data;
    }
  }
  //to get the length of the queue;
  public int size(){
    return length;
  }
  //to see if list is empty:
  private boolean isEmpty(){
    return (front == null);
  }
  //to get the front element
  public int qFront(){
    if(isEmpty()){
      return 0;
    }
    return front.data;
  }
  //to get the rear of the list;
  public int qRear(){
    if(isEmpty()){
      return 0;
    }
    return rear.data;
  }
  //Enqueue;
  public void enQueue(int data){
    Node new_node = new Node(data);
    if(isEmpty()){
      front = new_node;
      rear = new_node;
      length++;
      System.out.println(rear.data+" is EnQueued!");
      return;
    }
    rear.next = new_node;
    new_node.next = null;
    rear = new_node;
    length++;
    System.out.println(rear.data+" is EnQueued!");
  }
  //DeQueue;
  public void deQueue(){
    if(isEmpty()){
      System.out.println("Queue is empty - Underflow");
      return;
    }
    Node temp = front;
    front = front.next;
    temp.next = null;
    length--;
    if(front == null){
      rear = null;
    }
    System.out.println(temp.data+" is Dequeued!");
  }
  //To print the queue:
  public void printQueue(){
    if(isEmpty()){
      System.out.println("No element to print - Queue is empty");
      return;
    }
    Node current = front;
    while(current != null){
      System.out.print(current.data+" -> ");
      current = current.next;
    }
    System.out.println();
  }

  public static void main(String[] args){
    LinkedListQueue lQueue = new LinkedListQueue();
    lQueue.enQueue(10);
    lQueue.enQueue(20);
    lQueue.enQueue(30);
    lQueue.enQueue(40);
    lQueue.deQueue();

    System.out.println("Front item is - "+lQueue.qFront());
    System.out.println("Rear item is - "+lQueue.qRear());
    System.out.println("Size - "+lQueue.size());

    lQueue.printQueue();

  }
}
