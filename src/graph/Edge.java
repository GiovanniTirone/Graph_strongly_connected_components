package graph;

import java.util.Objects;

public class Edge {

    private double weight;
    private Vertex start;
    private Vertex target;

    public Edge(double weight, Vertex start, Vertex target) {
        this.weight = weight;
        this.start = start;
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getTarget() {
        return target;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return start.equals(edge.start) && target.equals(edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, target);
    }
}
