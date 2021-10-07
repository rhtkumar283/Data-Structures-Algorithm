public class Practice{
  public static void main(String[] args){

  }

//HELPER FUNCTIONS//
public static int listLength(Node head){
  Node current = head;
  int length = 0;
  while(current != null){
    length += 1;
    current = current.next;
  }
  return length;
}


//1. Reverse the linked list using iterative and Recursive approach
public static Node reverseListIterative(Node head){
  if(head == null) return null;
  Node current = head;
  Node prev = null
  Node next = null
  while(current != null){
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
  }
  return prev;
}
//Recursive approach of the above problem:
public Node reverseListRecursive(Node head){
      Node current = head;
      Node prev = null;
      Node next = null;
      Node res = reverseList(current,prev,next);
      return res;
    }
public Node reverseList(Node current, Node prev, Node next){
      if(current == null){
          return prev;
        }
      else{
          next = current.next;
          current.next = prev;
          prev = current;
          current = next;
      }
      return reverseList(current, prev, next);
  }

//----------------

/*2. Given a linked list of size N. The task is to reverse every k nodes (where k is an input to
the function) in the linked list. If the number of nodes is not a multiple of k then
left-out nodes, in the end, should be considered as a group and must be reversed*/
  public static Node reverseListBlock(Node node, int k){
        if(head == null) return null;

        Node current = head;
        Node prev = null;
        Node next = null;
        int loop = 1;

        while(loop <= k && current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            loop++;
        }
        if(next != null) head.next  = reverse(next, k);
        return prev;
    }


//----------//
/*3. Given a linked list of N nodes. The task is to check if the linked list has a loop.
Linked list can contain self loop.*/
  public static boolean detectLoop(Node head){
      Node slow = head;
      Node fast = head;

      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next.next;
          if(slow == fast) return true;
      }
      return false;
  }

//--------------//
/*4. Remove the loop from the linked list, if it is present. */
public static void removeLoop(Node head){
      boolean loopExists = false;

      Node slow = head;
      Node fast = head;
      Node prev = slow;

      while(fast != null && fast.next != null){
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
          if(fast == slow){
              loopExists = true;
              break;
          }
      }
      if(loopExists){
          slow = head;
          if(fast != slow){
              while(slow != fast){
                  slow = slow.next;
                  prev = fast;
                  fast = fast.next;
              }
          }
          prev.next = null;
      }
  }

//----------------//
/*5. Find the starting of the loop in linked list if present*/
  public static Node loopStartNode(Node head){
    if(head == null) return null;

    Node slow = head;
    Node fast = head;
    boolean loopExists = false;

    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) loopExists = true;
    }
    if(loopExists){
      slow = head;
      while(slow != fast){
        slow = slow.next;
        fast = fast.next;
      }
      return fast;
    }
    return null;
  }


//--------------
/*6. Given a sorted singly linked list consisting of N nodes. The task is to remove duplicates
(nodes with duplicate values) from the given list (if exists). */
public static Node removeDuplicates(Node head){
    Node current = head;
    //{11->11->12->13->14->15->15}
    while(current != null){
      Node temp = current;

      while(temp != null && temp.data == current.data){
        temp = temp.next;
      }
      current.next = temp;
      current = current.next;
    }
    return head;
}


//-----------------//
/*7. Given an unsorted linked list of N nodes. The task is to remove duplicate elements
from this unsorted Linked List. When a value appears in multiple nodes, the node which
appeared first should be kept, all others duplicates are to be removed.*/

public Node removeDuplicates(Node head)
{
  if(head == null || head.next == null) return head;

   HashSet<Integer> hSet = new HashSet<Integer>();
   Node current = head;
   Node prev = null;

   while(current != null){
       if(hSet.contains(current.data)){
           prev.next = current.next;
       }else{
           hSet.add(current.data);
           prev = current;
       }
       current = current.next;
   }
   return head;
}

//---------------
/*8. A number N is represented in Linked List such that each
 digit corresponds to a node in linked list. You need to add 1 to it.*/

 public static Node addOne(Node head){
        if(head == null) return null;

        Node current = head, prev = null, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        Node l1 = head;
        int val = 0;
        int carry = 0;
        int one = 1;
        int s = 0;
        while(l1 != null){
            val = l1.data;
            s = val + one + carry;
            carry = 0;
            one = 0;
            if(s > 9){
                carry = 1;
                l1.data = s % 10;
            }else{
                l1.data = s;
            }
            prev = l1;
            l1 = l1.next;
        }
        if(carry != 0) prev.next = new Node(carry);
        current = head;
        prev = null;
        next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

//---------------//
/*9. Given two numbers represented by two linked lists of size N and M.
The task is to return a sum list. */
//Function to add two numbers represented by linked list.

  static Node addTwoLists(Node first, Node second){
      if(first == null) return second;
      if(second == null) return first;

      Node l1 = reverseListIterative(first);
      Node l2 = reverseListIterative(second);
      Node ans = new Node(0);
      Node temp = ans;

      int v1,v2 = 0;
      int sum, carry = 0;
      while(l1 != null || l2 != null){
        v1 = (l1 == null) ? 0 : l1.data;
        v2 = (l2 == null) ? 0 : l2.data;

        sum = l1 + l2 + carry;
        temp.next = new Node(sum % 10);
        temp = temp.next;
        carry = sum /10;

        if(l1 != null) l1 = l1.next;
        if(l2 != null) l2 = l2.next;
      }
      if(carry != 0){
        temp.next = new Node(carry);
      }
      Node res = reverseListIterative(ans.next);
      return res;
  }

//------------------//
/*10. Given two lists sorted in increasing order, create a new list representing
the intersection of the two lists. The new list should be made with its own memory —
the original lists should not be changed.
Note: The list elements are not necessarily distinct.*/

public static Node findIntersection(Node head1, Node head2){
        int length1 = listLength(head1);
        int length2 = listLength(head2);

        if(length1 == 0 || length2 == 0) return null;

        Node current = (length1 > length2) ? head2 : head1;
        Node ans = new Node(0);
        Node res = ans;
        while(current != null){
            Node temp = (length1 > length2) ? head1 : head2;
            while(temp != null && temp.data != current.data){
                temp = temp.next;
            }
            if(temp != null){
                ans.next = new Node(temp.data);
                ans = ans.next;
            }
            current = current.next;
        }
        return res.next;
    }

//-----------------//
/*11. Given two singly linked lists of size N and M, write a program
to get the point where two linked lists intersect each other. */
public static int intersectPoint(Node head1, Node head2)
{
    HashSet<Node> set1 = new HashSet<>();
    Node temp = head1;
    while(temp != null){
        set1.add(temp);
        temp = temp.next;
    }
    Node current = head2;
    while(current != null){
        if(set1.contains(current)) return current.data;
        current = current.next;
    }

      // int length1 = listLength(head1);
      // int length2 = listLength(head2);

      // int k = (length1 > length2) ? length1 - length2 : length2 - length1;

      // Node temp = (length1 > length2) ? head1 : head2;

      // for(int i = 0; i < k; i++){
      //     temp = temp.next;
      // }

      // Node p1 = temp;
      // Node p2 = (temp == head1) ? head2 : head1;

      // while(p1 != null && p2 != null){
      //     if(p1.data == p2.data) return p1.data;
      //     p1 = p1.next;
      //     p2 = p2.next;
      // }
       return -1;
  }


//------------------//
/*12. Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.*/
public ListNode middleNode(ListNode head){
      int length = 0;
      ListNode current = head;
      while(current != null){
          length += 1;
          current = current.next;
      }
      int res = (length /2)+1;
      length = 1;
      current = head;
      while(length != res){
          current = current.next;
          length += 1;
      }
      return current;
  }

//---------------------//
/*13. Given head, the head of a singly linked list, find if the linked list is circular or not.
A linked list is called circular if it not NULL terminated and all nodes are connected in the
form of a cycle. An empty linked list is considered as circular.*/
boolean isCircular(Node head)
  {
    if(head.next == head || head == null) return true;
    Node current = head;

      while(current.next != head && current.next != null ){
          current = current.next;
      }
    return (current.next == head) ? true : false;
  }

//------------------//
/*14.Given a singly linked list of size N of integers.
The task is to check if the given linked list is palindrome or not. */
  public static boolean isPalindrome(Node head) {
    Stack<Integer> stack = new Stack<>();
    int length = 0;
    Node current = head;
    while(current != null) {
        length += 1;
        current = current.next;
    }
    current = head;
    int loop = 0;
    while(loop < length/2){
        stack.push(current.data);
        current = current.next;
        loop+=1;
    }
    if(length % 2 != 0) current = current.next;
    while(current != null){
        int top = stack.pop();
        if(top != current.data) return false;
        current = current.next;
    }
    return true;
  }

/*15. Given a doubly linked list of n elements. The task is to reverse
the doubly linked list.*/
  public static Node reverseDLL(Node head){
    if(head.next == null || head == null) return head;

    Node current = head;
    Node next, res, temp;

    while(current != null){
      temp = current.next;
      current.next = current.prev;
      current.prev = temp;
      res = current;
      current = temp;
    }
    return res;
  }

/*16. Find pairs with given sum in doubly linked list. (Sorted)*/
  public static void pairSumDll(Node head, int target){
    Node first = head;
    Node last = head;
    int sum = 0;
    while(last.next != null) last = last.next;

    while(first != last){
      sum = first.data + last.data;
      if(sum == target){
        System.out.println(first.data + " " + last.data);
        first = first.next;
        last = last.prev;
      }
      else if(sum > target) last = last.prev;
      else first = first.next;
    }
  }

/*17. Rotate Doubly linked list by N nodes*/


 }
