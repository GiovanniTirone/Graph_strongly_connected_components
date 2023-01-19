package graph;



import java.util.List;


public class Graph<V extends Vertex> {

    private List<V> verticesList;
    private List<Edge<V>> edgesList;


    public Graph(List<V> verticesList, List<Edge<V>> edgesList){
        this.verticesList = verticesList;
        this.edgesList = edgesList;
    }


    public List<V> getVerticesList() {
        return verticesList;
    }

    public List<Edge<V>> getEdgesList() {
        return edgesList;
    }


    public void addVertex (V v) throws Exception {
        this.verticesList.add(v);
        if(!v.getAdjacencyEdgeList().isEmpty()) {
            if(v.getAdjacencyEdgeList().isEmpty())
                throw new Exception("The adjacency list is not empty but the transposed list is empty");
            edgesList.addAll(v.getAdjacencyEdgeList());
        }
    }

    public void createEdge (double weight, V start, V target) throws Exception {
        if(!verticesList.contains(start) || !verticesList.contains(target)) throw  new Exception("The vertices are not in the graph");
        Edge<V> e = new Edge<>(weight,start,target);
        if(edgesList.contains(e)) throw new Exception("A vertex between these two vertices already exists");
        edgesList.add(e);
        start.addEdge(e);
    }




}
