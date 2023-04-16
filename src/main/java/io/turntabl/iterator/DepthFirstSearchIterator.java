package io.turntabl.iterator;

import io.turntabl.collection.Vertex;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DepthFirstSearchIterator<E> implements GraphIterator<E> {
    private Deque<Vertex<E>> stack = new LinkedList<>();
    private final Vertex<E> startNode;

    public DepthFirstSearchIterator(Vertex<E> startNode) {
        this.startNode = startNode;
        stack.push(startNode);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public E getNext() {
        try {
            Vertex<E> current = stack.pop();
            if (current == null) return null;
            if(!current.isVisited()) {
                current.setVisited(true);
                Collections.reverse(current.getNeighbors());
                current.getNeighbors().forEach(stack::push);
                return current.getData();
            }
            return getNext();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}
