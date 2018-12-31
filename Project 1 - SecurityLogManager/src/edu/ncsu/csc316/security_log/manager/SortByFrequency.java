package edu.ncsu.csc316.security_log.manager;



/**
 * Sorts the array by frequency
 * @author Islahuddin Arshad
 *
 */
public class SortByFrequency {

	/**
	 * Sorts the logfiles by frequency
	 * @param all the unsorted list
	 * @return myArrayList<logFile> the extracted arraylist based on sortl
	 */
	public MyArrayList<LogFile> mergeSort(MyArrayList<LogFile> all) {
	    MyArrayList<LogFile> left = new MyArrayList<LogFile>();
	    MyArrayList<LogFile> right = new MyArrayList<LogFile>();
	    int center;
	 
	    if (all.getSize() == 1) {    
	        return all;
	    } else {
	        center = all.getSize() / 2;
	        
	        int j = 0;
	        while (j < center) {
	        	 left.insert(all.get(j));
	        	 j++;
	         }
	        
	        int k = center;
	        while (k < all.getSize()) {
	        	 right.insert(all.get(k));
	        	 k++;
	         }
	 
	       
	        left  = mergeSort(left);
	        right = mergeSort(right);
	 
	      
	        merge(left, right, all);
	    }
	    return all;
	}

	/**
	 * Sorts the logfiles by frequency
	 * @param left the left unsorted array
	 * @param right the right unsorted array
	 * @param whole the whole unsorted array
	 * @return int the sum of size of left and right arrays
	 */
	public int merge(MyArrayList<LogFile> left, MyArrayList<LogFile> right, MyArrayList<LogFile> whole) {
	    int li = 0;
	    int ri = 0;
	    int wi = 0;
	 
	  
	    while (li < left.getSize() && ri < right.getSize()) {
	        if (((LogFile) left.get(li)).getFrequency() -  ((LogFile) right.get(ri)).getFrequency() > 0) {
	            whole.setAt(wi, left.get(li));
	            li++;
	        } else {
	            whole.setAt(wi, right.get(ri));
	            ri++;
	        }
	        wi++;
	    }
	 
	    MyArrayList<LogFile> rest;
	    int resti;
	    if (li >= left.getSize()) {
	       
	        rest = right;
	        resti = ri;
	    } else {
	     
	        rest = left;
	        resti = li;
	    }
	 
	 
	    for (int i = resti; i < rest.getSize(); i++) {
	        whole.setAt(wi, rest.get(i));
	        wi++;
	    }
	    return left.getSize() + right.getSize();
	}
}
