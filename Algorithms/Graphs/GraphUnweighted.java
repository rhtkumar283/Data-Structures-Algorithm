import java.util.*;

public class GraphUnweighted{
  int vertexCount;
  ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

  GraphUnweighted(int v){
    this.vertexCount = v;
    adjList = new ArrayList<ArrayList<Integer>>(vertexCount);
    for(int i = 0; i < vertexCount; i++)
      adjList.add(new ArrayList<Integer>());
  }

  public void addEdgeUndirected(int s, int d){
    adjList.get(s).add(d);
    adjList.get(d).add(s);
  }
  public void addEdgeDirected(int s, int d){
    adjList.get(s).add(d);
  }

  public void printShortestDistance(int s, int d){
    int pred[] = new int[vertexCount];
    int dist[] = new int[vertexCount];

    if(!BFS(s, d, dist, pred)){
      System.out.println("Given source & destination are not connected!");
      return;
    }

    LinkedList<Integer> path = new LinkedList<Integer>();
    int crawl = d;
    path.add(crawl);
    while(pred[crawl] != -1){
      path.add(pred[crawl]);
      crawl = pred[crawl];
    }
    System.out.println("Shortest path length is -> "+ dist[d]);

    for(int i = path.size()-1; i >= 0; i--){
      System.out.print(path.get(i)+" ");
    }
  }

  public boolean BFS(int s, int d, int[] dist, int[] pred){
    Queue<Integer> queue = new LinkedList<Integer>();
    boolean[] visited = new boolean[vertexCount];
    for(int i = 0; i < vertexCount; i++){
      visited[i] = false;
      dist[i] = Integer.MAX_VALUE;
      pred[i] = -1;
    }

    visited[s] = true;
    dist[s] = 0;
    queue.add(s);
    while(!queue.isEmpty()){
      int u = queue.remove();
      Iterator<Integer> itr = adjList.get(u).listIterator();
      while(itr.hasNext()){
        int n = itr.next();
        if(!visited[n]){
          visited[n] = true;
          dist[n] = dist[u] + 1;
          pred[n] = u;
          queue.add(n);

          if(n == d){
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args){
    GraphUnweighted g = new GraphUnweighted(8);
    // g.addEdgeUndirected(0,1);
    // g.addEdgeUndirected(0,3);
    // g.addEdgeUndirected(1,2);
    // g.addEdgeUndirected(3,4);
    // g.addEdgeUndirected(3,7);
    // g.addEdgeUndirected(4,5);
    // g.addEdgeUndirected(4,6);
    // g.addEdgeUndirected(4,7);
    // g.addEdgeUndirected(5,6);
    // g.addEdgeUndirected(6,7);

    g.addEdgeDirected(0,1);
    g.addEdgeDirected(0,3);
    g.addEdgeDirected(1,3);
    g.addEdgeDirected(1,4);
    g.addEdgeDirected(2,0);
    g.addEdgeDirected(2,5);
    g.addEdgeDirected(3,5);
    g.addEdgeDirected(3,6);
    g.addEdgeDirected(4,6);
    g.addEdgeDirected(6,5);
    int source = 2;
    int dest = 4;
    g.printShortestDistance(source, dest);
  }
}
