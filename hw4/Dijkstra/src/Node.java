package MainJava;
import java.util.ArrayList;
/**
 * This is to help keep track of the currNodes
 * this has an arrayList of adjacent with assigned weights
 * 
 * @author William
 * @date: 5/11/17
 * @param Int to setID
 */

    
public class Node {
    
    private int id;
    private boolean known;
    private ArrayList<Adj> adjacent;
    private double minDist;
    private Node prevNode;
    
    public Node(int inId) {
        id = inId;
        known = false;
        minDist = Double.MAX_VALUE;
        prevNode = null;
    }// end constructor
    
    public double getDist() {
        return this.minDist;
    }//and getDist
    
    public boolean isknown() {
        return this.known;
    }//return isknown
    
    public Node getPrev() {
        return this.prevNode;
    }//end getPrev
    
    public int getId() {
        return this.id;
    }//end getId
    
    public ArrayList<Adj> getNodeAdj() {
        return this.adjacent;
    }
    
    public void addAdjacent(Adj newAdj) {
        adjacent.add(newAdj);
    }// and add Adjacent

    public void setDist(Double newDist) {
        minDist = newDist;
    }//end setDist
    
    public void setKnown(boolean maybeTrue) {
        this.known = maybeTrue;
    }// end setKnown
    
    public void newPrev(Node visited) {
        this.prevNode = visited;
    }// end newPrev

    int compareTo(Node n2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}  // end of Node<T>
