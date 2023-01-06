package KosarajuAlgo;

import graph.Graph;

public class KosarajuAlgo {

    private int count;
    private Graph graph;
    private Graph transposedGraph;

    public KosarajuAlgo (Graph graph){
        this.graph = graph;
        this.transposedGraph = graph.createTransposedGraph();
    }





}
