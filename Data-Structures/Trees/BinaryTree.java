import java.io.*;
import java.util.*;

public class BinaryTreeNode{
  int data;
  BinaryTreeNode left, right;

  BinaryTreeNode(int data){
    this.data = data;
    this.left = null;
    this.right = null;
  }

  public static void main(String[] args){
    BinaryTree bTree = new BinaryTree();
    BinaryTreeNode root = bTree.insert(1);
    root.left = new BinaryTreeNode(2);
    root.right = new BinaryTreeNode(3);
    root.left.left = new BinaryTreeNode(4);
    root.left.right = new BinaryTreeNode(5);
    root.right.left = new BinaryTreeNode(6);
    root.right.right = new BinaryTreeNode(7);
    //bTree.insertInTree(root, 8);
    // System.out.println("PreOrder Traversal:");
    // bTree.preOrder(root);
    List<Integer> r = new ArrayList<Integer>();
    r = bTree.levelOrder(root);
    for(int s : r){
      System.out.print(s+" ");
    }
    //int height = treeHeight(root);
    System.out.println("\n\nHeight of the tree : "+ bTree.treeHeight(root));
    System.out.println("Max of the tree : "+ bTree.maxElement(root));
    System.out.println("Element present or not : "+ bTree.searchBinaryTreeRecursive(root, 20));
    System.out.println("Size of the tree : "+ bTree.sizeOfTreeIterative(root));
    //bTree.reverseLevelOrder(root);
    System.out.println("Diameter of the tree : "+ bTree.diameter(root));
    System.out.println("Levels of the tree : "+ bTree.levelsBinaryTree(root));
    System.out.println("Width of the tree : "+ bTree.widthBinaryTree(root));
    bTree.binaryTreePaths(root);

    // System.out.println("\nInOrder Traversal:");
    // bTree.inOrder(root);
    // System.out.println("\nPostOrder Recursive Traversal:");
    // bTree.postOrder(root);
    // System.out.println("\nPostOrder Iterative traversal using 2 stacks: ");
    // bTree.postOrderIterative(root);
  }
}

class BinaryTree{
  BinaryTreeNode root;

  //Inserting a node in the tree;
  public BinaryTreeNode insert(int data){
    BinaryTreeNode new_node = new BinaryTreeNode(data);

    if(root == null){
      root = new_node;
      return root;
    }
    return new_node;
  }

  //Recursive PreOrder Traversal
  public void preOrder(BinaryTreeNode root){
    if(root != null){
      System.out.print(root.data +" ");
      preOrder(root.left);
      preOrder(root.right);
    }
  }

  //Iterative preOrder Traversal;
  public List<Integer> preOrderIterative(BinaryTreeNode root){
    List<Integer> res = new ArrayList<Integer>();
    if(root == null){
      return res;
    }
    Stack<BinaryTreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
      BinaryTreeNode temp = stack.pop();
      res.add(temp.data);
      if(temp.right != null){
        stack.push(temp.right);
      }
      if(temp.left != null){
        stack.push(temp.left);
      }
    }
    return res;
  }

  //Inorder Recursive:
  public void inOrder(BinaryTreeNode root){
    if(root == null) return;

    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);
  }

  //Inorder Iterative - 1st Method: O(n)
  public List<Integer> inOrderIterative(BinaryTreeNode root){
    List<Integer> res = new ArrayList<Integer>();
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    if(root == null) return res;
    BinaryTreeNode current = root;
    while(!stack.isEmpty() || current != null){
      while(current != null){
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      res.add(current.data);

      current = current.right;
    }
    return res;
  }

  //Inorder Iterative - 2nd Method: O(n)
  public List<Integer> inOrderIterative2(BinaryTreeNode root){
    List<Integer> res = new ArrayList<Integer>();
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    BinaryTreeNode curr = root;
    boolean done = false;
    while(!done){
        if(curr != null){
          stack.push(curr);
          curr = curr.left;
        }
        else{
          if(stack.isEmpty()){
            done = true;
          }else{
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
          }
        }
    }
    return res;
  }

  //PostOrder Recursive:
  public void postOrder(BinaryTreeNode root){
    if(root == null) return;
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data+" ");
  }

  //postOrder Iterative: 1st method(Using two stacks)
  public void postOrderIterative(BinaryTreeNode root){
    Stack<BinaryTreeNode> stack1 = new Stack<BinaryTreeNode>();
    Stack<BinaryTreeNode> stack2 = new Stack<BinaryTreeNode>();

    if(root == null) return;
    stack1.push(root);

    while(!stack1.isEmpty()){
      BinaryTreeNode temp = stack1.pop();
      stack2.push(temp);
      if(temp.left != null) stack1.push(temp.left);
      if(temp.right != null) stack1.push(temp.right);
    }

    while(!stack2.isEmpty()){
      BinaryTreeNode temp = stack2.pop();
      System.out.print(temp.data+" ");
    }
  }

  //postOrder Iterative: 2nd method(Using one stacks)
  public void postOrderIterative2(BinaryTreeNode root){
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    if(root == null) return;

    while(root != null){
      if(root.right != null) stack.push(root.right);
      stack.push(root);
      root = root.left;
    }
    while(!stack.isEmpty()){
      root = stack.pop();
      if(root.right != null && root.right == stack.peek()){
        stack.pop();
        stack.push(root);
        root = root.right;
      }else{
        System.out.println(root.data+" ");
        root = null;
      }
    }
  }

  //Height of a tree:
  public static int treeHeight(BinaryTreeNode root){
    if(root == null) return 0;
    else{
      int lheight = treeHeight(root.left);
      int rheight = treeHeight(root.right);

      if(lheight > rheight){
        return (lheight + 1);
      }else{
        return (rheight + 1);
      }
    }
  }

  //Levels in a BinaryTree:
  public int levelsBinaryTree(BinaryTreeNode root){
    if(root == null) return 0;
    return Math.max(levelsBinaryTree(root.left), levelsBinaryTree(root.right)) + 1;
  }

  //Level order traversal:
  public List<Integer> levelOrder(BinaryTreeNode root){
    List<Integer> res = new ArrayList<Integer>();
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode temp = queue.poll();
      res.add(temp.data);
      if(temp != null  && temp.left != null) queue.add(temp.left);
      if(temp != null  && temp.right != null) queue.add(temp.right);
    }
    return res;
  }

  //an algorithm for finding maximum element in binary tree.
  public int maxElementInTree(BinaryTreeNode root){
    int maxValue = 0;
    if(root == null) return 0;
    int leftMax = maxElementInTree(root.left);
    int rightMax = maxElementInTree(root.right);

    if(leftMax > rightMax) maxValue = leftMax;
    else maxValue = rightMax;

    if(maxValue < root.data) maxValue = root.data;
    return maxValue;
  }

  //Above problem without recursion:
  public int maxElement(BinaryTreeNode root){
    int maxValue = 0;
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode temp = queue.poll();
      if(temp.data > maxValue) maxValue = temp.data;
      if(temp != null  && temp.left != null) queue.add(temp.left);
      if(temp != null  && temp.right != null) queue.add(temp.right);
    }
    return maxValue;
  }

  //an algorithm for searching an element in binary tree.
  public boolean searchBinaryTree(BinaryTreeNode root, int data){
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode temp = queue.poll();
      if(temp.data == data) return true;
      if(temp != null  && temp.left != null) queue.add(temp.left);
      if(temp != null  && temp.right != null) queue.add(temp.right);
    }
    return false;
  }
  //Above problem with recursion:
  public boolean searchBinaryTreeRecursive(BinaryTreeNode root, int data){
    if(root == null) return false;
    if(root.data == data) return true;
    boolean left = searchBinaryTreeRecursive(root.left,data);
    boolean right = searchBinaryTreeRecursive(root.right,data);
    return (left || right);
  }

  //Inserting an element in binary tree;
  public void insertInTree(BinaryTreeNode root, int data){
    if(root == null){
      root = new BinaryTreeNode(data);
      return;
    }

    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode temp = queue.poll();
      if(temp.left == null){
        temp.left = new BinaryTreeNode(data);
        return;
      }else if(temp.right == null){
        temp.right = new BinaryTreeNode(data);
        return;
      }
      if(temp != null  && temp.left != null) queue.add(temp.left);
      if(temp != null  && temp.right != null) queue.add(temp.right);
    }
  }

  //Size of the binary tree:
  public int sizeOfTree(BinaryTreeNode root){
    if(root == null) return 0;
    int lsize = sizeOfTree(root.left);
    int rsize = sizeOfTree(root.right);
    return lsize+rsize+1;
  }
  //Above problem in iterative:
  public int sizeOfTreeIterative(BinaryTreeNode root){
    int size = 0;
    if(root == null) return 0;
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode temp = queue.poll();
      if(temp != null) size++;
      if(temp != null  && temp.left != null) queue.add(temp.left);
      if(temp != null  && temp.right != null) queue.add(temp.right);
    }
    return size;
  }

  //Deleting BinaryTree:
  public void deleteBinaryTree(BinaryTreeNode root){
    root = null; //In java, it will be taken care by garbage collector;
  }

  //Printing level order traversal in reverse order;
  public void reverseLevelOrder(BinaryTreeNode root){
    if(root == null) return;
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode temp = queue.poll();
      if(temp != null  && temp.right != null) queue.add(temp.right);
      if(temp != null  && temp.left != null) queue.add(temp.left);

      stack.push(temp);
    }
    while(!stack.isEmpty()){
      BinaryTreeNode temp = stack.pop();
      System.out.print(temp.data+" ");
    }
  }

  //To find the deepest node in a binary tree:
  //In level order traversal the last node processed from queue is the
  //deepest node of the tree;

  //Diameter of the BinaryTree using recursion:
  public int diameter(BinaryTreeNode root){
    if(root == null) return 0;
    int lheight = treeHeight(root.left);
    int rheight = treeHeight(root.right);

    int lDiameter = diameter(root.left);
    int rDiameter = diameter(root.right);

    int max = Math.max(1+lheight+rheight, Math.max(lDiameter,rDiameter));
    return max;
  }

  //Width of the BinaryTree:
  public int widthBinaryTree(BinaryTreeNode root){
    int max = 0;
    int height = treeHeight(root);
    for(int i = 0; i < height; i++){
      int temp = width(root, i);
      if(temp > max) max = temp;
    }
    return max;
  }

  //Returns the number of nodes on a given level:
  public int width(BinaryTreeNode root, int level){
    if(root == null) return 0;
    if(level == 0) return 1;
    return width(root.left, level-1) + width(root.right, level-1);
  }

  //Printing all the paths from root to leaves:
  public void binaryTreePaths(BinaryTreeNode root){
    int[] array = new int[256];
    binaryTreePaths(root, array, 0);
  }
  public void binaryTreePaths(BinaryTreeNode root, int[] array, int pathLen){
    if(root == null) return;
    array[pathLen] = root.data;
    pathLen++;
    if(root.left == null && root.right == null){
      printArray(array, pathLen);
    }
    else{
      binaryTreePaths(root.left, array, pathLen);
      binaryTreePaths(root.right, array, pathLen);
    }
  }
  public void printArray(int[] array, int length){
    for(int i = 0; i< length; i++){
      System.out.print(array[i]+" ");
    }
    System.out.println();
  }
}
