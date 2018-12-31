package edu.ncsu.csc316.rentals.sorter;

import edu.ncsu.csc316.rentals.resource.EdgeEntry;
import edu.ncsu.csc316.rentals.util.MyArrayList;

/**
 * Merge sorts each edge entry by start day. This is taken from the 
 * first project
 * @author Islahuddin Arshad
 *
 */
public class MergeSort {
	
	/**Entry of edges to be then sorted*/
	private static MyArrayList<EdgeEntry> entryList;
	
	
	
	
	/**
	 * Merges and sorted by start day
	 * @param unsortedList the list to be sorted
	 * @return myArrayList<logFile> the extracted arraylist based on sort
	 */
	public MyArrayList<EdgeEntry> mergeSort(MyArrayList<EdgeEntry> unsortedList) {
		MyArrayList<EdgeEntry> leftArray = new MyArrayList<EdgeEntry>();
		MyArrayList<EdgeEntry> rightArray = new MyArrayList<EdgeEntry>();
		
		 
		int mid;
		if (unsortedList.getSize() == 1) {
			return unsortedList;
		}
		else {
			mid = unsortedList.getSize() / 2;
			
			int firstCounter = 0;
			while (firstCounter < mid) {
				leftArray.insert(unsortedList.get(firstCounter));
				firstCounter++;
			}
			int secondCounter = mid;
			while (secondCounter < unsortedList.getSize()) {
				rightArray.insert(unsortedList.get(secondCounter));
				secondCounter++;
			}
			
			leftArray = mergeSort(leftArray); ///giving out error
			rightArray = mergeSort(rightArray); ///giving out error
			sort(unsortedList, leftArray, rightArray);
		}
		
		return unsortedList;
		
		
	}
	
	/**
	 * Sorts the edges sorted by start day
	 * @param a the unsorted list
	 * @param leftArray the unsorted list
	 * @param rightArray the unsorted list
	 */
	public void sort(MyArrayList<EdgeEntry> a, MyArrayList<EdgeEntry> leftArray, MyArrayList<EdgeEntry> rightArray) {
		
		
		MyArrayList<EdgeEntry> emptyArray = new MyArrayList<EdgeEntry>();
		int lc = 0;
		int rc = 0;
		int ac = 0;
		int ec = 0;
		while (lc < leftArray.getSize() && rc < rightArray.getSize()) {
			if  (((EdgeEntry) leftArray.get(lc)).getStartDay() < ((EdgeEntry) rightArray.get(rc)).getStartDay()) { 
				
				a.setAt(ac, leftArray.get(lc));
				lc++;
			}
			else {
				a.setAt(ac, rightArray.get(rc));
				rc++;
			}
			ac++;
			
		}
		
		if (lc >= leftArray.getSize()) {
			emptyArray = rightArray;
			ec = rc;
		}
		else {
			emptyArray = leftArray;
			ec = lc;
		}
		int last = ec;
		while (last < emptyArray.getSize()) {
			a.setAt(ac, emptyArray.get(last));
			last++;
			ac++;
		}
		
		
	}
	
	
	/**
	 * Sort by make and model
	 * @param edges the edge list to sort from
	 */
	public void mSMakeAndModel(MyArrayList<EdgeEntry> edges) {
		entryList = edges;
		mSMakeAndModel(0, entryList.getSize() - 1);
		entryList = null;
	}
	
	/**
	 * Sorts by make and model
	 * @param s the start of list
	 * @param e the end of the list
	 */
	private void mSMakeAndModel(int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mSMakeAndModel(s, m);
			mSMakeAndModel(m + 1, e);
			
			
			MyArrayList<EdgeEntry> newEdgeEntries = new MyArrayList<EdgeEntry>(e - s + 1);
			int lc = s;
			int rc = m + 1;
			
			while (newEdgeEntries.getSize() != e - s + 1) {
				if (lc > m) {
					newEdgeEntries.insert(entryList.get(rc++));
				}
				else if (rc > e) {
					newEdgeEntries.insert(entryList.get(lc++));
				}
				else {
					
					int nPriceL = ((EdgeEntry) entryList.get(lc)).getCost();
					int nPriceR = ((EdgeEntry) entryList.get(rc)).getCost();
					if(nPriceL < nPriceR) {
						newEdgeEntries.insert(entryList.get(lc++));
					}
					else if(nPriceL > nPriceR) {
						newEdgeEntries.insert(entryList.get(rc++));
					}
					else {
						String lcMake = ((EdgeEntry) entryList.get(lc)).getMake();
						String rcMake = ((EdgeEntry) entryList.get(rc)).getMake();
					
					
						if (lcMake.compareTo(rcMake) < 0) {
							newEdgeEntries.insert(entryList.get(lc++));
						}
						else if (lcMake.compareTo(rcMake) > 0) {
							newEdgeEntries.insert(entryList.get(rc++));
						}
						else {
							String lcModel = ((EdgeEntry) entryList.get(lc)).getModel();
							String rcModel = ((EdgeEntry) entryList.get(rc)).getModel();
						
							if (lcModel.compareTo(rcModel) > 0) {
								newEdgeEntries.insert(entryList.get(rc++));
							}
							else {
								newEdgeEntries.insert(entryList.get(lc++));
							}
						}
					}
				}
				
			}
			
			int k = s;
			
			while (k <= e) {
				entryList.setAt(k, newEdgeEntries.get(k - s));
				k++; 
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
