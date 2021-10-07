public class CLList{
  Node head;
  int length = 0;

  class Node{
    int data;
    Node next;

    Node(int data){
      this.data = data;
    }
  }

  //To print the list
  public void printList(){
    Node current = head;
    if(head != null){
      do{
        if(current.next != head){
          System.out.print(current.data+" "+"-> ");
        }else{
          System.out.print(current.data+" -> HEAD");
        }
        current = current.next;
      }while(current != head);
    }else{
        System.out.println("List is empty!");
    }
    System.out.println();
  }

  //Printing the length of the list
  public int listLength(){
    Node current = head;
    if(head != null){
      do{
        length +=1;
        current = current.next;
      }while(current != head);
    }
    // if(head != null){
    //   while(current.next != head){
    //     length +=1;
    //     current = current.next;
    //   }
    // }
    System.out.println("Length of CLL is: "+length);
    return length;
  }

  //To add node at the staring of the list
  public void push(int data){
    Node new_node = new Node(data);
    if(head == null){
      head = new_node;
      new_node.next = head;
      return;
    }
    new_node.next = head;
    Node last = head;
    while(last.next != head){
      last = last.next;
    }
    head = new_node;
    last.next = head;
  }

  //To add node at the end of the list.
  public void append(int data){
    Node new_node = new Node(data);
    if(head == null){
      head = new_node;
      new_node.next = new_node;
      return;
    }
    new_node.next = head;
    Node last = head;
    while(last.next != head){
      last = last.next;
    }
    last.next = new_node;
  }

  ////Adding node after a given node
  public void insertAfter(Node prev_Node, int data){
    Node new_node = new Node(data);
    if(prev_Node == null){
      System.out.println("Given prev node cannot be null!");
      return;
    }
    new_node.next = prev_Node.next;
    prev_Node.next = new_node;
  }

  //Insert a node before a given node.
  public void insertBefore(Node next_Node, int data){
    Node new_node = new Node(data);

    if(next_Node == null){
      System.out.println("Given next node cannot be null!");
      return;
    }
    //if adding before head
    if(next_Node == head){
      new_node.next = head;
      Node last = head;
      while(last.next != head){
        last = last.next;
      }
      last.next = new_node;
      head = new_node;
      return;
    }
    new_node.next = next_Node;
    Node prev = head;
    while(!prev.next.equals(next_Node)){
      prev = prev.next;
    }
    prev.next = new_node;
  }

  //To delete node from the beginning
  public void removetheHead(){
    Node last = head;
    if(head != null){
    while(last.next != head){
      last = last.next;
    }
  }else{
    System.out.println("Cannot delete head as List is empty!");
    return;
  }
    last.next = head.next;
    head.next = null;
    head = last.next;
  }

  //To delete node from the end of the list
  public void removeLastNode(){
    if(head == null){
      System.out.println("Cannot delete as the list is empty!");
      return;
    }
    if(head.next == head){
      head = null;
      return;
    }
    Node last = head, prev=null;
    while(last.next != head){
      prev = last;
      last = last.next;
    }
    prev.next = head;
    last.next = null;
  }

  ////Remove a node with the given matching key. If want to remove by given node then use equals()
  //instead of ==.
  public void deleteNodeWith(int key){
    //to delete head node;
    if(head.data == key){
      if(head.next == head){
        head.next = null;
        head = null;
        return;
      }
      Node first = head;
      Node last = head;
      while(last.next != head){
        last = last.next;
      }
      head = first.next;
      first.next = null;
      last.next = head;
      return;
    }
    Node keyNode = head, prev = null;
    while(keyNode != head && keyNode.data != key){
      prev = keyNode;
      keyNode = keyNode.next;
    }
    if(keyNode == head || keyNode.data != key){
        System.out.println("Given key is not present");
        return;
    }
    prev.next = keyNode.next;
    keyNode.next = null;
  }

    //Given the position remove the respective node from the list
    public void removeNodeAtPosition(int pos){
      if(pos >= listLength()){
        System.out.println("Given position is higher than the list length!");
        return;
      }
      //Removing the head;
      if(pos == 0){
        if(head.next == head){
          head.next = null;
          head = null;
          return;
        }
        Node first = head;
        Node last = head;
        while(last.next != head){
          last = last.next;
        }
        head = first.next;
        first.next = null;
        last.next = head;
        return;
      }
      Node keyNode = head, prev= null;
      for(int i = 0; i < pos; i++){
        prev = keyNode;
        keyNode = keyNode.next;
      }
      prev.next = keyNode.next;
      keyNode.next = null;
    }

  //To clear the list
  public void clearList(){
    head = null;
  }

  public static void main(String[] args){
    CLList clist = new CLList();

    clist.push(10);
    clist.push(90);
    clist.push(18);
    clist.append(100);
    //clist.removeNodeAtPosition(3);
    //clist.deleteNodeWith(18);
    //clist.removeLastNode();
    //clist.removetheHead();
    //clist.insertBefore(clist.head.next,23);
    //clist.insertAfter(clist.head.next.next.next.next, 40);
    //clist.clearList();
    clist.printList();
    clist.listLength();
  }
}
