package edu.ncsu.csc316.rentals.resource;

/**
 * This class makes the vertex object for the graph
 * @author Islahuddin Arshad
 *
 */
public class VertexDay implements Comparable {

    /*The distance*/
    private int dist;
    /*The vertex*/
    private VertexDay p;
    /*The id of vertex*/
    private int id;

    /**
     * Constructor for Vertex
     */
    public VertexDay() {
        dist = Integer.MAX_VALUE;
        p = null;
    }

    /**
     * Constructor for vertex created at a given ID
     * @param id the id of the vertex
     */
    public VertexDay(int id) {
        this.id = id;
        dist = Integer.MAX_VALUE;
        p = null;
    }

    /**
     * Getter for the id
     * @return int the id of the vertex
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the vertex
     * @param id the id of the vertex
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the distance of the vertex
     * @return int the distance of the vertex
     */
    public int getDist() {
        return dist;
    }

    /**
     * Sets the distance of the vertex
     * @param dist the distance to set
     */
    public void setDist(int dist) {
        this.dist = dist;
    }

    /**
     * Gets the parent of the vertex
     * @return VertexDay the vertex of the graph
     */
    public VertexDay getParent() {
        return p;
    }

    /**
     * Sets parent of the vertex
     * @param parent the parent of the vertex
     */
    public void setParent(VertexDay parent) {
        this.p = parent;
    }


	/**
	 * The compare to method
	 * @param o the object to compare
	 * @return int the compare to number
	 */
	public int compareTo(Object o) {
		VertexDay other = (VertexDay) o;
		return Integer.compare(this.dist, other.dist);
	}

}