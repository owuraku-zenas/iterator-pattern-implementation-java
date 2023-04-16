package io.turntabl.iterator;

import io.turntabl.collection.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearchIterator<E> implements GraphIterator<E> {
    private final Queue<Vertex<E>> queue = new LinkedList<>();
    private final Vertex<E> startNode;

    public BreadthFirstSearchIterator(Vertex<E> startNode) {
        this.startNode = startNode;
        queue.add(startNode);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public E getNext() {
        Vertex<E> current = queue.poll();
        if (current == null) return null;
        if (!current.isVisited()) {
            current.setVisited(true);
            queue.addAll(current.getNeighbors());
            return current.getData();
        }
        return getNext();
    }

}
