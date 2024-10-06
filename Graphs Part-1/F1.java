import java.util.*;

public class F1 {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {  //TC = O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.print(curr + " "); // Changed println to print for formatting
                vis[curr] = true;

                if (graph[curr] != null) {
                    for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i);
                        if (!vis[e.dest]) {
                            q.add(e.dest);
                        }
                    }
                }
            }
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        int V = graph.length;

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void main(String args[]) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
