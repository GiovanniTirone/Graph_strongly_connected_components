package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {

    private List<Vertex> verticesList;
    private List<Edge> edgesList;

    public Graph(List<Vertex> verticesList,List<Edge> edgesList){
        this.verticesList = verticesList;
        this.edgesList = edgesList;
    }


    public List<Vertex> getVerticesList() {
        return verticesList;
    }

    public List<Edge> getEdgesList() {
        return edgesList;
    }

    public void addVertex (Vertex v){
        this.verticesList.add(v);
        if(!v.getAdjacencyEdgeList().isEmpty())
            edgesList.addAll(v.getAdjacencyEdgeList());
    }

    public void createEdge (double weight, Vertex start, Vertex target) throws Exception {
        if(!verticesList.contains(start) || !verticesList.contains(target)) throw  new Exception("The vertices are not in the graph");
        Edge e = new Edge(weight,start,target);
        if(edgesList.contains(e)) throw new Exception("A vertex between these two vertices already exists");
        edgesList.add(e);
        start.addEdge(e);
    }

    public Graph createTransposedGraph () {
        Map<Vertex,Vertex> transposedVerticesMap = new HashMap<>();
        verticesList.forEach(v -> transposedVerticesMap.put(v,new Vertex(v.getId(),v.getName())));
        List<Edge> transposedEdges = edgesList.stream()
                .map(edge -> new Edge(edge.getWeight(),transposedVerticesMap.get(edge.getTarget()),transposedVerticesMap.get(edge.getStart())))
                .toList();
        return new Graph(transposedVerticesMap.values().stream().toList(),transposedEdges);
    }

}
