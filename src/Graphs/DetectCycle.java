package Graphs;

import java.util.*;
public class DetectCycle {

    boolean DetectCycleHelper(int node, GraphUsingAdjList graphUsingAdjList, boolean[] visited, int parent){

        visited[node] = true;

        Iterator<Integer> it = graphUsingAdjList.getAdjList()[node].listIterator();
        while(it.hasNext()){
            int nbr = it.next();
            if(!visited[nbr]){
                boolean cycleFound =  DetectCycleHelper(nbr,graphUsingAdjList,visited,node);
                if(cycleFound)
                    return true;
            }
            else if(visited[nbr]== true && nbr != parent)
                return true;
        }
        return false;

    }

    public boolean DetectCycleInGraph(int src, GraphUsingAdjList graphUsingAdjList,int V){
        boolean[] visited = new boolean[V];
        return DetectCycleHelper(src,graphUsingAdjList,visited,-1);
    }

}
