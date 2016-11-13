package project6;

/**
  * This class provides an InOrder extension of the EulerTour class.
  *
  * @author James Osborne
  * @version 1.0 
  * File: InOrder.java
  * Created: 04 Nov 2016
  * ©Copyright James Osborne. All rights reserved.
  * Summary of Modifications:
  *     04 Nov 2016 – JAO – Created methods and their bodies. Got InOrder walk
  *     functioning.
  * 
  * Description: This walk utilizes a recursive algorithm for walking the tree
  * InOrder (left, parent, right) and prints the walk order to the screen. This
  * walk always starts from the root of the tree.
  */
public class InOrder extends EulerTour {
    public InOrder(BinaryTree newTree) {
        super(newTree);
    }
    
    @Override
    /**
     * @param pos is the node being visited
     * @param result is a storage mechanism for results computed as this node
     */
    protected void visitInorder (Position pos, TraversalResult result) {
        STNode leftChild = ((STNode) pos).getLeftChild();
        
        //If there are no childern, print the element and fall out
        //of this recursive call.
        if (leftChild == null) {
            System.out.println(pos.element());
        }
        else {
            //Otherwise, visit and print as left, parent, right.
            visitInorder(leftChild, null);
            System.out.println(pos.element());
            visitInorder(leftChild.getSibling(), null);
        }
    }
    
    /**
      * Executes an inOrder walk of the tree for the user.
      */
    public void execute() {
        this.visitInorder(tree.root(), null);
    }
}