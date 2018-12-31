package edu.ncsu.csc316.rentals.manager;

import java.util.Iterator;

import edu.ncsu.csc316.rentals.io.RentalReader;
import edu.ncsu.csc316.rentals.resource.BuildGraph;
import edu.ncsu.csc316.rentals.resource.EdgeEntry;
import edu.ncsu.csc316.rentals.resource.VertexDay;
import edu.ncsu.csc316.rentals.sorter.MergeSort;
///import edu.ncsu.csc316.rentals.util.MinHeapForEdgeEntry;
import edu.ncsu.csc316.rentals.util.MinHeapForVertexDay;
import edu.ncsu.csc316.rentals.util.MyArrayList;
//import edu.ncsu.csc316.rentals.util.MyNormalDictionary;
import edu.ncsu.csc316.rentals.util.MySplayDictionary;

/**
 * The manager gets the shortest rental cost and days required for a rental and
 * queries all the cars for start days
 * 
 * @author Islahuddin Arshad
 *
 */
public class VehicleRentalManager {

	/** The rental reader object */
	public RentalReader rR;
	/** Edge lis of containing all the graph's edges */
	public MyArrayList<EdgeEntry> edgeList;
	/** Dictionary for Dijkstra traversal */
	public MySplayDictionary dijkstraDictionary;
	/** The graph of the vehicle rentals */
	public BuildGraph graph;
	/** The graph size */
	public int graphSize;
	/** The primary stringbuilder for getRentals */
	public StringBuilder remSb;
	/** Whether the days asked for are more than graph handling */
	public boolean overflow = false;
	/** Whether start overflows or not */
	public boolean startOverflow = false;
	/** The total cost of all car rentals */
	public int total;
	/** The distances of each edge node */
	public int[] distances;
	/** The parents of each edge node */
	public int[] parents;
	/** The mergesort to query */
	public MergeSort sort;

	/**
	 * Constructs a new Rental manager with the given input files
	 * 
	 * @param pathToFile
	 *            - the path to the employee input file
	 */
	public VehicleRentalManager(String pathToFile) {

		rR = new RentalReader(pathToFile);
		edgeList = rR.readRental(pathToFile);

	}

	/**
	 * Returns the String representation of the rentals that are available for
	 * the requested day.
	 *
	 * @param day
	 *            - the day for which to retrieve available rentals
	 * @return the String representation of the rentals
	 */
	public String getRentalsForDay(int day) {

		System.out.println("GetRentalsForDay " + day);
		StringBuilder string = new StringBuilder();

		// populate secondEdgeList with right entries
		MyArrayList<EdgeEntry> secondEdgeList = new MyArrayList<EdgeEntry>();
		for (int m = 0; m < edgeList.getSize() - 1; m++) {
			secondEdgeList.insert(edgeList.get(m));
		}

		boolean found = true;
		sort = new MergeSort();
		// mergesort by first day
		MyArrayList<EdgeEntry> finalList = sort.mergeSort(secondEdgeList);
		MyArrayList<EdgeEntry> returnList = new MyArrayList<EdgeEntry>();

		System.out.println("Startday :");
		System.out.println("Endday :");
		System.out.println("Values in graph:");

		for (int a = 0; a < finalList.getSize(); a++) {
			System.out.println(((EdgeEntry) finalList.get(a)).getStartDay() + ","
					+ ((EdgeEntry) finalList.get(a)).getEndDay() + "," + ((EdgeEntry) finalList.get(a)).getCost() + ","
					+ ((EdgeEntry) finalList.get(a)).getMake() + "," + ((EdgeEntry) finalList.get(a)).getModel());

		}
		/// decrement 1 from day
		day--;

		int counter = 0;
		while (counter < finalList.getSize()) {
			EdgeEntry entry = (EdgeEntry) finalList.get(counter);
			if (entry.getStartDay() != day) {
				counter++;
			} else {
				break;
			}
		}

		if (counter == finalList.getSize()) {
			found = false;
		}

		while (counter < finalList.getSize() && ((EdgeEntry) finalList.get(counter)).getStartDay() == day) {

			returnList.insert(finalList.get(counter));
			counter++;
		}

		string.append("Available rentals for day ");
		string.append(day + 1);
		string.append("\n"); // removed the bracket
		if (found) {

			/// sort by increasing cost
			/// if same, sort by make and model

			//////

			sort.mSMakeAndModel(returnList);

			System.out.println("Return List after Sort :" + returnList.getSize());

			for (int a = 0; a < returnList.getSize(); a++) {
				System.out.println(((EdgeEntry) returnList.get(a)).getStartDay() + ","
						+ ((EdgeEntry) returnList.get(a)).getEndDay() + "," + ((EdgeEntry) returnList.get(a)).getCost()
						+ "," + ((EdgeEntry) returnList.get(a)).getMake() + ","
						+ ((EdgeEntry) returnList.get(a)).getModel());

			}

			//
			// Available Rentals for day 1
			// $85.00 Chevrolet Tahoe for day 1 to day 2
			// $180.00 Chevrolet Silverado for day 1 to day 3
			// $255.00 Toyota Prius for day 1 to day 4
			// $500.00 Honda CRV for day 1 to day 5
			// StringBuilder sReturn = new StringBuilder();

			for (int a = 0; a < returnList.getSize(); a++) {
				string.append("   $");
				/// gets the cost
				string.append(((EdgeEntry) returnList.get(a)).getCost());

				string.append(".00 ");
				string.append(
						((EdgeEntry) returnList.get(a)).getMake() + " " + ((EdgeEntry) returnList.get(a)).getModel());
				string.append(" for day ");
				string.append(((EdgeEntry) returnList.get(a)).getStartDay() + 1);
				string.append(" to day ");
				string.append(((EdgeEntry) returnList.get(a)).getEndDay() + 1);
				string.append("\n");
			}

			// MyNormalDictionary cost = new MyNormalDictionary();
			// String make = "";
			// String model = "";
			//
			//
			//
			//
			// MySplayDictionary splayer = new MySplayDictionary();
			//
			// for (int p = 0; p < returnList.getSize(); p++) {
			// splayer.insert(((EdgeEntry) returnList.get(p)).getMake() + " " +
			// ((EdgeEntry) returnList.get(p)).getModel(), (EdgeEntry)
			// returnList.get(p));
			// }
			//
			// for (int m = 0; m < returnList.getSize(); m++) {
			// if (!((EdgeEntry) returnList.get(m)).getMake().equals(make) ||
			// !((EdgeEntry) returnList.get(m)).getModel().equals(model)) {
			// if (make.length() != 0) {
			// cost.putHere(new StringBuilder()
			// .append(make)
			// .append(" ")
			// .append(model)
			// .toString(), splayer.getDictObject(make + " " +
			// model).getCost());
			//
			// }
			// make = ((EdgeEntry) returnList.get(m)).getMake();
			// model = ((EdgeEntry) returnList.get(m)).getModel();
			// }
			//
			// }
			//
			// if (returnList.getSize() != 0) {
			// cost.putHere(make + " " + model, splayer.getDictObject(make + " "
			// + model).getCost());
			// }
			//
			//
			// cost.mSorter();
			//
			//
			// for (int k = 0; k < cost.getSize(); k++) {
			// string.append(" $");
			// ///gets the cost
			// string.append(cost.getValueFrom(k));
			//
			// string.append(".00 ");
			// string.append(cost.getKeyFrom(k));
			// string.append(" for day ");
			// string.append(day + 1);
			// string.append(" to day ");
			// string.append(splayer.getDictObject(cost.getKeyFrom(k)).getEndDay()
			// + 1);
			// string.append("\n");
			// }
			//
			///////
			//
			//

			string.append("]");

		} else {

			string.append("   No rentals available.\n");
			string.append("]");
		}

		return string.toString();

	}

	/**
	 * Returns the String representation of the rentals that minimize the total
	 * cost from the start day to the end day (or for as many days from the
	 * start day while rentals are possible).
	 * 
	 * @param start
	 *            - the start day as an integer
	 * @param end
	 *            - the end day as an integer
	 * @return the String representation of the rentals
	 */
	public String getRentals(int start, int end) {
		total = 0;
		/// build a graph and dictionary
		graphSize = ((EdgeEntry) edgeList.get(edgeList.getSize() - 1)).getEndDay() + 1;
		graph = new BuildGraph(graphSize);
		// build dictionary
		dijkstraDictionary = new MySplayDictionary();
		for (int i = 0; i < edgeList.getSize() - 1; i++) {
			graph.insertEdgeEntry((EdgeEntry) edgeList.get(i));

			dijkstraDictionary.insert(Integer.toString(((EdgeEntry) edgeList.get(i)).getStartDay())
					+ Integer.toString(((EdgeEntry) edgeList.get(i)).getEndDay()), (EdgeEntry) edgeList.get(i));

		}

		//
		// System.out.println("Startday :" + start);
		// System.out.println("Endday :" + end);
		// System.out.println("Values in graph:");
		//
		// for (int a = 0; a < edgeList.getSize() - 1; a++) {
		// System.out.println(((EdgeEntry) edgeList.get(a)).getStartDay() + ","
		// +
		// ((EdgeEntry) edgeList.get(a)).getEndDay() + "," + ((EdgeEntry)
		// edgeList.get(a)).getCost() +
		// "," + ((EdgeEntry) edgeList.get(a)).getMake() + "," + ((EdgeEntry)
		// edgeList.get(a)).getModel());
		//
		// }

		/// Handling if rental days are exceeded
		remSb = new StringBuilder();

		if (start >= graphSize) {
			startOverflow = true;
			graphSize = start;
			remSb.append("Rental total is $0.00\n[\n");
			remSb.append("   No rentals available on day " + graphSize);
			remSb.append("\n]");
			return remSb.toString();

		}

		if (end > graphSize) {
			overflow = true;
			end = graphSize;
			remSb.append("   ");
			remSb.append("No rentals available on day ");
			remSb.append(graphSize);
			remSb.append("\n");
		}

		return getDijkstra(graph, start - 1, end - 1);
	}
	// MyArrayList<MinHeapForEdgeEntry> Settled,UnSettled;
	// private String getDijkstraNew(BuildGraph g,int startDay, int endDay)
	// {
	// Settled = new MyArrayList<MinHeapForEdgeEntry>();
	// UnSettled = new MyArrayList<MinHeapForEdgeEntry>();
	// distances = new int[g.getVertexCount()];
	// for (int i = 0; i < g.getVertexCount(); i++) {
	// distances[i] = Integer.MAX_VALUE;
	//
	// }
	// int iStrt = g.getVertexIndexByStartday(startDay);
	// if(iStrt == -1){
	// // not found
	// }
	// MinHeapForEdgeEntry eStart = g.neighbor(iStrt);
	//
	// UnSettled.insert(eStart);
	// distances[iStrt] = 0;
	// while(UnSettled.d)
	// /*
	// Foreach node set distance[node] = HIGH
	// SettledNodes = empty
	// UnSettledNodes = empty
	//
	// Add sourceNode to UnSettledNodes
	// distance[sourceNode]= 0
	//
	// while (UnSettledNodes is not empty) {
	// evaluationNode = getNodeWithLowestDistance(UnSettledNodes)
	// remove evaluationNode from UnSettledNodes
	// add evaluationNode to SettledNodes
	// evaluatedNeighbors(evaluationNode)
	// }
	//
	// getNodeWithLowestDistance(UnSettledNodes){
	// find the node with the lowest distance in UnSettledNodes and return it
	// }
	//
	// evaluatedNeighbors(evaluationNode){
	// Foreach destinationNode which can be reached via an edge from
	// evaluationNode AND which is not in SettledNodes {
	// edgeDistance = getDistance(edge(evaluationNode, destinationNode))
	// newDistance = distance[evaluationNode] + edgeDistance
	// if (distance[destinationNode] > newDistance ) {
	// distance[destinationNode] = newDistance
	// add destinationNode to UnSettledNodes
	// }
	// }
	// }
	// */
	// return "";
	// }

	/**
	 * Runs the Dijkstra algorithm for a graph and start and end day to get the
	 * shortest path to be returned as a string
	 * 
	 * @param g
	 *            the graph to traverse
	 * @param startDay
	 *            the start point to look for
	 * @param endDay
	 *            the end point to look for
	 * @return String the string representation for the traversals
	 */
	private String getDijkstra(BuildGraph g, int startDay, int endDay) {

		StringBuilder finalOutput = new StringBuilder();

		MyArrayList<EdgeEntry> pathEdges = new MyArrayList<EdgeEntry>();
		distances = new int[g.getVertexCount()];
		parents = new int[g.getVertexCount()];

		for (int i = 0; i < g.getVertexCount(); i++) {
			parents[i] = -1;
			distances[i] = Integer.MAX_VALUE;
			// if (i == 0)
			// {
			// distances[0] = 0;
			// }
			pathEdges.insert(null);
		}
		distances[startDay] = 0;

		//// Q == heapVertex
		MinHeapForVertexDay heapVertex = new MinHeapForVertexDay();
		for (int i = startDay; i < g.getVertexCount(); i++) { // made changes
																// from i = 0
			if (i != startDay) {
				heapVertex.insert(new VertexDay(i));
			}
		}

		VertexDay node = new VertexDay(startDay);
		node.setDist(0);
		heapVertex.insert(node);

		while (!heapVertex.isEmpty()) {
			VertexDay u = heapVertex.deleteMinimum();

			Iterator<EdgeEntry> it = g.neighbor(u.getId()).iterator();
			while (it.hasNext()) {
				EdgeEntry e = it.next();
				Iterator<VertexDay> it2 = heapVertex.iterator();
				while (it2.hasNext()) {
					VertexDay v = it2.next();
					if (e.getEndDay() != v.getId()) {
						continue;
					}
					// int length = getLength(u);
					// if (distances[v.getId()] > length + e.getCost()) {
					// v.setDist(length + e.getCost());
					// distances[v.getId()] = length + e.getCost();
					// v.setParent(u);
					// parents[v.getId()] = v.getParent().getId();
					int length = distances[u.getId()] + e.getCost();
					if (distances[v.getId()] > length) {
						v.setDist(length);
						distances[v.getId()] = length;
						v.setParent(u);
						parents[v.getId()] = u.getId();
						pathEdges.setAt(v.getId(), e);
					}
					// else {
					// int nParent = parents[v.getId()];
					// Iterator<EdgeEntry> it3 = g.neighbor(nParent).iterator();
					// while (it3.hasNext()) {
					// EdgeEntry ec = it3.next();
					// if(ec.getEndDay()==v.getId()) {
					// pathEdges.setAt(v.getId(), ec);
					// }
					// }
					//
					// }
				}
			}
		}

		System.out.println("Path collected :" + pathEdges.getSize() + " for " + startDay + " to " + endDay);
		for (int a = 0; a < pathEdges.getSize(); a++) {
			if (pathEdges.get(a) == null) {
				System.out.println("NULL");
				continue;
			}
			System.out.println(((EdgeEntry) pathEdges.get(a)).getStartDay() + ","
					+ ((EdgeEntry) pathEdges.get(a)).getEndDay() + "," + ((EdgeEntry) pathEdges.get(a)).getCost() + ","
					+ ((EdgeEntry) pathEdges.get(a)).getMake() + "," + ((EdgeEntry) pathEdges.get(a)).getModel());
		}

		MyArrayList<EdgeEntry> pathFinalEdges = new MyArrayList<EdgeEntry>();
		int nCurDay = endDay;
		int sum = 0;
		while (nCurDay != startDay) {
			if (pathEdges.get(nCurDay) == null) {
				break;
			}
			pathFinalEdges.insert(0, pathEdges.get(nCurDay));

			sum += ((EdgeEntry) pathFinalEdges.get(0)).getCost();
			nCurDay = parents[nCurDay];
		}

		System.out.println("Path found :" + pathFinalEdges.getSize() + " for " + startDay + " to " + endDay);

		for (int a = 0; a < pathFinalEdges.getSize(); a++) {
			// if(pathFinalEdges.get(a) == null)
			// {
			// System.out.println("NULL");
			// continue;
			// }
			// System.out.println(((EdgeEntry)
			// pathFinalEdges.get(a)).getStartDay() + "," +
			// ((EdgeEntry) pathFinalEdges.get(a)).getEndDay() + "," +
			// ((EdgeEntry) pathFinalEdges.get(a)).getCost() +
			// "," + ((EdgeEntry) pathFinalEdges.get(a)).getMake() + "," +
			// ((EdgeEntry) pathFinalEdges.get(a)).getModel());
			//

			finalOutput.append("   From day ");
			finalOutput.append(((EdgeEntry) pathFinalEdges.get(a)).getStartDay() + 1);
			finalOutput.append(" to day ");
			finalOutput.append(((EdgeEntry) pathFinalEdges.get(a)).getEndDay() + 1);
			finalOutput.append(": $");
			finalOutput.append(((EdgeEntry) pathFinalEdges.get(a)).getCost());
			finalOutput.append(".00, ");
			finalOutput.append(((EdgeEntry) pathFinalEdges.get(a)).getMake());
			finalOutput.append(" ");
			finalOutput.append(((EdgeEntry) pathFinalEdges.get(a)).getModel());
			finalOutput.append("\n");

		}

		StringBuilder finalSb = new StringBuilder();

		if (startOverflow) {
			finalSb.append(remSb.toString());
			return finalSb.toString();
		}

		// finalOutput = outputAlgo(endDay);

		finalSb.append("Rental total is $" + sum);
		finalSb.append(".00");
		finalSb.append("\n[\n");
		finalSb.append(finalOutput.toString()); /// end day

		if (overflow) {
			finalSb.append(remSb.toString());
		}

		finalSb.append("]");

		return finalSb.toString();
	}

	/**
	 * Gets the length of vertex
	 * 
	 * @param day
	 *            vertex representing the day
	 * @return int the length of the vertex
	 */
	public int getLength(VertexDay day) {
		// int sum = 0;
		//
		// if (day != null && day.getId() != 0 )
		// {
		// sum += distances[day.getId()];
		// day = day.getParent();
		// }
		// return sum;
		int sum = 0;

		if (day == null) {
			return -1;

		}
		while (day != null && parents[day.getDist()] != 0) {
			sum += distances[day.getId()];
			day = day.getParent();
		}
		return sum;
	}

	// /**
	// * Outputs the rental algorithm in the correct manner
	// * @param endDay the endday to which the alogorithm executes
	// * @return String the string output for rentals
	// */
	// public String outputAlgo(int endDay) {
	// StringBuilder sb = new StringBuilder();
	//
	//
	// sb.append(" From day ");
	// sb.append(Integer.toString(parents[endDay] + 1));
	// sb.append(" to day ");
	// sb.append(Integer.toString(endDay + 1));
	// sb.append(":");
	// sb.append(" $");
	// sb.append(distances[endDay] - distances[parents[endDay]]);
	// sb.append(".00, ");
	// sb.append(dijkstraDictionary.getMakeFromDict(Integer.toString(parents[endDay])
	// + Integer.toString(endDay)));
	// sb.append(" ");
	// sb.append(dijkstraDictionary.getModelFromDict(Integer.toString(parents[endDay])
	// + Integer.toString(endDay)));
	//// if (!overflow) {
	//// total += distances[endDay] - distances[parents[endDay]];
	//// }
	// total += distances[endDay] - distances[parents[endDay]];
	// int ch = 1;
	// while (ch == 1) {
	// sb.append("\n");
	// ch--;
	// }
	//
	// if (parents[parents[endDay]] == -1) {
	// return sb.toString();
	// }
	//
	// return outputAlgo(parents[endDay]) + sb.toString();
	// }
	//
	//

}
