class BinaryTreeNode{
  int data;
  BinaryTreeNode left, right;

  BinaryTreeNode(int data){
    this.data = data;
    this.left = null;
    this.left = null;
  }
}

public class BinarySearchTree{
  BinaryTreeNode root;

  public static BinaryTreeNode createRootNode(int data){
    if(data == null) return;
    else if(root != null) {
      System.out.println("Root already present!");
      return;
    }
    BinaryTreeNode new_node = new BinaryTreeNode(data);
    root = new_node;
    return root;
  }

  //Finding an element in BST:
  public BinaryTreeNode find(BinaryTreeNode root, int data){
    if(root == null) return null;
    if(data > root.data){
      return find(BinaryTreeNode root.right, data);
    }else if(data < root.data){
      return find(BinaryTreeNode root.left, data);
    }
    return root;
  }

  //Finding the minimum node in BST:
  //1. Recursive:
  public BinaryTreeNode findMinimumRecursive(BinaryTreeNode root){
    if(root == null) return null;
    else if(root.left == null) return root;
    else return findMinimumRecursive(root.left);
  }
  //2. Non-Recursive:
  public BinaryTreeNode findMinimumIterative(BinaryTreeNode root){
    if(root == null) return null;
    while(root.left != null){
      root = root.left;
    }
    return root;
  }

  //Find the maximum node in BST:
  //1. Recursive:
  public BinaryTreeNode findMaxRecursive(BinaryTreeNode root){
    if(root == null) return null;
    if(root.right == null) return root;
    else return findMaxRecursive(root.right);
  }
  //2. Non-Recursive:
  public BinaryTreeNode findMaxIterative(BinaryTreeNode root){
    if(root == null) return null;
    while(root.right != null) root = root.right;
    return root;
  }

  //Inserting an element in BST:
  //1. Recursive:
  public BinaryTreeNode insert(BinaryTreeNode root, int data){
    if(root == null){
      root = new BinaryTreeNode(data);
      return root;
    }else{
      if(data <= root.data) root.left = insert(root.left, data);
      else if(data > root.data) root.right = insert(root.right,data);
    }
    return root;
  }
  //2. Non-Recursive:
  public BinaryTreeNode insertIterative(BinaryTreeNode root, int data){
    if(root == null){
      root = new BinaryTreeNode(data);
      return root;
    }else{
      while(root.left != null || root.right != null){
        if(data <= root.data){
          root = root.left;
        }else{
          if(data > root.data){
            root = root.right;
          }
        }
      }
      if(root.left == null) root.left = new BinaryTreeNode(data);
      else if(root.right == null) root.right = new BinaryTreeNode(data);
      }
      return root;
    }
  }
}
