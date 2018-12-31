package edu.ncsu.csc316.security_log.dictionary;

import java.lang.reflect.Array;

import edu.ncsu.csc316.security_log.util.MyArrayList;

/**
 * This hashtable is a map dictionary used by the program
 * @author Islahuddin Arshad
 *
 * @param <K> the key in the hash map
 * @param <V> the value in the hash map
 */
@SuppressWarnings("rawtypes")
public class HashTableSecondary<K, V extends Comparable> {

/**
    public static void main(String args [])
    {
        HashTable<String,Integer> ht = new HashTable<String,Integer>();
        ht.insert("hi",3);

        ht.insert("hi2",5);

        ht.insert("hi1",4);

        ht.insert("heoui2",9);

        ht.insert("hioeuoeueuo1",8);

        System.out.println(ht.size());
    }
 */

	/** The hash table*/
    private Pair[] hashTable;
    /** The size of the array*/
    private int size;
    /** number of items in the table*/
    private int itemsInTable;
    /** the total number checking probes*/
    private int checkingProbes;
    /** counter for lookup*/
    private int lookUpCounter;
    /**Load factor for collision resolution*/
    private final double load = 0.75;
    

    /**
     * This is the constructor of the Hash Table
     */
    @SuppressWarnings("unchecked")
	public HashTableSecondary() {
        this.size = 2;
        this.itemsInTable = 0;
        hashTable = (Pair[]) Array.newInstance(Pair.class, this.size);

    }

    /**
     * This will compressed the generated hashcode through the GOLDEN RATIO
     * @param hashCode to be compressed
     * @param array the pair array
     * @return int the compressed hashCode
     */
    public int compress(int hashCode, Pair[] array) {
        double gRatio = ((Math.sqrt(5) - 1) / 2);
        double p = array.length;
        int result = (int) Math.floor(p * ((hashCode * gRatio) - Math.floor(hashCode * gRatio)));
        return result;
    }

    /**
     * This method resizes the array if it exceeds the size@SuppressWarnings("unchecked")

     */
    @SuppressWarnings("unchecked")
	public void resize() {
        this.size *= 2;
        this.itemsInTable = 0;
        Pair[] values = (Pair[]) Array.newInstance(Pair.class, this.size);
        for (int i = 0; i < this.hashTable.length; i++) {
            if (this.hashTable[i] != null) {
                insert(values, this.hashTable[i].k, this.hashTable[i].v);
            }
        }
        this.hashTable = values;
    }

    /**
     * Inserts teh key and value in the hashtable
     * @param hash the pair array containing hash values
     * @param key the key to insert
     * @param value the value to insert
     */
    private void insert(Pair[] hash, K key, V value) {
        int hashCode = key.hashCode();

        int compressed = this.compress(hashCode, hash);
        Pair p = new Pair(key, value);

        compressed = this.resolveCollisions(hash, compressed, value);
        hash[compressed] = p;
        itemsInTable++;

        if (loadFactor() > load) {
            resize();
        }
    }

//    /**
//     * Inserts the generic value E into the hash table
//     *
//     * @param value - the value to insert into the hash table
//     */
//    public void insert(V value)
//    {
//        int hashCode = value.hashCode();
//
//        int compressed = this.compress(hashCode, this.hashTable);
//        Pair p = new Pair(null, value);
//
//        compressed = this.resolveCollisions(this.hashTable, compressed, value);
//        this.hashTable[compressed] = p;
//        itemsInTable++;
//
//        if (loadFactor() > LOADFACTOR) {
//            resize();
//        }
//    }


    /**
     * Retrieves the value contents in the array
     * @return MyArrayList<V> the value array
     */
    public MyArrayList<V> contents() {
        MyArrayList<V> arrayList = new MyArrayList<V>();
        for (int i = 0; i < this.hashTable.length; i++) {
            if (this.hashTable[i] != null) {
                arrayList.insert(this.hashTable[i].v);
            }
        }
        return arrayList;
    }


    /**
     * Retrieves the key contents in the array
     * @return MyArrayList<K> the key array
     */
    public MyArrayList<K> keys() {
        MyArrayList<K> arrayList = new MyArrayList<K>();
        for (int i = 0; i < this.hashTable.length; i++) {
            if (this.hashTable[i] != null) {
                arrayList.insert(this.hashTable[i].k);
            }
        }
        return arrayList;
    }

    private double loadFactor() {
        return ((double) itemsInTable / this.size);
    }

    /**
     * Returns the length/capacity of the hash table
     *
     * @return the length/capacity of the hash table
     */
    public int getHashTableLength()
    {
        return (itemsInTable / this.size);
    }
   

    /**
     * Inserts a key and a valueinto the hash table
     * @param value - the value to insert into the hash table
     * @param key - the key to insert into the hash table
     */
    public void insert(K key, V value) {
        this.insert(this.hashTable, key, value);
    }

    /**
     * This will collisions in the hashtable when inserting
     * @param hashT the hash table created
     * @param hashCode generated by the value in the table
     * @param value the generic value
     * @return int the hash code of the value
     */
    public int resolveCollisions(Pair[] hashT, int hashCode, V value) {
        if (hashCode < 0) {
            hashCode *= -1;
        } else if (hashCode == 0) {
            hashCode += 1;
        }
        while (hashT[hashCode] != null) {
            hashCode++;
            hashCode = hashCode % hashT.length;
        }

        return hashCode;
    }

    /**
     * Returns the hash table
     * @return Pair[] values in the hash table
     */
    public Pair[] getTable() {
        return hashTable;
    }


    /**
     * This will return the size of the hash table
     *
     * @return size of the hash table.
     */
    public int size() {
        return itemsInTable;
    }

//    /**
//     * This will look up a word in the hash table
//     *
//     * @param key that is to be looked up
//     * @return true if the word is in the hash table, false if otherwise
//     */
//    public K lookUp(K key) {
//        lookUpCounter++;
//        int hash = compress(key.hashCode(), this.hashTable);
//        //check if it's null
//        if (this.getTable()[hash] == null) {
//            return null;
//        }
//        ///
//        if (this.getTable()[hash].equals(key.toString())) {
//            checkingProbes++;
//            return this.getTable()[hash].k;
//        } else {
//            hash = this.compress(key.hashCode(), this.hashTable);
//            int newHash = (hash) % size;
//            String compare = key.toString();
//            while (newHash != hash - 1) {
//                //System.out.println("Hash: " + newHash + " Word: " + word);
//                if (this.getTable()[newHash].k.equals(key)) {
//                    checkingProbes++;
//                    return this.getTable()[newHash].k;
//                } else {
//                    checkingProbes++;
//                    //hash1 = this.compress(word.hashCode());
//                    newHash++;
//                    newHash = (newHash) % size;
//                }
//            }
//
//            return null;
//        }
//    }
//
//
//    public V lookUp(V value) {
//        lookUpCounter++;
//        int hash = compress(value.hashCode(), this.hashTable);
//        //check if it's null
//        if (this.getTable()[hash] == null) {
//            return null;
//        }
//        ///
//        if (this.getTable()[hash].equals(value.toString())) {
//            checkingProbes++;
//            return this.getTable()[hash].v;
//        } else {
//            hash = this.compress(value.hashCode(), this.hashTable);
//            int newHash = (hash) % size;
//            String compare = value.toString();
//            while (newHash != hash - 1) {
//                //System.out.println("Hash: " + newHash + " Word: " + word);
//                if (this.getTable()[newHash].k.equals(value)) {
//                    checkingProbes++;
//                    return this.getTable()[newHash].v;
//                } else {
//                    checkingProbes++;
//                    //hash1 = this.compress(word.hashCode());
//                    newHash++;
//                    newHash = (newHash) % size;
//                }
//            }
//
//            return null;
//        }
//    }


    /**
     * retrieves the chekcing probes
     *
     * @return checking probes
     */
    public int getCheckingProbes() {
        return checkingProbes;
    }

    /**
     * retrieves the getLookUpprobes
     *
     * @return look up probes
     */
    public int getLookUpCounter() {
        return lookUpCounter;
    }

    /**
     * Creates a pair of map values to be put into hashtable
     * @author Islahuddin Arshad
     *
     */
    public class Pair {
        K k;
        V v;

        /**
         * Constructs a pir
         * @param key the key
         * @param val the value
         */
        public Pair(K key, V val) {
            k = key;
            v = val;
        }

//        public boolean equals(Object obj) {
//            K key = ((Pair) obj).k;
//            return k.equals(key);
//        }
    }
}

