package graph;

import java.util.ArrayList;
import java.util.List;


public class Vtx_Kos extends Vertex<Vtx_Kos> {

    private List<Edge<Vtx_Kos>> transposedEdgeList;

    public Vtx_Kos(int id, String name){
        super(id, name);
        this.transposedEdgeList = new ArrayList<>();
    }


    public List<Edge<Vtx_Kos>> getTransposedEdgeList() {
        return transposedEdgeList;
    }


    public List<Vtx_Kos> getAdjacencyTransposedVtxList () {
        return this.transposedEdgeList.stream().map(Edge::getTarget).toList();
    }


    public void addTransposedEdge ( Edge<Vtx_Kos> e) {
        this.transposedEdgeList.add(e);
    }

    public Vtx_Kos createTransposedVtx ( ) {
        Vtx_Kos v_transposed = new Vtx_Kos(this.getId(),this.getName()+"_tr");
        v_transposed.setAdjacencyEdgeList(this.transposedEdgeList);
        v_transposed.transposedEdgeList = this.getAdjacencyEdgeList();
        return v_transposed;
    }


}
