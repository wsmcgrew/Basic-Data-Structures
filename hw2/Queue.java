
import java.util.*;

/**
 * This program creates a generic class to build a circular array
 * and implement all of the qualities of a basic queue
 *
 * @author William
 * @Version: 2/21/17
 */

public class Queue<T> {
    
    private int dequeue;
    private int enqueue;
    private int size;
    private T[] stuff;

    /**Constuctor initializes 
     * the Queue class
     * 
     * @param size -- size of array
     */
    public Queue() {
        this.size = 8;
        this.enqueue = this.dequeue = 0;
		stuff = (T[]) new Object[this.size];
    }// end constructor
	
	/**
	* This element adds a T object to the array as the 
	* enqueue (tail) of the array
	* 
	* @param T -- an element that wants to be added to the queue
	*/
    
    public void enqueue(T element) {
        if(this.isFull()) {
            //some stuff to do if the arfullray is 
        } else {
            stuff[enqueue] = element;
            this.enqueue = (this.enqueue + 1) % this.size;//increments enqueue and tells the element to wrap around
            //if it is the last element in the array/

        }
    }//end method enQueue

    /**
     * This method removes and element from the dequeue (head) of the array
     *
     * @return T -- this returns the element that was removed from the array
     */
    
    public T dequeue() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("There is nothing in the Queue");
        } else {
            T deQueTemp = this.stuff[dequeue];
            remove(dequeue);
            this.dequeue = (this.dequeue + 1) % size;//increments dequeue and tells the element to wrap around
            //if it is the last element in the array/
            return deQueTemp;
        }
    }//end method deQueue

    /**Removes the contents of the dequeue head index
     * by setting the index value to null.
     * 
     * @param k -- index to remove
     */

    public void remove(int k) {
        stuff[k] = null;
    }//end method remove

    /**Qwery method to get size of array
     * 
     * @return int -- current size of
     */

    public int getSize() {
        return this.size;
    }// end getSize method
    /**
     * This method returns the current size of the Array 
     *
     * @param i -- takes int to check at index
     * @return boolean -- if empty
     */

    public boolean isEmpty() {
        if(this.enqueue == this.dequeue){
               return true;
        }
        return false;
    }//end isEmpty method
    
    /**
     * This method lets the caller look into the dequeue (head) of the array
     * to determine if it needs to be removed
     *
     * @return T -- returns the Object that is in the head of the array
     */

    public T peek(int j) {
        return this.stuff[dequeue];
    }//end peek

    /**This determines if the array is full and
     * is actually able to modular over the array
     * 
     * @return boolean -- true if full otherwise false
     */

    public boolean isFull() {
        if((this.enqueue + 1) % this.size == this.dequeue) {
            return true;
        } else {
            return false;
        }
    }//end isFull
}// end class Queue