
//Problem-12: Check whether the given linked list is NULL-terminated or not.
//If there is a cycle find the start node of the loop.

public class Playground{
  public static Node findBeginOfLoop(Node head){
    Node fastPtr = head;
    Node slowPtr = head;
    boolean loopExists = false;

    //To check if loop is present in the list;
    while(fastPtr != null && fastPtr.next != null){
      fastPtr = fastPtr.next.next;
      slowPtr = slowPtr.next;
      if(slowPtr == fastPtr){
        loopExists = true;
        break;
      }
    }
    if(loopExists){
      slowPtr = head;
      while(slowPtr != fastPtr){
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next;
      }
      return fastPtr;
    }
    return null;
  }
}
