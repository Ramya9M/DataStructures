package Graphs;

public class GraphMain {

  public static void main(String args[]){
      GraphUsingEdgeList g = new GraphUsingEdgeList(4);
      g.addEdge(0,1,10);
      g.addEdge(0,2,20);
      g.addEdge(1,2,30);
      g.addEdge(2,0,40);
      g.addEdge(2,3,50);
      g.addEdge(3,3,60);
      System.out.println(g);
  }


}
