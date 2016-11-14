package project6;

/**
  * This class provides an PostOrder extension of the EulerTour class.
  *
  * @author James Osborne
  * @version 1.0 
  * File: PostOrder.java
  * Created: 04 Nov 2016
  * ©Copyright James Osborne. All rights reserved.
  * Summary of Modifications:
  *     04 Nov 2016 – JAO – Created methods and their bodies. Got PostOrder walk
  *     functioning.
  * 
  * Description: This walk utilizes a recursive algorithm for walking the tree
  * PostOrder (left, right, parent) and prints the walk order to the screen. 
  * This walk always starts from the root of the tree.
  */
public class PostOrder extends EulerTour {
    public PostOrder(BinaryTree newTree) {
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
    protected void visitPostorder (Position pos, TraversalResult result) {
        System.out.println(pos.element());
    }
    
    /**
      * Executes a postOrder walk of the tree for the user.
      */
    public void execute() {
        this.performTour(tree.root());
    }
}