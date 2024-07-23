package Graphs;

import java.util.*;


class Node{

    int node;
    int degree;

    Node(){}

    Node(int n, int d){
        this.degree =d;
        this.node = n;
    }
}

public class GraphUsingAdjList {

    int[] inDegree ;
    int V;
    List<Integer> adjList[];

    public int getV() {
        return V;
    }

    public List<Integer>[] getAdjList() {
        return adjList;
    }

    GraphUsingAdjList(int V){
        this.V = V;
        this.adjList = new  LinkedList[V];
        this.inDegree = new int[V];
        for(int i=0; i<V; i++){
            inDegree[i] = 0;
            adjList[i] = new LinkedList<>();
        }
    }

    @Override
    public String toString() {
        return "GraphUsingAdjList{" +
                "V=" + V +
                ", adjList=" + Arrays.deepToString(adjList) +
                '}';
    }

    void addEdge(int u, int v, boolean undirected){

        adjList[u].add(v);
        if(undirected){
            adjList[v].add(u);
        }
    }

    public void findInDegree(){

        for(int i=0 ; i<V; i++){
            for(int j : adjList[i]){
                inDegree[j]++;
            }
        }
    }

    public List<Integer> getTopoPath(){

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.degree > o2.degree ? 1 : -1;
            }
        });

        Node[] nodes = new Node[V];

        int p=0;
        for(int i : inDegree){
            nodes[p] = new Node(p,i);
            pq.add(nodes[p]);
            p=p+1;
        }

        for(int k=0; k<V; k++) {
            Node node = pq.peek();
            pq.remove(node);
            ans.add(node.node);
            for (int j : adjList[node.node]) {
                pq.remove(nodes[j]);
                nodes[j] = new Node(j, nodes[j].degree-1);
                pq.add(nodes[j]);
            }
        }
        return ans;
    }


    /*
    * A-0, B-1, C-2, D-3, E-4, F-5
    * A-B
    * B-E
    * A-C
    * C-E
    * F-D
    * D-E
    * C-D
    * */

    public static void main(String[] args) {

        GraphUsingAdjList g = new GraphUsingAdjList(6);
        g.addEdge(0,1,false);
        g.addEdge(1,4,false);
        g.addEdge(0,2,false);
        g.addEdge(2,4,false);
        g.addEdge(5,3,false);
        g.addEdge(3,4,false);
        g.addEdge(2,3,false);

        g.findInDegree();
        System.out.println(g.getTopoPath());

    }

}
