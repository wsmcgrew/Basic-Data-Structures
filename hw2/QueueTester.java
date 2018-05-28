import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;

public class QueueTester {
	Queue<Integer> testOne;
	Queue<String> testTwo;

	@Before
	public void setup() {
		testOne = new Queue();
		testTwo = new Queue();
		
	//populates the Integer queue
		testOne.enqueue(21);
		testOne.enqueue(54);
		testOne.enqueue(2002);
		testOne.enqueue(88);
		testOne.enqueue(25);
		testOne.enqueue(187945);
		
	}//end setup method
	
	/**
	 * tests the Dequeue Methods
	 **/

	@Test
	public void integerTest() {
	//EnqueueTest of Integers
		assertEquals((Integer)21, testOne.dequeue());
		assertEquals((Integer)54, testOne.dequeue());
		assertEquals((Integer)2002, testOne.dequeue());
		assertEquals((Integer)88, testOne.dequeue());
		assertEquals((Integer)25, testOne.dequeue());
		assertEquals((Integer)187945, testOne.dequeue());
		
		try {
			testOne.dequeue();
		} catch (NoSuchElementException e) {
			assertTrue(e instanceof NoSuchElementException);
		}
	}//end integerTest
	
	/**
	 * Test the enqueue and dequeue with Strings
	 */
	@Test
	public void stringTest() {
	//populates the String queue
		testTwo.enqueue("can");
		testTwo.enqueue("we");
		testTwo.enqueue("build");
		testTwo.enqueue("it");
		testTwo.enqueue("yes");
		testTwo.enqueue("we");
		testTwo.enqueue("can");

	//DequeueTest of Strings
		assertEquals("can", testTwo.dequeue());	
		assertEquals("we", testTwo.dequeue());	
		assertEquals("build", testTwo.dequeue());	
		assertEquals("it", testTwo.dequeue());	
		assertEquals("yes", testTwo.dequeue());	
		assertEquals("we", testTwo.dequeue());	
		assertEquals("can", testTwo.dequeue());	
		
		try {
			testTwo.dequeue();
		} catch (NoSuchElementException e) {
			assertTrue(e instanceof NoSuchElementException);
		}
	}//end method enqueue
}