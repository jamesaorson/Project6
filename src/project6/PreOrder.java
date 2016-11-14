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
     * @param pos is the node being visited
     * @param result is a storage mechanism for results computed as this node
     */
    protected void visitPreorder (Position pos, TraversalResult result) {        
        /*STNode leftChild = ((STNode) pos).getLeftChild();
        
        //Whether or not a child node exists, we print parent first.
        System.out.println(pos.element());
        
        //If child is not null, visit and print as left then right, for parent
        //was visited and printed already.
        if (leftChild != null) {
            visitPreorder(leftChild, null);
            visitPreorder(leftChild.getSibling(), null);
        }*/
        System.out.println(pos.element());
    }
    
    /**
      * Executes a preOrder walk of the tree for the user.
      */
    public void execute() {
        this.performTour(tree.root());
        //this.visitPreorder(tree.root(), null);
    }
}