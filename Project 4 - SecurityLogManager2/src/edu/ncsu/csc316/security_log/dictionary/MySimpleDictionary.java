package edu.ncsu.csc316.security_log.dictionary;

import edu.ncsu.csc316.security_log.util.MyArrayList;

/**
 * 
 * Simple dictionary to store final object when outputting the organizational profile
 * @author Islahuddin Arshad
 *
 * @param <K> the key to insert
 * @param <V> the value to insert
 */
public class MySimpleDictionary<K, V extends Comparable<V>> {

	private HashTableSecondary<K, V> hashTable;
	private MyArrayList<V> v;
    private MyArrayList<K> k;
	/**
	 * Constructor for the dictionary which initialzes the array lists
	 */
	public MySimpleDictionary() {
		hashTable = new HashTableSecondary<K, V>();
	}
	
	/**
	 * Gets key at an index
	 * @param i the index to get a key at
	 * @return String the key to return at index
	 */
	// public String getMyKey(int i) {
	//	return (String) k.get(i);
	// }
	
	/**
	 * Insert key and value into the dictionary
	 * @param key the key to insert
	 * @param val the value to insert
	 */
	public void insert(K key, V val) {
		hashTable.insert(key, val);
	}
	
	/**
	 * Gets value at an index
	 * @param i the index to get the value at
	 * @return Integer the value to at return at index
	 */
	public int getMyValue(int i) {
		return (int) this.v.get(i);
	}

    /**
     * Gets key at an index
     * @param i the index to get a key at
     * @return String the key to return at index
     */
    public String getMyKey(int i) {
        return (String) k.get(i);
    }


    /**
	 * Gets the size of the dictioanary
	 * @return int the size
	 */
	public int getMySize() {
		return k.getSize();
	}
	
	/**
	 * Merge sorts into decreasing frequency. If frequency is the same, sorts by action and resource
	 */
	public void mergeSorter() {
	    this.v = hashTable.contents();
	    this.k = hashTable.keys();
		mergeSorter(0, this.hashTable.size() - 1);
	}

    /**
     * Private helper method to merge sort by descending frequencies and then by action and resouce
     * @param start the start of the dictionary
     * @param end the end of the dictionary
     */
    private void mergeSorter(int s, int e) {
        if (s < e) {
            int m = (s + e) / 2;
            mergeSorter(s, m);
            mergeSorter(m + 1, e);
            int size = e - s + 1;
            MyArrayList<K> dictValue = new MyArrayList<>(size);
            MyArrayList<V> dictKey = new MyArrayList<>(size);
            int lc = s;
            int rc = m + 1;
            
//            
//            Object kGetRc = k.get(rc);
//            Object vGetRc = v.get(rc);
//            
//            Object kGetLc = j
            
            
            while (dictKey.getSize() != size) {
                if (lc > m) {
                    dictKey.insert(k.get(rc));
                    dictValue.insert(v.get(rc));
                    rc++;
                }
                else if (rc > e) {
                    dictKey.insert(k.get(lc));
                    dictValue.insert(v.get(lc));
                    lc++;
                }
                else if ((Integer) v.get(lc) > (Integer) v.get(rc)) {
                    dictKey.insert(k.get(lc));
                    dictValue.insert(v.get(lc));
                    lc++;
                }
                else if ((Integer) v.get(lc) < (Integer) v.get(rc)) {
                    dictKey.insert(k.get(rc));
                    dictValue.insert(v.get(rc));
                    rc++;
                }
                else if (((String) k.get(lc)).compareTo((String) k.get(rc)) < 0) {
                    dictKey.insert(k.get(lc));
                    dictValue.insert(v.get(lc));
                    lc++;
                }
                else if (((String) k.get(lc)).compareTo((String) k.get(rc)) > 0) {
                    dictKey.insert(k.get(rc));
                    dictValue.insert(v.get(rc));
                    rc++;
                }
            }
            int i = s;
            while (i <= e) {
                k.setAt(i,  dictKey.get(i - s));
                v.setAt(i, dictValue.get(i - s));
                i++;
            }
        }
    }

}
