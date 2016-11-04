package project6;

/**
  * What does it do?
  *
  * @author James Osborne
  * @version 1.0 
  * File: <filename>
  * Created:  11/4/2016
  * ©Copyright James Osborne. All rights reserved.
  * Summary of Modifications:
  *     XX month XXXX – JAO – 
  * 
  * Description: 
  */
public class PreOrder extends EulerTour {

    public PreOrder(BinaryTree newTree) {
        super(newTree);
    }
    
    //This works!
    @Override
    /**
     * @param pos is the node being visited
     * @param result is a storage mechanism for results computed as this node
     */
    protected void visitPreorder (Position pos, TraversalResult result) {        
        STNode node = (STNode) pos;
        STNode leftChild = node.getLeftChild();
        
        System.out.println(node.element());
        
        if (leftChild != null) {
            visitPreorder(leftChild, null);
            visitPreorder(leftChild.getSibling(), null);
        }
    }
    
    public void execute(Position pos, TraversalResult result) {
        this.visitPreorder(pos, result);
    }
}
