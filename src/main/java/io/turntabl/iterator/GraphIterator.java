package io.turntabl.iterator;

public interface GraphIterator<E> {
    boolean hasNext();

    E getNext();

}
