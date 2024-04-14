package Graphs;

import java.util.*;
public class BFS {
    void BFSSearch(int V, int src, GraphUsingAdjList g){

        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(src);
        visited[src] = true;

        while(!queue.isEmpty()){

            int node = queue.removeFirst();
            System.out.println(node);
            Iterator<Integer> it = g.getAdjList()[node].listIterator();

            while(it.hasNext()){
                int nbr = it.next();
                if(!visited[nbr]) {
                    queue.addLast(nbr);
                    visited[nbr] = true;
                }
            }

        }
    }
}
