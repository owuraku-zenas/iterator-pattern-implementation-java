package io.turntabl.collection;

import io.turntabl.iterator.GraphIterator;

public interface IterableGraph<E> {
    GraphIterator<E> createBFSIterator();
    GraphIterator<E> createDFSIterator();
}
