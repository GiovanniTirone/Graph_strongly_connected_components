package graph;


import java.util.ArrayList;
import java.util.List;


public class Graph_Kos extends Graph<Vtx_Kos> {

    private List<Edge<Vtx_Kos>> transposedEdgeList;

    public Graph_Kos(List<Vtx_Kos> verticesList, List<Edge<Vtx_Kos>> edgesList){
        super(verticesList,edgesList);
        this.transposedEdgeList = new ArrayList<>();
    }

    public List<Edge<Vtx_Kos>> getTransposedEdgeList() {
        return transposedEdgeList;
    }

    public void addVertex (Vtx_Kos v) throws Exception {
        super.addVertex(v);
        transposedEdgeList.addAll(v.getTransposedEdgeList());

    }

    @Override
    public void createEdge (double weight, Vtx_Kos start, Vtx_Kos target) throws Exception {
        super.createEdge(weight,start,target);
        Edge<Vtx_Kos> t = new Edge<>(weight,target,start); // transposed edge
        transposedEdgeList.add(t);
        target.addTransposedEdge(t);
    }

    public Graph_Kos createTransposedGraph () {
        List<Vtx_Kos> transposedVertices = getVerticesList().stream().map(Vtx_Kos::createTransposedVtx).toList();
        List <Edge<Vtx_Kos>> transposedEdges = transposedVertices.stream().flatMap(v -> v.getAdjacencyEdgeList().stream()).toList();
        return new Graph_Kos(transposedVertices,transposedEdges);
    }


}
