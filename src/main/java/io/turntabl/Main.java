package io.turntabl;

import io.turntabl.collection.Vertex;
import io.turntabl.iterator.BreadthFirstSearchIterator;
import io.turntabl.iterator.DepthFirstSearchIterator;
import io.turntabl.iterator.GraphIterator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vertex<String> location1 = new Vertex<>("National Museum of Ghana");
        Vertex<String> location2 = new Vertex<>("National Theatre");
        Vertex<String> location3 = new Vertex<>("Black Star Square");
        Vertex<String> location4 = new Vertex<>("Kwame Nkrumah Memorial Park & Mausoleum");
        Vertex<String> location5 = new Vertex<>("Osu Castle");
        Vertex<String> location6 = new Vertex<>("Centre for National Culture");
        Vertex<String> location7 = new Vertex<>("Marina Mall");


        location1.setNeighbors(Arrays.asList(location2, location6, location7));
        location2.setNeighbors(Arrays.asList(location4, location5));
        location5.setNeighbors(Arrays.asList(location3, location7));
        location7.setNeighbors(Arrays.asList(location1));



        GraphIterator<String> bfs = location1.createBFSIterator();


        System.out.println("BFS");

        while (bfs.hasNext()) {
            System.out.println(bfs.getNext());
        }

//        DepthFirstSearchIterator<String> dfs = (DepthFirstSearchIterator<String>) location1.createDFSIterator();
        GraphIterator<String> dfs = location1.createDFSIterator();
        System.out.println("\nDFS");
        while (dfs.hasNext()) {
            System.out.println(dfs.getNext());
        }
    }
}