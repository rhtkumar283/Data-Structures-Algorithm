public class Dijsktra{
  static class Edge{
    int source;
    int destination;
    int weight;

    Edge(int source, int destination, int weight){
      this.source = source;
      this.destination = destination;
      this.weight = weight;
    }
  }

  static class Graph{
    int vertexCount;
    LinkedList<Edge>[] adjList;

    Graph(int vertexCount){
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];

        for(int i = 0; i < vertexCount; i++){
          adjList[i] = new LinkedList<Edge>();
        }
    }
  }

  public void addEdge(int source, int destination, int weight){
    Edge edge = new Edge(source, destination, weight);
    adjList[source].addFirst(edge);

    edge = new Edge(destination, source, weight);
    adjList[destination].addFirst(source); //for undirected graph
  }

  public void dijsktra_GetMinDistance(int sourceVertex){
    boolean[] SRT = new boolean[vertexCount];
    int[] distance = new int[vertexCount];

    //Initilaize all distances to infinity;
    for(int i = 0; i < vertexCount; i++){
      distance[i] = Integer.MAX_VALUE;
    }

    PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(vertexCount, new Comparator<Pair<Integer, Integer>>(){
      @Override
      public int compare(Pair<Integer, Integer> p1, pair<Integer, Integer> p2){
        int key1 = p1.getKey();
        int key2 = p2.getKey();
        return key1 - key2;
      }
    });



  }
}
