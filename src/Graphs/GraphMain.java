package Graphs;

public class GraphMain {

    public static void main(String args[]) {

//        GraphUsingEdgeList g1 = new GraphUsingEdgeList(4);
//        g1.addEdge(0, 1, 10);
//        g1.addEdge(0, 2, 20);
//        g1.addEdge(1, 2, 30);
//        g1.addEdge(2, 0, 40);
//        g1.addEdge(2, 3, 50);
//        g1.addEdge(3, 3, 60);
//        System.out.println(g1);
//
//        GraphUsingAdjMatrix g2 = new GraphUsingAdjMatrix(4);
//        g2.addEdge(0, 1);
//        g2.addEdge(0, 2);
//        g2.addEdge(1, 2);
//        g2.addEdge(2, 0);
//        g2.addEdge(2, 3);
//        g2.addEdge(3, 3);
//        System.out.println(g2);

        GraphUsingAdjList g3 = new GraphUsingAdjList(7);
        g3.addEdge(0,1,true);
        g3.addEdge(0,2,true);
        g3.addEdge(2,3,true);
        g3.addEdge(3,6,true);
        g3.addEdge(2,4,true);
        g3.addEdge(4,6,true);
        g3.addEdge(1,4,true);
        g3.addEdge(4,5,true);
        System.out.println(g3);

//        BFS bfs = new BFS();
//        bfs.BFSSearch(4,0,g3);

//        DFS dfs = new DFS();
//        dfs.DFSSearch(0,6,g3);

        DetectCycle detectCycle = new DetectCycle();
        if(detectCycle.DetectCycleInGraph(0,g3,6))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
