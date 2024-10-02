import java.util.*;

public class A1 {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int wt) {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static ArrayList<Edge>[] createGraph(int flights[][], int n) {
        //create empty ArrayList at each node of graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
        return graph;
    }

    static class Info{
        int v;
        int cost;
        int stops;

        public Info(int v, int c, int s) {
            this.v =v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        //1-Creating graph using information of flights
        ArrayList<Edge> graph[] = createGraph(flights, n);
        
        int dist[] = new int[n];
        for(int i=0; i<n; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
         //2
        Queue<Info> q = new LinkedList<>(); 
        q.add(new Info(src,0,0));

        while(!q.isEmpty()) {
            Info curr = q.remove();
            if(curr.stops > k) {
                break;
            }
                //neighbours
            for(int i=0; i<graph[curr.v].size(); i++) {        //
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;
                  //relaxation
                /* Before-wrong
                if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v] && curr.stops <= k) {  
                    dist[v] = dist[u] + wt;
                    q.add(new Info(v,dist[v], curr.stops+1));
                  }
                    */
                    if(curr.cost+wt < dist[v] && curr.stops <= k) {  
                        dist[v] = curr.cost + wt;
                        q.add(new Info(v,dist[v], curr.stops+1));
                    }
            }
        }

        //3-dist[dest]
        if(dist[dest] == Integer.MAX_VALUE) {
            return -1;
        } else{
            return dist[dest];
        }

    }
    
    public static void main(String args[]) {
        int n = 4;
        int flights[][] = {{0,1,100},{1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dest = 3, k = 1;

        int result = cheapestFlight(n, flights, src, dest, k);
        System.out.println("Cheapest Flight Cost: " + result);
        
    }
    
}
