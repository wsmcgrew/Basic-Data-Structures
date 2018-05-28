package MainJava;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This program reads in a .gr file and uses dijkstra's algorithm
 * to find the closest path of a source and a target node
 *
 * @author William McGrew
 * @date: 05/11/17
 */

public class FindShortestRoadPath {

    
    public static void main(String[] arg) {
            try {
                Graph mainGraph = new Graph(arg[0]);
            } catch (IOException ex) {
                Logger.getLogger(FindShortestRoadPath.class.getName()).log(Level.SEVERE, null, ex);
            }
            int source = Integer.parseInt(arg[1]);
            int target = Integer.parseInt(arg[2]);
        }//end main method
        
    public static int comparePath(Node n1, Node n2) {
        
            double vertOne = n1.getDist();
            double vertTwo = n2.getDist();
            if (vertTwo < vertOne) {
                return 1;
            } else if (vertTwo > vertOne) {
                return -1;
            } else {
                return 0;
            }
                
                
        }// end method comparePath
    
    public static void getNeighbors(Node node) {
        ArrayList<Adj> adjNodes = node.getNodeAdj();
        node.setKnown(true);
        
        for(int i = 0; i < adjNode.size(); i++) {
            
        }
    }

}// end class
