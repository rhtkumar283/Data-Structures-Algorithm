//Below is the indirected graph implementation using adjacency matrix:
//Directed and undirected graphs are represented with the same structures.
//For directed graphs, everything is the same, except that each edge is represented just once.
//An edge from x to y is represented by a 1 value in Adj [ x ][ y ] in the adjacency matrix, or by adding y on x’s adjacency list.
//For weighted graphs, everything is the same, except fill the adjacency matrix with weights instead of boolean values.

import java.util.*;

//Adjacency List implementation (ArrayList):
class GraphA{
  private int vertexCount;
  private ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

  GraphA(int v){
    this.vertexCount = v;
    adjList = new ArrayList<ArrayList<Integer>>(vertexCount);
    for(int i = 0; i < vertexCount; i++)
      adjList.add(new ArrayList<Integer>());
  }

  public void addEdge(int s, int d){
    adjList.get(s).add(d);
  }

  public void topologicalSort(){
    Stack<Integer> stack = new Stack<Integer>();
    boolean[] visited = new boolean[vertexCount];
    for(int i = 0; i< vertexCount; i++)
      visited[i] = false;

      // Call the recursive helper
      // function to store
      // Topological Sort starting
      // from all vertices one by one
    for(int i = 0; i< vertexCount; i++){
      if(visited[i] == false){
        topologicalSortUtil(i, stack, visited);
      }
    }
    while (stack.empty() == false)
      System.out.print(stack.pop() + " ");
  }

  public void topologicalSortUtil(int v, Stack<Integer> stack, boolean[] visited){
    visited[v] = true;

    Iterator<Integer> itr = adjList.get(v).listIterator();
    while(itr.hasNext()){
      int i = itr.next();
      if(!visited[i]){
        topologicalSortUtil(i, stack, visited);
      }
    }
    stack.push(v);
  }

  public static void main(String[] args){

    GraphA g = new GraphA(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    g.topologicalSort();
}
}

// Adjacency matrix implementation:
// public class Graph{
//   private boolean[][] adjMatrix;
//   private int vertexCount;
//
//   Graph(int vertexCount){
//     this.vertexCount = vertexCount;
//     adjMatrix = new boolean[vertexCount][vertexCount];
//   }
//
//   //To add an Edge(i,j):
//   public void addEdge(int i, int j){
//     if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
//       adjMatrix[i][j] = true;
//       adjMatrix[j][i] = true;
//     }
//   }
//
//   //To remove an Edge(i,j):
//   public void removeEdge(int i, int j){
//     if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
//       adjMatrix[i][j] = false;
//       adjMatrix[j][i] = false;
//     }
//   }
//
//   //To see if and Edge(i,j) is present or not:
//   public boolean isEdge(int i, int j){
//     if(i >= 0 && i < vertexCount && j > 0 && j < vertexCount){
//       return adjMatrix[i][j];
//     }
//     return false;
//   }
//
//   public void printGraph(){
//     for(int i = 0; i < vertexCount; i++){
//       for(int j = 0; j < vertexCount; j++){
//         System.out.print(adjMatrix[i][j]+" ");
//       }
//       System.out.println();
//     }
//   }

  // Adjacency list implementation:
  //Comment the above adj matrix implementation if wanna run:
  public class Graph{
    int vertexCount;
    LinkedList<Integer> adjList[];

    Graph(int v){
      vertexCount = v;
      adjList = new LinkedList[v];
      for(int i = 0; i < v; i++)
        adjList[i] = new LinkedList();
    }

    public void addEdge(int s, int d){
      adjList[s].add(d);
    }
//Breadth-First traversal of a graph using adjacencyList;
    public void bfs(int s){
      boolean[] visited = new boolean[vertexCount];
      Queue<Integer> queue = new LinkedList<Integer>();
      visited[s] = true;
      queue.add(s);

      while(queue.size() != 0){
        s = queue.poll();
        System.out.print(s+" ");

        Iterator<Integer> itr = adjList[s].listIterator();
        while(itr.hasNext()){
          int n = itr.next();
          if(!visited[n]){
            visited[n] = true;
            queue.add(n);
          }
        }
      }
    }

//Depth-First traversal of a graph using adjacencyList;
public void dfs(int s){
  boolean[] visited = new boolean[vertexCount];

  dfsUtil(s, visited);
}

public void dfsUtil(int v, boolean[] visited){
  visited[v] = true;
  System.out.print(v+" ");

  Iterator<Integer> itr = adjList[v].listIterator();
  while(itr.hasNext()){
    int n = itr.next();
    if(!visited[n]) dfsUtil(n, visited);
  }
}

    public static void main(String[] args){
      // Graph graph = new Graph(4);
      // graph.addEdge(0,1);
      // graph.addEdge(0,3);
      // graph.addEdge(1,2);
      // graph.addEdge(2,0);
      // graph.addEdge(2,3);
      //
      // graph.dfs(2);

      GraphA g = new GraphA(6);
      g.addEdge(5, 2);
      g.addEdge(5, 0);
      g.addEdge(4, 0);
      g.addEdge(4, 1);
      g.addEdge(2, 3);
      g.addEdge(3, 1);

      g.topologicalSort();
  }

  //Driver method:
  // public static void main(String[] args){
  //   Graph graph = new Graph(4);
  //   graph.addEdge(0,1);
  //   graph.addEdge(0,3);
  //   graph.addEdge(1,2);
  //   graph.addEdge(2,0);
  //   graph.addEdge(2,3);

    //graph.printGraph();
  }
