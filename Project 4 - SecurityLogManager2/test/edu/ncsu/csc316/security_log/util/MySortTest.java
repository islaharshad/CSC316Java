package edu.ncsu.csc316.security_log.util;

import static org.junit.Assert.*;



import org.junit.Test;

import edu.ncsu.csc316.security_log.info.Entry;



/**
 * Tests the three sort functions
 * @author Islahuddin Arshad
 *
 */
public class MySortTest {



//	/**
//	 * Tests the asort by action and resource, by time, and by time and name
//	 */
//	@Test
//	public void testAll() {
//		MyArrayList<Entry> e = new MyArrayList<Entry>();
//		e.insert(new Entry("jtking", "01/18/2018 01:22:21PM", "view", "prescription information"));
//		e.insert(new Entry("mbbrown", "01/18/2018 01:23:47PM", "create", "immunization order"));
//		e.insert(new Entry("ssoulcrusher", "01/18/2018 01:22:01PM", "delete", "prescription information"));
//		e.insert(new Entry("jdschmidt", "01/18/2018 01:24:21PM", "view", "prescription information"));
//		e.insert(new Entry("jtking", "01/18/2018 12:58:14PM", "delete", "demographics information"));
//		
//		MySort.mSByAR(e);
//		
//		assertEquals("create", ((Entry) e.get(0)).getAction());
//
//
//		MyArrayList<Entry> e1 = new MyArrayList<Entry>();
//		e1.insert(new Entry("jtking", "01/18/2018 01:22:21PM", "view", "prescription information"));
//		e1.insert(new Entry("mbbrown", "01/18/2018 01:23:47PM", "create", "immunization order"));
//		e1.insert(new Entry("ssoulcrusher", "01/18/2018 01:22:01PM", "delete", "prescription information"));
//		e1.insert(new Entry("jdschmidt", "01/18/2018 01:24:21PM", "view", "prescription information"));
//		e1.insert(new Entry("jtking", "01/18/2018 12:58:14PM", "delete", "demographics information"));
//		
//		MySort.mSByNameAndTime(e1);
//		assertEquals("jtking", ((Entry) e1.get(1)).getName());
//		assertEquals("01/18/2018 01:22:21PM", ((Entry) e1.get(2)).getTime().toString());
//		
//		
//		
//		MyArrayList<Entry> e2 = new MyArrayList<Entry>();
//		e2.insert(new Entry("jtking", "01/18/2018 01:22:21PM", "view", "prescription information"));
//		e2.insert(new Entry("mbbrown", "01/18/2018 01:23:47PM", "create", "immunization order"));
//		e2.insert(new Entry("ssoulcrusher", "01/18/2018 01:22:01PM", "delete", "prescription information"));
//		e2.insert(new Entry("jdschmidt", "01/18/2018 01:24:21PM", "view", "prescription information"));
//		e2.insert(new Entry("jtking", "01/18/2018 12:58:14PM", "delete", "demographics information"));
//		
//		MySort.mSByTime(e2);
//		
//		assertEquals("01/18/2018 01:22:01PM", ((Entry) e1.get(4)).getTime().toString());
//		
//		MyArrayList<Entry> entries = new MyArrayList<Entry>();
//		entries.insert(new Entry("somename", "02/01/1000 10:00:01AM", "a", "r"));
//		entries.insert(new Entry("somename", "02/01/1000 10:04:00AM", "a", "r"));
//		entries.insert(new Entry("somename", "03/01/1000 10:00:00AM", "a", "r"));
//		entries.insert(new Entry("somename", "02/01/1000 10:00:00AM", "a", "r"));
//		entries.insert(new Entry("somename", "02/01/1000 10:00:00PM", "a", "r"));
//
//		MySort.mSByTime(entries);
//
//		assertEquals("02/01/1000 10:00:00AM", ((Entry) entries.get(0)).getTime().toString());
//		assertEquals("02/01/1000 10:00:01AM", ((Entry) entries.get(1)).getTime().toString());
//		assertEquals("02/01/1000 10:04:00AM", ((Entry) entries.get(2)).getTime().toString());
//		assertEquals("02/01/1000 10:00:00PM", ((Entry) entries.get(3)).getTime().toString());
//		assertEquals("03/01/1000 10:00:00AM", ((Entry) entries.get(4)).getTime().toString());
//	
//	
//	}
	

	/**
	 * Tests the sorter's constructor
	 */
	@Test
	public void testMySort() {
		MySort sorter = new MySort();
		assertNotNull(sorter);
	}

	/**
	 * Tests mSByTime
	 */
	@Test
	public void testMSByTIme() {
		MyArrayList<Entry> logEntries = new MyArrayList<>();
		logEntries.insert(new Entry("n", "01/01/1000 12:00:01AM", "a", "r", 0));
		logEntries.insert(new Entry("n", "01/01/1000 12:04:00AM", "a", "r", 0));
		logEntries.insert(new Entry("n", "02/01/1000 12:00:00AM", "a", "r", 0));
		logEntries.insert(new Entry("n", "01/01/1000 12:00:00AM", "a", "r", 0));
		logEntries.insert(new Entry("n", "01/01/1000 12:00:00PM", "a", "r", 0));

		MySort.mSByTime(logEntries);

		assertEquals("01/01/1000 12:00:00AM", ((Entry) logEntries.get(0)).getTime().toString());
		assertEquals("01/01/1000 12:00:01AM", ((Entry) logEntries.get(1)).getTime().toString());
		assertEquals("01/01/1000 12:04:00AM", ((Entry) logEntries.get(2)).getTime().toString());
		assertEquals("01/01/1000 12:00:00PM", ((Entry) logEntries.get(3)).getTime().toString());
		assertEquals("02/01/1000 12:00:00AM", ((Entry) logEntries.get(4)).getTime().toString());
	}

	/**
	 * Tests mSByAR
	 */
	@Test
	public void testMSByAR() {
		MyArrayList<Entry> logEntries = new MyArrayList<>();
		logEntries.insert(new Entry("n", "01/01/1000 12:00:01AM", "b", "a", 0));
		logEntries.insert(new Entry("n", "01/01/1000 12:04:00AM", "c", "b", 0));
		logEntries.insert(new Entry("n", "02/01/1000 12:00:00AM", "b", "g", 0));
		logEntries.insert(new Entry("n", "01/01/1000 12:00:00AM", "c", "a", 0));
		logEntries.insert(new Entry("n", "01/01/1000 12:00:00PM", "a", "a", 0));

		MySort.mSByAR(logEntries);

		assertEquals("aa", ((Entry) logEntries.get(0)).getAction() + ((Entry) logEntries.get(0)).getResource());
		assertEquals("ba", ((Entry) logEntries.get(1)).getAction() + ((Entry) logEntries.get(1)).getResource());
		assertEquals("bg", ((Entry) logEntries.get(2)).getAction() + ((Entry) logEntries.get(2)).getResource());
		assertEquals("ca", ((Entry) logEntries.get(3)).getAction() + ((Entry) logEntries.get(3)).getResource());
		assertEquals("cb", ((Entry) logEntries.get(4)).getAction() + ((Entry) logEntries.get(4)).getResource());
	}

	/**
	 * Tests mSByNameAndTime
	 */
	@Test
	public void testMSByNameAndTime() {
		MyArrayList<Entry> logEntries = new MyArrayList<>();
		logEntries.insert(new Entry("c", "01/01/1000 12:00:00AM", "a", "r", 0));
		logEntries.insert(new Entry("c", "01/01/1000 12:00:01AM", "a", "r", 0));
		logEntries.insert(new Entry("a", "01/01/1000 12:00:00AM", "a", "r", 0));
		logEntries.insert(new Entry("a", "01/01/1000 01:00:00PM", "a", "r", 0));
		logEntries.insert(new Entry("c", "01/01/1000 12:00:01AM", "z", "z", 0));

		MySort.mSByNameAndTime(logEntries);

		assertEquals("a", ((Entry) logEntries.get(0)).getName());
		assertEquals("01/01/1000 12:00:00AM", ((Entry) logEntries.get(0)).getTime().toString());
		assertEquals("a", ((Entry) logEntries.get(1)).getName());
		assertEquals("01/01/1000 01:00:00PM", ((Entry) logEntries.get(1)).getTime().toString());
		assertEquals("c", ((Entry) logEntries.get(2)).getName());
		assertEquals("01/01/1000 12:00:00AM", ((Entry) logEntries.get(2)).getTime().toString());
		assertEquals("c", ((Entry) logEntries.get(3)).getName());
		assertEquals("01/01/1000 12:00:01AM", ((Entry) logEntries.get(3)).getTime().toString());
		assertEquals("c", ((Entry) logEntries.get(4)).getName());
		assertEquals("01/01/1000 12:00:01AM", ((Entry) logEntries.get(4)).getTime().toString());
		assertEquals("z", ((Entry) logEntries.get(4)).getAction());
	}

}
