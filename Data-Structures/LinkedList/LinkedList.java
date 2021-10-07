public class LinkedList {
  Node head;
  int length = 0;

  class Node{
    int data;
    Node next;
//[data,next]  [data,next]
    //Node created will have next = null by default
    Node(int data){
      this.data = data;
      this.next = null;
    }
  }
  //To print the list
    public void printList(){
      Node current = head;
      if(head == null){
        System.out.println("List is empty!");
        return;
      }
      //While(current.next != null)
      while(current != null){
        System.out.print(current.data+"->");
        current = current.next;
      }
    }

    //To get the length of the list.
    public void listLength(){
      Node current = head;
      while(current != null){
        current = current.next;
        length += 1;
      }
      System.out.println("\nLinked List length: "+length);
    }

    //To insert node at the beginning of the list
    public void push(int data){
      Node new_node = new Node(data);
      if(head == null){
        head = new_node;
        return;
      }
      //head
      //Node head.next = Node new_new;
      new_node.next = head; //To make next of new_node -> first_node
      head = new_node;
    }

    //To add a node after a given Node
    public void insert(Node prev_node, int data){
      if(prev_node == null){
        System.out.println("The previous node cannot be null!");
        return;
      }
      Node new_node = new Node(data);
      new_node.next = prev_node.next;
      prev_node.next = new_node;
    }

    //To add node at the end of the list.
    public void append(int data){
      //Node new_node = new Node(data);
      if(head == null){
        head = new Node(data);
        return;
      }
      Node new_node = new Node(data);
      new_node.next = null;

      Node last = head;
      while(last.next != null){
        last = last.next;
      }
      last.next = new_node;
    }

    //Remove and return the node at the head of the list.
    public synchronized Node removetheHead(){
      Node node = head;
      //head = head.next;
      head = node.next;
      node.next = null;
      return node;
    }

    //Remove and return the node at the end of the list
    public synchronized Node removeAtEnd(){
      Node current = head, prev = null;

      if(current == null){
        System.out.println("List is empty, nothing to remove!");
        return null;
      }else if(current.next == null){
        head = current.next;
        return current;
      }else{
        while(current.next != null){
          prev = current;
          current = current.next;
        }
        //{ 1,2,3,4,5 }
        prev.next = null;
      }
      return current;
    }

    //Remove a node with the given matching key. If want to remove by given node then use equals()
    //instead of ==.
    public void deleteNodeAt(int key){
      Node keyNode = head, prev_node = null;

      if(head == null){
        System.out.println("Nothing to be deleted since list is empty!");
        return;
      }
      //if key is present at the head itself.
      if(keyNode != null && keyNode.data == key){
        head = keyNode.next;
        keyNode.next = null;
        return;
      }
      while(keyNode != null && keyNode.data != key){
        prev_node = keyNode;
        keyNode = keyNode.next;
      }
      //If key is not at all present in the list.
      if(keyNode == null){
        System.out.println("Key is not present in the list!");
        return;
      }
      prev_node.next = keyNode.next;
      keyNode.next = null;
    }

    //To get the position of the given data in linked linked list
    public void getPosition(int data){
      Node current = head;
      int pos = 0;
      if(head == null){
        System.out.println("List is empty!");
        return;
      }
      while(current != null){
        if(current.data == data){
          System.out.println("Node with given data is present at "+ pos);
          return;
        }
        pos += 1;
        current = current.next;
      }
      System.out.println("Not Found!");
      return;
    }

    //Reversing the list;
    // public void reverseList(){
    //   Node current = head;
    //   Node prev = null;
    //   if(head == null){
    //     System.out.println("List is empty!");
    //     return;
    //   }else if(head.next == null){
    //       printList();
    //       return;
    //   }
    //   //{ 12 <-> 435 <-> 76 }
    //   //current = 76
    //   //next = 76
    //   //prev = 435
    //   while(current != null){
    //     Node next = current.next;
    //     current.next = prev;
    //     prev = current;
    //     current = next;
    //   }
    //   head = prev;
    // }

    //GFG recursive reverseList
    public void reverseList(){
    Node current = head;
    Node prev = null;
    Node next = null;
    reverseListH(current,prev, next);
    }
    void reverseListH(Node current, Node prev, Node next){
    if(current == null){
        head = prev;
        //printList();
        return;
    }
    else{
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    reverseListH(current, prev, next);
    //printList();
}

    //Given the position remove the respective node from the list
    public void removeNodeAtPosition(int pos){
      Node keyNode = head, prev_node=null;

      //Check for condition if position is more than the number of nodes

      if(head == null){
        System.out.println("List is empty!");
        return;
      }
      //If head is to be removed
      if(pos == 0){
        head = keyNode.next;
        keyNode.next = null;
        return;
      }
      for(int i = 0; i < pos; i++){
        prev_node = keyNode;
        keyNode = keyNode.next;
      }
      prev_node.next = keyNode.next;
      keyNode.next = null;
    }

    //Remove everything from the list.
    //In Java and Python, automatic garbage collection happens,
    //so deleting a linked list is easy. Just need to change head to null.
    public void clearList(){
      head = null;
    }


    public static void main(String[] args){
      LinkedList list = new LinkedList();

      // list.push(65);
      // list.append(60);
      // list.append(70);
      //50-80-60-90
      list.push(50);
      list.insert(list.head, 80);
      list.append(60);
      list.append(90);
      list.reverseList();
      //list.printList();
      //System.out.println();
      //list.removeNodeAtPosition(0);
      //list.printList();
      //list.clearList();
      //Node node = list.removeAtEnd();
      //list.deleteNodeAt(90);
      System.out.println();
      //list.getPosition(60);
      // Node node = list.removetheHead();
      //System.out.println(node.data);
      list.printList();
      list.listLength();
    }
}
