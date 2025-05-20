import java.util.*;

public class C1 {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt =w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));
        
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

    }

    static class Pair implements Comparable<Pair> {
        int n;  //node
        int path; //shortest path int

        public Pair(int n, int path) { //constructor
            this.n = n;
            this.path = path;
        }

        @Override  //comparTo fxn ko override karna padta hai , because abhi tak object ko compare karne k parameters[node or path] nhi bataye
        public int compareTo(Pair p2) {
            return this.path - p2.path; //jo value small hogi vo pehele return; path based sorting for pairs(increasing order)
        }
    }


    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];  //dist[i] -> src to i
        for(int i=0; i<graph.length; i++) {
            if(i!=src) {
                dist[i] = Integer.MAX_VALUE;  //initialze all to INFINITY, ex: src
            }
        }

        boolean vis[] = new boolean[graph.length]; //all initially not visited

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));  //first pair
        //loop-BFS
        while(!pq.isEmpty()) { 
            Pair curr = pq.remove(); //shortest dist pair get removed first
            if(!vis[curr.n]) {  //only for not visited
                vis[curr.n] = true;
                //neighbour
                for(int i=0; i<graph[curr.n].size(); i++){   // curr is pair value, curr.n have idx stored which is req. here
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] + wt < dist[v]){ //update dist of src to v
                        dist[v]  = dist[u] + wt;
                        pq.add(new Pair(v, dist[v])); //add to queue
                    }
                }
            }

        }

        //print all src to vertices shortest path
        for(int i =0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();

    }

    public static void main(String args[]) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}

