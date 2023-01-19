package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex <V extends Vertex> {

    private int id;
    private String name;
    private StatusVtx status;
    private List<Edge<V>> adjacencyEdgeList;
    private int componentId;


    public Vertex (int id, String name) {
        this.id = id;
        this.name = name;
        this.status = StatusVtx.NOT_VISITED;
        this.adjacencyEdgeList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public StatusVtx getStatus() {
        return status;
    }

    public void setNextStatus () {
        this.status = this.status.getNextStatus();
    }

    public List<Edge<V>> getAdjacencyEdgeList() {
        return adjacencyEdgeList;
    }

    public void setAdjacencyEdgeList(List<Edge<V>> adjacencyEdgeList) {
        this.adjacencyEdgeList = adjacencyEdgeList;
    }

    public List<V> getAdjacencyVtxList () {
        return this.adjacencyEdgeList.stream().map(Edge::getTarget).toList();
    }


    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public void addEdge (Edge<V> e){
        this.adjacencyEdgeList.add(e);
    }

    @Override
    public String toString ( ){
        return this.name + " - componentId: " +componentId ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        V vertex = (V) o;
        return id == vertex.getId() && name.equals(vertex.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
