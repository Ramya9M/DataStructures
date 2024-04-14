package Graphs;


import java.util.ArrayList;
import java.util.List;

class Edge{
    int u;
    int v;
    int wt;

    Edge(int u, int v, int w){
        this.u = u;
        this.v = v;
        this.wt = w;
    }
    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", wt=" + wt +
                '}';
    }
}
public class GraphUsingEdgeList {

    int V;
    List<Edge> l;

    GraphUsingEdgeList(int V){
        this.V = V;
        l = new ArrayList<>();
    }

    void addEdge(int u, int v, int wt){
        l.add(new Edge(u,v,wt));
    }
    @Override
    public String toString() {
        return "GraphUsingEdgeList{" +
                "V=" + V +
                ", l=" + l +
                '}';
    }
}
