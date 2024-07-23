package Graphs;

import java.util.*;
public class DFS {


    public void DFSHelper(int node,GraphUsingAdjList graphUsingAdjList, boolean[] visited){

        System.out.println(" "+node+" ");
        visited[node] = true;

        Iterator<Integer> it = graphUsingAdjList.getAdjList()[node].listIterator();
        while(it.hasNext()){

            int nbr = it.next();
            if(!visited[nbr])
                DFSHelper(nbr,graphUsingAdjList,visited );
        }

    }
    public void DFSSearch(int src, int V, GraphUsingAdjList graphUsingAdjList){
        boolean visited[] = new boolean[V];
        DFSHelper(src,graphUsingAdjList, visited);
    }
}
