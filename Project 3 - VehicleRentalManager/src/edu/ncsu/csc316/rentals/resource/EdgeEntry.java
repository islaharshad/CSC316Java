package edu.ncsu.csc316.rentals.resource;


/**
 * Creates and edge
 * @author Islahuddin Arshad
 *
 */
public class EdgeEntry {

    /**The start day*/
    public int startDay;
    /**The end day*/
    public int endDay;
    /**The cost of each car*/
    public int cost;
    /**The make of a car*/
    public String make;
    /**The model of a car*/
    public String model;

    /**
     * Creates a new edge object
     * @param startDay the start day of rental
     * @param endDay the end day of rental
     * @param cost the cost of rental
     * @param make the make of the car
     * @param model the model of the car
     */
    public EdgeEntry(int startDay, int endDay, int cost, String make, String model) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.cost = cost;
        this.make = make;
        this.model = model;
    }

    /**
     * Gets the start day
     * @return in the start day
     */
    public int getStartDay() {
        return startDay;
    }
    /**
     * Getter for the end day
     * @return int the end day
     */
    public int getEndDay() {
        return endDay;
    }
    /**
     * Getter for the cost
     * @return int the cost of the car
     */
    public int getCost() {
        return cost;
    }

    /**
     * Getter for make of the car
     * @return String the make of the car
     */
    public String getMake() {
        return make;
    }

    /**
     * Getter for the model of the car
     * @return String the model of the car
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for the start day
     * @param startDay the start day to set
     */
    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    /**
     * Setter for the end day
     * @param endDay the end day to set
     */
    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    /**
     * Setter for the cost of the car
     * @param cost the cost of the car
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Setter for the make of the car
     * @param make the make of the car
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Setter for the model of the car
     * @param model the model of the car to be set
     */
    public void setModel(String model) {
        this.model = model;
    }


	/**
	 * Checks if the start day and the end day are the same
	 * @param o the edge
	 * @return boolean if the subsequent object is the same as compared object
	 */
	public boolean equals(Object o) {
		EdgeEntry other = (EdgeEntry) o;
		if (this.startDay == other.startDay && this.endDay == other.endDay) {
				return true;
			
		}
		return false;
	}

    /**
     * Compares the two objects
     * @param o the object to compare to
     * @return int positive if first object bigger, negative otherwise, zero if equal
     */
    public int compareTo(Object o) {
        EdgeEntry other = (EdgeEntry) o;
        return Integer.compare(this.getCost(), other.getCost());
    }

//    /**
//     * Strings the edge representation
//     */
//    public String toString() {
//        return startDay + "-" + endDay + " (" + cost + ") ";
//    }
}