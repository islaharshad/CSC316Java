package edu.ncsu.csc316.rentals.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.ncsu.csc316.rentals.resource.VertexDay;

/**
 * The min heap implementation for a vertex
 * @author Islahuddin Arshad
 *
 */
public class MinHeapForVertexDay implements Iterable<VertexDay> {

    /*The heap of vertices*/
    private MyArrayList<VertexDay> heap;

    /**
     * Creates a new heap
     */
    public MinHeapForVertexDay() {
        heap = new MyArrayList<VertexDay>();
    }

    /**
     * Inserts a vertex
     * @param vertex the vertex to insert
     */
    public void insert(VertexDay vertex) {
        heap.insert(heap.getSize(), vertex);
        upHeap(heap.getSize() - 1);
    }

    /**
     * Checks if the heap is empty
     * @return boolean true if empty, else not
     */
    public boolean isEmpty() {
        return heap.getSize() == 0;
    }

    /**
     * Deletes the minimum value in the heap and returns it
     * @return VertexDay the minimum vertex in the heap
     */
    public VertexDay deleteMinimum() {
        VertexDay d = null;
        int pos = -1;
        for (int i = 0; i < heap.getSize(); i++) {
            if (d == null || d.getDist() > ((VertexDay) heap.get(i)).getDist())
            {
                d = (VertexDay) heap.get(i);
                pos = i;
            }
        }
        if (pos != -1)
        {
            heap.delete(pos);
        }
        return d;
    }

    /**
     * The size of the heap
     * @return int the size of the heap
     */
    public int size() {
        return heap.getSize();
    }

    /**
     * Upheaps at the given index
     * @param index the index to upheap at
     */
    public void upHeap(int index) {

        if (index > 0 && ((VertexDay) heap.get((index - 1) / 2)).getDist() > ((VertexDay) heap.get(index)).getDist()) {

            VertexDay e1 = (VertexDay) heap.delete(index);
            VertexDay e2 = (VertexDay) heap.delete((index - 1) / 2);

            heap.insert(((index - 1) / 2), e1);
            heap.insert(index, e2);

            upHeap((index - 1) / 2);

        }
    }

//    /**
//     * Down heaps at the given index
//     * @param index the index to downheap at
//     */
//    public void downHeap(int index) {
//        int y = 0;
//        int index1 = 2 * index + 2;
//        int index2 = 2 * index + 1;
//
//        if (index1 < heap.getSize()) {
//            if (((VertexDay) heap.get(index1)).getDist() <= ((VertexDay) heap.get(index2)).getDist()) {
//                y = index1;
//            }
//            else {
//                y = index2;
//            }
//        }
//        else if (index2 < heap.getSize()) {
//            y = index2;
//        }
//
//        if ((y > 0) && ((VertexDay) heap.get(index)).getDist() > ((VertexDay) heap.get(y)).getDist()) {
//            VertexDay e11 = (VertexDay) heap.delete(index);
//            VertexDay e22 = (VertexDay) heap.delete(y - 1);
//            heap.insert(index, e22);
//            heap.insert(y, e11);
//            downHeap(y);
//        }
//    }

    /**
     * The iterator to walk-through the vertices in the graph
     * @author Islahuddin Arshad
     *
     */
    public static class SampleVertexIterator implements Iterator<VertexDay> {

        /*Arraylist of vertices*/
        private MyArrayList<VertexDay> ex;

        /*The index*/
        private int index;

        /**
         * Constructs the iterator for vertices
         * @param ex the list of vertices
         */
        public SampleVertexIterator(MyArrayList<VertexDay> ex) {
            this.ex = ex;
            index = 0;
        }

        /**
         * The next object
         */
        @Override
        public VertexDay next() {
            if (hasNext()) {
                return (VertexDay) ex.get(index++);
            }
            else {
                throw new NoSuchElementException("No size of " + ex.getSize());
            }
        }

        /**
         * Whether the interator has next object or not
         */
        @Override
        public boolean hasNext() {
            return ex.getSize() != index;
        }

        /**
         * Removes the object in the iterator
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
     * Method that contructs a new iterator class
     */
    @Override
    public Iterator<VertexDay> iterator() {
        return new SampleVertexIterator(heap);
    }


}