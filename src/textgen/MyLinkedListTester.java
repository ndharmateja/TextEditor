/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> emptyList1;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		emptyList1 = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		
		try {
			list1.remove(4);
			fail("index greater than or equal to size check");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.remove(-1);
			fail("index less than 0 check");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		assertEquals("Remove: check connections ", list1.head, list1.head.next.prev);
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        try {
        	list1.add(null);
        	fail("Check null pointer");
        }
        catch(NullPointerException e) {
        }
        
        list1.add(55);
        assertEquals("Added 55: check size", 4, list1.size);
        assertEquals("Added 55: last element", (Integer)55, list1.get(3));
        assertEquals("Added 55: 3rd element", (Integer)42, list1.get(2));
        
        emptyList1.add(10);
        assertEquals("Adding to empty list", (Integer)10, emptyList1.get(0));
        
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		return;
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
		
        try {
        	list1.add(1, null);
        	fail("Check null pointer");
        }
        catch (NullPointerException e) {
        	
        }
        
        try {
        	list1.add(-1, 10);
        	fail("index less than 0 check");
        }
        catch (IndexOutOfBoundsException e) {
        	
        }
        
        try {
        	list1.add(4, 10);
        	fail("index greater than or equal to size check");
        }
        catch (IndexOutOfBoundsException e) {
        	
        }
        
        list1.add(1, 55);
        assertEquals("Added 55 at 1: check size", 4, list1.size);
        assertEquals("Added 55 at 1: added element", (Integer)55, list1.get(1));
        assertEquals("Added 55 at 1: previous element", (Integer)65, list1.get(0));
        assertEquals("Added 55 at 1: next element", (Integer)21, list1.get(2));
        
       
        emptyList1.add(0, 22);
        assertEquals("Added 22 at 0 empty list: check size", 1, emptyList1.size);
        assertEquals("Added 22 at 0 empty list: added element", (Integer)22, emptyList1.get(0));
        
        shortList.add(2, "C");
        assertEquals("Added \"C\" at the end to short list", "C", shortList.get(2));        
		
        
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		try {
			list1.set(4, 100);
			fail("index greater than or equal to size check");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(-1, 100);
			fail("index less than 0 check");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(2, null);
			fail("null pointer check");
		}
		catch (NullPointerException e) {
			
		}
		
		list1.set(0, 100);
		list1.set(2, 101);
		assertEquals("check size", 3, list1.size);
        assertEquals("first element after set", (Integer)100, list1.get(0));
        assertEquals("last element after set", (Integer)101, list1.get(2));
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
