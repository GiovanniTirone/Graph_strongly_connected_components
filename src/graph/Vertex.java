package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {

    private int id;
    private String name;
    private boolean visited;
    private List<Edge> adjacencyEdgeList;
    private int componentId;


    public Vertex(int id, String name){
        this.id = id;
        this.name = name;
        this.adjacencyEdgeList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<Edge> getAdjacencyEdgeList() {
        return adjacencyEdgeList;
    }

    public int getComponentId() {
        return componentId;
    }

    public void addEdge (Edge e){
        this.adjacencyEdgeList.add(e);
    }

    @Override
    public String toString ( ){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id && name.equals(vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
