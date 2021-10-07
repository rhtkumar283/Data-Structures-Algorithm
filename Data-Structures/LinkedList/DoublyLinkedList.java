public class DoublyLinkedList{
  Node head;
  int length = 0;

  class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
      this.data = data;
    }
  }

  //Printing the entire DLL
  public void printList(){
    Node current = head;
    while(current != null){
      if(current.next != null){
        System.out.print(current.data+" "+"<-> ");
      }else{
        System.out.print(current.data+" -> NULL");
      }
      current = current.next;
    }
    System.out.println();
  }

  //Printing the length of the list
  public int listLength(){
    Node current = head;
    while(current != null){
      length += 1;
      current = current.next;
    }
    System.out.println("Length of DLL is: "+length);
    return length;
  }

  //Adding node at the starting of the list
  public void push(int data){
    Node new_node = new Node(data);

    new_node.next = head;
    new_node.prev = null;

    if(head != null){
      head.prev = new_node;
    }
    head = new_node;
  }
  //Adding node at the end of the list
  public void append(int data){
    Node new_node = new Node(data);
    Node last = head;

    if(head == null){
      head = new_node;
      return;
    }
    while(last.next != null){
      last = last.next;
    }
    last.next = new_node;
    new_node.next = null;
    new_node.prev = last;
  }

  //[1|->]
  //{1,2,3}
  // ^
  //[|] = [1|->]

  //Adding node after a given node
  public void insertAfter(Node prev_Node, int data){
    Node new_node = new Node(data);
    if(prev_Node == null){
      System.out.println("The give previous node cannot be null!");
      return;
    }
    new_node.next = prev_Node.next;
    new_node.prev = prev_Node;
    if(prev_Node.next != null){
      prev_Node.next.prev = new_node;
    }
    prev_Node.next = new_node;
  }

  //{11,12,13}

  //Inserting a node before a given node
  public void insertBefore(Node next_Node, int data){
    Node new_node = new Node(data);

    if(next_Node == null){
      System.out.println("The given next node cannot be null");
      return;
    }
    new_node.next = next_Node;
    new_node.prev = next_Node.prev;
    if(next_Node.prev != null){
      next_Node.prev.next = new_node;
    }else{
      head = new_node;
    }
    next_Node.prev = new_node;
  }

  //Remove the node with the matching key.
  public void deleteNodeWith(int key){
    Node keyNode = head;

    if(head == null){
      System.out.println("The list is empty!");
      return;
    }
    //if key is at the head itself.
    if(keyNode != null && keyNode.data == key){
      if(keyNode.next == null) {
        head = null;
        return;
      }
      head.next.prev = null;
      head = head.next;
      return;
    }
    while(keyNode != null && keyNode.data != key){
      keyNode = keyNode.next;
    }
    if(keyNode == null){
      System.out.println("Node with the given key is not present in list.");
      return;
    }else if(keyNode.next == null){ //if key is present at the end of the list
      keyNode.prev.next = keyNode.next;
      keyNode.prev = null;
      return;
    }
    keyNode.prev.next = keyNode.next;
    keyNode.next.prev = keyNode.prev;
  }

  //Get the position of the node based on the given key.
  public void getPositionOf(int key){
    Node current = head;
    int pos = 0;
    if(head == null){
      System.out.println("List is empty!");
      return;
    }
    while(current != null){
      if(current.data == key){
        System.out.println("The node is at: "+pos);
        return;
      }
      current = current.next;
      pos += 1;
    }
    if(current == null){
      System.out.println("Node is not present in the list!");
      return;
    }
  }

  //Given the position remove the respective node from the list
  public void removeNodeAtPosition(int pos){
    Node keyNode = head;

    //if the given pos is greater than the listLength
    if(pos >= listLength()){
      System.out.println("The given positon is greater than the list length.");
      return;
    }
    for(int i = 0; i < pos; i++){
      keyNode = keyNode.next;
    }
    //If the keyNode is at the head
    if(pos == 0){
      if(keyNode.next == null){
        head = null;
        return;
      }
      keyNode.next.prev = null;
      head = head.next;
      return;
    }

    //if keynode is at the end.
    if(keyNode.next == null){
      keyNode.prev.next = null;
      keyNode.prev = null;
      return;
    }

    keyNode.next.prev = keyNode.prev;
    keyNode.prev.next = keyNode.next;
  }

  //To clear the list.
  public void clearList(){
    head = null;
  }

  // public void pairSumDll(int target){
  //
  //   Node first = head;
  //   Node last = head;
  //   int sum = 0;
  //   while(last.next != null) last = last.next;
  //
  //   while(first != last){
  //     sum = first.data + last.data;
  //     if(sum == target){
  //       System.out.println(first.data + " " + last.data);
  //       first = first.next;
  //       last = last.prev;
  //     }else if(sum > target){
  //        last = last.prev;
  //      } else{
  //         first = first.next;
  //       }
  //   }
  // }

  public static void main(String[] args){
    DoublyLinkedList dlist = new DoublyLinkedList();

    dlist.push(9);
    dlist.push(8);
    dlist.push(6);
    dlist.push(5);
    dlist.push(4);
    dlist.push(2);
    dlist.push(1);
    dlist.pairSumDll(7);
    //dlist.printList();
    //dlist.deleteNodeWith(100);
    //dlist.removeNodeAtPosition(3);
    //dlist.getPositionOf(10);
    //dlist.clearList();
    dlist.printList();
    dlist.listLength();
    //dlist.pairSumDll(60);
  }
}
