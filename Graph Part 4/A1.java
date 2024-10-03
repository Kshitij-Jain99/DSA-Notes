import java.util.*;

public class A1 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge (int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt =w;
        }
    }

    // static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i=0; i<graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0,1,2));
    //     graph[0].add(new Edge(0,2,4));

    //     graph[1].add(new Edge(1,2,-4));

    //     graph[2].add(new Edge(2,3,2));

    //     graph[3].add(new Edge(3,4,4));

    //     graph[4].add(new Edge(4,1,-1));
    // }

    //Alternative way to create Graph
    static void createGraph2(ArrayList<Edge> graph) {
        
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));

        graph.add(new Edge(1,2,-4));

        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));

        graph.add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {   //replaced for graph2->graph[] and int V added
        int dist[] = new int[V];                            //replaced for graph2->graph.length
        //Alternative : Arrays.fill(dist, Integer.MAX_VALUE);
        // dist[src] =0;

        for(int i=0; i<dist.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        //Not required for graph2:: int V = graph.length;
        //algo-> TC=O(V*E)
        for(int i=0; i<V-1; i++) {//TC=O(V)
            //TC=O(E)
            //edges-Using 2 nested loops to work on whole graph here
            // TC-o(E) i.e. no of edges, it does not depend on number of loops
            // for(int j=0; j<graph.length; j++) { //for vertices
            //     for(int k=0; k<graph[j].size(); k++) {  //for edges of a vertex
                   
                    //Two loops are not needed for graph2
                    for(int j=0; j<graph.size(); j++) {
                    Edge e = graph.get(j);                   //replaced for graph2->graph[j].get(k)
                    //u,v, wt-->no need to define them , written here for understanding
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    //relaxtion
                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt<dist[v]) { //any Integer added to "Integer.MAX_VALUE" will change the value into a negative value
                        dist[v] = dist[u]+wt;
                    }
                }
            }


        //pri nt 
        for(int i=0; i<dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int V=5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        ArrayList<Edge> graph2 = new ArrayList<>();
        createGraph2(graph2);
        bellmanFord(graph2, 0, V);  //V added for graph2
    }
}
