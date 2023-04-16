package io.turntabl.collection;

import io.turntabl.iterator.BreadthFirstSearchIterator;
import io.turntabl.iterator.DepthFirstSearchIterator;
import io.turntabl.iterator.GraphIterator;

import java.util.LinkedList;
import java.util.List;

public class Vertex<E> implements IterableGraph<E> {
    private final E data;
    private boolean visited;
    private List<Vertex<E>> neighbors;

    public Vertex(E data) {
        this.data = data;
        this.visited = false;
        this.neighbors = new LinkedList<>();
    }

    public E getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex<E>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex<E>> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public GraphIterator<E> createBFSIterator() {
        return new BreadthFirstSearchIterator<E>(this);
    }

    @Override
    public GraphIterator<E> createDFSIterator() {
        return new DepthFirstSearchIterator<>(this);
    }
}
