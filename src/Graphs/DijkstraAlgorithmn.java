package Graphs;

import java.util.*;
public class DijkstraAlgorithmn {

    class Node{
        int vertex;
        int weight;

        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String args[]){

        Map<Integer, List<Node>> mp = new HashMap<>();
        int vertex = 5;

        for(int i=0; i<vertex; i++){
            mp.put(i, new ArrayList<>());
        }
    }


}
