package edu.ncsu.csc316.rentals.resource;

import java.util.Iterator;

import edu.ncsu.csc316.rentals.util.MinHeapForEdgeEntry;

/**
 * Builds the graph for Dijkstra traversal
 * @author Islahuddin Arshad
 *
 */
public class BuildGraph {

    /*The number of vertex*/
    private int vertexCount;
    /*The min-heap for edges*/
    private MinHeapForEdgeEntry[] adjacent;


    /**
     * Gets the vertex count for the graph
     * @return int the vertex count
     */
    public int getVertexCount() {
        return vertexCount;
    }

    /**
     * Builds the graph given the number of vertices it has
     * @param vertexCount the number of vertices
     */
    public BuildGraph(int vertexCount) {
        this.vertexCount = vertexCount;

        adjacent = new MinHeapForEdgeEntry[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacent[i] = new MinHeapForEdgeEntry();
        }
    }

//    public void setSize(int size) {
//
//    }



    /**
     * Inserts an edge into the graph
     * @param j the startDay vertex
     * @param k the endDay vertex
     * @param cost the cost each car
     * @param make the make of each car
     * @param model the model of each car
     */
    public void insertEdgeEntry(int j, int k, int cost, String make, String model) {
        adjacent[j].insert(new EdgeEntry(j, k, cost, make, model));
    }

    /**
     * Inserts an edge into the graph
     * @param e the edge to insert
     */
    public void insertEdgeEntry(EdgeEntry e) {
        adjacent[e.getStartDay()].insert(e);
    }

    /**
     * Deletes an edge
     * @param j the startDay index
     * @param k the endDay index
     */
    public void deleteEdgeEntry(int j, int k) {
        Iterator<EdgeEntry> it = adjacent[j].iterator();
        EdgeEntry other = new EdgeEntry(j, k, 0, "", "");
        while(it.hasNext()) {
            if (it.next().equals(other)) {
                it.remove();
                return;
            }
        }
    }

    /**
     * Checks if an edge exists
     * @param e the edge to check
     * @return boolean true if exists, false if not
     */
    public boolean hasEdgeEntry(EdgeEntry e) {
        return adjacent[e.getStartDay()].contains(e);
    }

    /**
     * Creates the neighbors of an edge
     * @param vert the vertices around the edge
     * @return MinHeapForEdgeEntry the list of neighbor neigbor for an edge
     */
    public MinHeapForEdgeEntry neighbor(int vert) {
        return adjacent[vert];
    }

    ////print graph;

//    public void printBuildGraph() {
//        for (int i = 0; i < vertexCount; i++) {
//            MinHeapForEdgeEntry edges = neighbor(i);
//            Iterator<EdgeEntry> it = edges.iterator();
//            System.out.print(i + ": ");
//            for (int j = 0; j < edges.size(); j++) {
//                System.out.print(it.next() + " ");
//            }
//            System.out.println();
//        }
//    }
}
	