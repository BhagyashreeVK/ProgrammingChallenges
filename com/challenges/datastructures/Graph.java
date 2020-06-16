package com.challenges.datastructures;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Integer>[] graphAdjList;

    Graph(int v){
        graphAdjList = new ArrayList[v];
    }

    public void addEdge(int source, int dest){
        graphAdjList[source].add(dest);
    }



}
