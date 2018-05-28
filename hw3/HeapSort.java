//package javaApplication3;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**This program reads in a generic ArrayArrayList<>
 * and returns a sorted list using the HeapSort
 * data structure
 * 
 * @author William McGrew
 * @version 04/26/17
 */

public class HeapSort<T> {

    

    /** This methhod does the initialization of the sorting list
	 * including building the heap followed by sorting it
     *
     * @param <T>
     * @param input
     * @return
     */

    public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> input) 
    {
        ArrayList<T> sortedArrayList = new ArrayList<>(input);
        //Builds the Heap
        for (int i = 1; i < sortedArrayList.size(); i++) {
            sortedArrayList = percUp(sortedArrayList, i);
        }
        //Sorts the heap
        for (int i = sortedArrayList.size() - 1; i >= 1; i--) {
            sortedArrayList = swap(sortedArrayList, 0, i);
            sortedArrayList = percDown(sortedArrayList, i - 1);
        }
        return sortedArrayList;
    }
    
    /* This program Percolates up through the HeapSort tree for Insertion
     * or deletion.
     *
     * @param ArrayList<T>   Local data structure
     * @param Int n     Index to be perc up
     * @return ArrayList<T>  Datasturcture percolated 
     */

    private static <T extends Comparable<T>> ArrayList<T> percUp(ArrayList<T> input, int n) {
        
        for (int i = n;;) {
            if (i == 0) {
                break;
            } 
            int p = i / 2;
            if (input.get(p).compareTo(input.get(i)) >= 0) {
                break;
            }
            input = swap(input, i, p);
            i = p;
        }
        return input;
    }
    
     /* This method Percolates Down through the HeapSort tree for Insertion
     * or deletion.
     *
     * @param ArrayList<T>   Local data structure
     * @param Int n     Index to be perc down
     * @return ArrayList<T>  Datasturcture percolated 
     */

    private static <T extends Comparable<T>> ArrayList<T> percDown(ArrayList<T> input, int n) {
        //Loop through intil a break point is hit
        for (int i = 0;;) {
            int child = 2 * (i + 1) - 1;
            // checks the size of the stucture
            if (child > n) {
                break;
            }
            if (child + 1 <= n) {
                //if they are equal c will e incremented by 1
                if (input.get(child + 1).compareTo(input.get(child)) > 0) {
                    child += 1;
                }
            }
            //Checks i as if it were the left child
            if (input.get(i).compareTo(input.get(child)) >= 0) {
                break;
            }
            input = swap(input, i, child);
            i = child;
        }
        return input;
    }
    
    /* This method reads in a ArrayList<> and two integers to swap.
     * then return the altered data structure to the caller
     *
     * @param ArrayList<T>   Local Data Sturcture
     * @param 2 Ints to be swaped
     * @require     A ArrayList<> and 2 Ints
     */
    private static <T extends Comparable<T>> ArrayList<T> swap (ArrayList<T> stuff, int top, int bottom) {
        
        T tmp = stuff.get(bottom);
        stuff.set(bottom, (stuff.get(top)));
        stuff.set(top, tmp);
        return stuff;
    }//end swap
    /*
	 * Main runner Method that that reads in the test
	 * file and prints the sorted file
	 */
    public static void main(String[] args) {
        ArrayList<String> fileList = new ArrayList<>();
        ArrayList<String> sorted = new ArrayList<>();
    
        try {
            //FileReader name = new FileReader("Test.txt");
            BufferedReader inFile = new BufferedReader(new FileReader("Test.txt"));
            
            String nullTemp;
            while((nullTemp = inFile.readLine()) != null) {
				fileList.add(nullTemp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find file.\n");
        } catch (IOException e) {
            System.out.println("rable rable\n");
        }//end catch
        
        ArrayList<String> sort = new ArrayList<>(); 
        sorted = HeapSort.heapSort(fileList);
        
        for (int i = 0; i < fileList.size(); i++) {
            System.out.println(sorted.get(i));
        }
    }   //  end main
}//end HeapSort