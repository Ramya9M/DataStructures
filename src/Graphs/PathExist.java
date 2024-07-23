package Graphs;


import java.util.*;

public class PathExist {

    static class Pair{
        int y;
        int w;
        Pair(int y, int w){
            this.y = y;
            this.w = w;
        }
    }
    static class Graph{

        int v;
        List<Pair> adj[];

        int[] vis;

        Graph(int n, int[][] edges, int m){

             v = n;
             adj = new List[m];

             for(int i=0; i<m; i++)
                 adj[i] = new ArrayList<>();

             for(int[] e : edges){
                 adj[e[0]].add(new Pair(e[1], e[2]));
                 adj[e[1]].add(new Pair(e[0], e[2]));
             }
        }

    }

    public static boolean detectCycle(){


        return false;

    }

    public static void dfs(){


    }

    public static void shortestPath(Graph graph){

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.w-y.w);

        int v = graph.v;
        int[] dist = new int[v];

        for(int i=0; i<v; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[0] = 0;
        pq.add(new Pair(0,0));

        List<Pair> adj[] = graph.adj;

        while(!pq.isEmpty()){

            int n = pq.peek().y;
            int d = pq.peek().w;
            pq.remove();

            for(int i=0; i<adj[n].size(); i++){

                int w  = adj[n].get(i).w;
                int nd = adj[n].get(i).y;

                if(w+d < dist[nd]) {
                    dist[nd] = w + d;
                    pq.add(new Pair(nd,dist[nd]));
                }
            }
        }

        for(int i=0; i<v; i++)
            System.out.println(dist[i]);


    }

    public static void main(String args[]){

        int n = 5;
        int[][] edges = new int[8][3];
        Scanner value = new Scanner(System.in);
        for(int i=0; i<8; i++){
            for(int j=0; j<3; j++){
                System.out.println("enter the value");
                edges[i][j] = value.nextInt();
            }
        }

        for(int i=0; i<8; i++){
            for(int j=0; j<3; j++){
                System.out.print(edges[i][j]);
            }
            System.out.println();
        }

        Graph graph = new Graph(6, edges, 8);
        shortestPath(graph);
    }

}
