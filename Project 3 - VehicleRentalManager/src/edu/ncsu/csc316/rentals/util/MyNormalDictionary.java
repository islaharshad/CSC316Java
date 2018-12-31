package edu.ncsu.csc316.rentals.util;

/**
 * The normal dictionary contains string values and integer keys
 * @author Islahuddin Arshad
 *
 */
public class MyNormalDictionary {

	/**The value arraylist*/
	private MyArrayList<Integer> v;
	/**The key arraylist*/
	private MyArrayList<String> k;


	
	/**
	 * Constructs the dictionary with arrays of keys and values
	 */
	public MyNormalDictionary() {
		k = new MyArrayList<>();
		v = new MyArrayList<>();

	}
	
	/**
	 * Gets the size of dictionary
	 * @return int the size of the dictionary
	 */
	public int getSize() {
		return v.getSize();
	}
	
	/**
	 * Gets teh key from dictionary
	 * @param i get the key at
	 * @return String the key
	 */
	public String getKeyFrom(int i) {
		return (String) k.get(i);
	}
	
	/**
	 * Gets the value from dictionary
	 * @param i get the value at
	 * @return int the value
	 */
	public int getValueFrom(int i) {
		return (int) v.get(i);
	}
	
	/**
	 * Puts values in the dictionary
	 * @param key the key to put
	 * @param value the value to put
	 */
	public void putHere(String key, Integer value) {
		k.insert(key);
		v.insert(value);
	}
	
	/**
	 * Merge sorts the dictionary
	 */
	public void mSorter() {
		mergerSorter(0, k.getSize() - 1);
	}
	
	/**
	 * Merge sorts two values
	 * @param s the start index
	 * @param e the end index
	 */
	private void mergerSorter(int s, int e) {
		if (s < e) {
			int m = (s + e) / 2;
			mergerSorter(s, m);
			mergerSorter(m + 1, e);

			MyArrayList<String> checkKeys = new MyArrayList<>(e - s + 1);
			MyArrayList<Integer> checkValues = new MyArrayList<>(e - s + 1);
			int lc = s;
			int rc = m + 1;
			while (checkKeys.getSize() != e - s + 1) {
				if (lc > m) {
					checkKeys.insert(k.get(rc));
					checkValues.insert(v.get(rc));
					rc++;
				} else if (rc > e) {
					checkKeys.insert(k.get(lc));
					checkValues.insert(v.get(lc));
					lc++;
				} else if ((int) v.get(lc) < (int) v.get(rc)) {
					checkKeys.insert(k.get(lc));
					checkValues.insert(v.get(lc));
					lc++;
				} else if ((int)v.get(lc) > (int)v.get(rc)) {
					checkKeys.insert(k.get(rc));
					checkValues.insert(v.get(rc));
					rc++;
				} else if (((String) k.get(lc)).compareTo((String)k.get(rc)) < 0) {
					checkKeys.insert(k.get(lc));
					checkValues.insert(v.get(lc));
					lc++;
				} else if (((String) k.get(lc)).compareTo((String)k.get(rc)) > 0) {
					checkKeys.insert(k.get(rc));
					checkValues.insert(v.get(rc));
					rc++;
				}
			}
			
			
			for (int j = s; j <= e; j++) {
				k.setAt(j, checkKeys.get(j - s));
				v.setAt(j, checkValues.get(j - s));
			}

			
		}
	}
	
	
}
