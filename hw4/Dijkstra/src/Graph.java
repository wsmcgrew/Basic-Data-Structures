package MainJava;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.*;
/**
 * This method build the map of the Algorithm 
 * using a hashmap with an Integer Key and a Node
 * Object.
 * 
 * @author William McGrew
 * @date: 5/11/17
 */
public class Graph {
    
    private HashMap<Integer, Node> theHasher;
    
    public Graph(String fileName) throws FileNotFoundException, IOException {
        this.theHasher = new HashMap<>();

	try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	 String tempLine;
			
            while((tempLine = br.readLine()) != null) {
                
		String[] tokens = tempLine.split(" ");
		int[] coords = new int[3];
                
		if(tokens[0].equals("a")) {
                    for(int i = 0; i < 3; i++) {
			coords[i] = Integer.parseInt(tokens[i+1]);
                    }// end for
                    
                    Node nodeOne, nodeTwo;
                    boolean oneTrue = false;
                    boolean twoTrue = false;
                    
                    //if the data exits, save it locally
                    //for Node one and Node two
                    if (theHasher.containsKey(coords[0])) {
                           nodeOne = new Node(coords[0]);
                    } else {
                        nodeOne = theHasher.get(coords[0]);
                        oneTrue = true;
                    }//end the check of node Two
                    
                    if (theHasher.containsKey(coords[1])) {
                        nodeTwo = new Node(coords[0]);
                    } else {
                        nodeTwo = theHasher.get(coords[0]);
                        twoTrue = true;
                    }// end the check of nodeTwo
                    
		}// end if
			
            }//end while
            
        } catch (Exception e) {
            System.out.println("Error Building Map");
            e.printStackTrace();
        }//end try catch
	
	
	}
}
