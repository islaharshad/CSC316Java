package edu.ncsu.csc316.rentals.util;

import java.util.Iterator;

import java.util.NoSuchElementException;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;



/**
 * Creates a min-heap for the edges
 * @author Islahuddin Arshad
 *
 */
public class MinHeapForEdgeEntry implements Iterable<EdgeEntry> {

    /*Heap for the edge*/
    private MyArrayList<EdgeEntry> heap;

    /**
     * Constructs a new minheap for edges
     */
    public MinHeapForEdgeEntry() {
        heap = new MyArrayList<EdgeEntry>();
    }

    /**
     * Inserts an edge in the heap
     * @param entry the entry to insert
     */
    public void insert(EdgeEntry entry) {
        heap.insert(heap.getSize(), entry);
        upHeap(heap.getSize() - 1);
    }

    /**
     * Deletes the minimum edge in the heap
     * @return EdgeEntry the edge that is deleted
     */
    public EdgeEntry deleteMinimum() {
        EdgeEntry t = null;
        if (heap.getSize() != 0) {
            t = (EdgeEntry) heap.get(0);
        }
        int lastEle = heap.getSize() - 1;
        if (heap.getSize() > 0) {
            heap.setAt(0, heap.get(lastEle));
            heap.delete(lastEle);
            downHeap(0);
        }
        return t;
    }

    /**
     * Gets the size of heap
     * @return int size of the heap
     */
    public int size() {
        return heap.getSize();
    }

    /**
     * Upheaps at the index
     * @param index the index to upheap at
     */
    public void upHeap(int index) {

        if (index > 0 && ((EdgeEntry) heap.get((index - 1) / 2)).getCost() > ((EdgeEntry) heap.get(index)).getCost()) {

            EdgeEntry e1 = (EdgeEntry) heap.delete(index);
            EdgeEntry e2 = (EdgeEntry) heap.delete((index - 1) / 2);

            heap.insert(((index - 1) / 2), e1);
            heap.insert(index, e2);

            upHeap((index - 1) / 2);

        }
    }

    /**
     * Downheaps at the index
     * @param index the index to downheap at
     */
    public void downHeap(int index) {
        int y = 0;
        int index1 = 2 * index + 2;
        int index2 = 2 * index + 1;

        if (index1 < heap.getSize()) {
            if (((EdgeEntry) heap.get(index1)).getCost() <= ((EdgeEntry) heap.get(index2)).getCost()) {
                y = index1;
            }
            else {
                y = index2;
            }
        }
        else if (index2 < heap.getSize()) {
            y = index2;
        }

        if ((y > 0) && ((EdgeEntry) heap.get(index)).getCost() > ((EdgeEntry) heap.get(y)).getCost()) {
            EdgeEntry e11 = (EdgeEntry) heap.delete(index);
            EdgeEntry e22 = (EdgeEntry) heap.delete(y - 1);
            heap.insert(index, e22);
            heap.insert(y, e11);
            downHeap(y);
        }
    }


    /**
     * Checks if array has an element
     * @param obj the element to check
     * @return boolean whether the element exists or not
     */
    public boolean contains(Object obj) {
        for (int i = 0; i < heap.getSize(); i++) {
            if (heap.get(i) == obj) {
                return true;
            }
        }
        return false;
    }

    /**
     * Iterator to go over a list of edges in the graph
     * @author Islahuddin Arshad
     *
     */
    public class SampleEdgeIterator implements Iterator<EdgeEntry> {

        /*List of edges in the graph*/
        private MyArrayList<EdgeEntry> ex;

        /*Index at the graph*/
        private int index;

        /**
         * Constructs an edge interator
         * @param ex the list of edges
         */
        public SampleEdgeIterator(MyArrayList<EdgeEntry> ex) {
            this.ex = ex;
            index = 0;
        }

        /**
         * Checks the next value of the interator
         */
        @Override
        public EdgeEntry next() {
            if (hasNext()) {
                return (EdgeEntry) ex.get(index++);
            }
            else {
                throw new NoSuchElementException("No size of " + ex.getSize());
            }
        }

        /**
         * Checks whether the iterator has next or not
         */
        @Override
        public boolean hasNext() {
            return ex.getSize() != index;
        }

        /**
         * Removes a value in iterator
         */
        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("Can't delete before first next()");
            }
            ex.delete(--index);
        }
    }




    /**
     * Constructs a new iterator object to be called
     */
    @Override
    public Iterator<EdgeEntry> iterator() {
        return new SampleEdgeIterator(heap);
    }

}