package graph;

import java.util.Objects;

public class Edge<V extends Vertex> {

    private double weight;
    private V start;
    private V target;

    public Edge(double weight, V start, V target) {
        this.weight = weight;
        this.start = start;
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public V getStart() {
        return start;
    }

    public V getTarget() {
        return target;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<V> edge = (Edge<V>) o;
        return start.equals(edge.start) && target.equals(edge.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, target);
    }
}
