package MainJava;

/**
 * This is a basic class that holds the values 
 * and the min costs to get to the adjacent nodes
 * 
 * @author William McGrew
 * @date: 5/11/17
 */
public class Adj {
    
    Node adjNode;
    int cost;
    
    public Adj(Node node, int weight) {
        adjNode = node;
        cost = weight;
    }//end constructor
    
    public Node getNode() {
        return this.adjNode;
    }// end get Node
    
    public int getCost() {
        return this.cost;
    }// and getCost
}//end class Adj
