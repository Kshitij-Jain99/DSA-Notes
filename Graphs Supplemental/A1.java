import java.util.*;

public class A1 {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

public static void createGraph(ArrayList<Edge>[] graph) {
    for(int i=0; i<graph.length; i++) {
        graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0,2));
    graph[0].add(new Edge(0,3));

    graph[1].add(new Edge(1,0));

    graph[2].add(new Edge(2,1));
    
    graph[3].add(new Edge(3,4));
  }

  public static void topSort(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
    vis[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]) {
            topSort(graph, e.dest, vis, s);
        }
    }
    s.push(curr);
  }

  public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
    vis[curr] = true;
    System.out.println(curr+"");

    for(int i=0; i<graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if(!vis[e.dest]) {
            dfs(graph, e.dest, vis);
        }
    }
  }

  public static void kosaraju(ArrayList<Edge> graph[], int V) {
    //Step-1
    Stack<Integer> s =new Stack<>();
    boolean vis[] = new boolean[V];
    for(int i=0; i<V; i++) {
        if(!vis[i]) {
            topSort(graph, i, vis,s);
        }
    }

    //Step-2
    ArrayList<Edge>[] transpose = (ArrayList<Edge>[]) new ArrayList[V];
    for(int i=0; i<graph.length; i++) {
        transpose[i] = new ArrayList<>();
    }

    for(int i=0; i<V; i++) {
        for(int j=0; j<graph[i].size(); j++) {
            Edge e = graph[i].get(j);   //e.src  -> e.dest
            transpose[e.dest].add(new Edge(e.dest, e.src));   //reverse edge
    }
  }

  //step-3
  Arrays.fill(vis, false);  // Reset visited array
  while(!s.isEmpty()) {
    int curr = s.pop();
    if(!vis[curr]) {
        System.out.println("SCC->");
        dfs(transpose, curr, vis); //scc
        System.out.println();
    }
    }
  }

  public static void main(String args[]) {
    int V = 5;
    ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
    createGraph(graph);

    kosaraju(graph, V);
  }
}
/*
ArrayList<Edge>[] graph = (ArrayList<Edge>[]) new ArrayList[V];
ArrayList<Edge>[] transpose = (ArrayList<Edge>[]) new ArrayList[V];
The warnings you're seeing are related to the use of generics in array creation. 
Java doesn't allow the direct creation of arrays with generic types, such as ArrayList<Edge>[].
To address this, you need to create the array using a workaround with casting.

 */