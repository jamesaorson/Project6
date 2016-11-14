package project6;

/**
  * This class provides an PreOrder extension of the EulerTour class.
  *
  * @author James Osborne
  * @version 1.0 
  * File: PreOrder.java
  * Created: 04 Nov 2016
  * ©Copyright James Osborne. All rights reserved.
  * Summary of Modifications:
  *     04 Nov 2016 – JAO – Created methods and their bodies. Got PreOrder walk
  *     functioning.
  * 
  * Description: This walk utilizes a recursive algorithm for walking the tree
  * PreOrder (parent, left, right) and prints the walk order to the screen. This
  * walk always starts from the root of the tree.
  */
public class PreOrder extends EulerTour {
    public PreOrder(BinaryTree newTree) {
        super(newTree);
    }
    
    @Override
    /**
     * @param pos is the external node being visited
     * @param result is a storage mechanism for results computed as this node
     */
    protected void visitExternal (Position pos, TraversalResult result) {
        System.out.println(pos.element());
    }
    
    @Override
    /**
     * @param pos is the node being visited
     * @param result is a storage mechanism for results computed as this node
     */
    protected void visitPreorder (Position pos, TraversalResult result) {
        System.out.println(pos.element());
    }
    
    /**
      * Executes a preOrder walk of the tree for the user.
      */
    public void execute() {
        this.performTour(tree.root());
    }
}