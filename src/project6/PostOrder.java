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
public class PostOrder extends EulerTour {

    public PostOrder(BinaryTree newTree) {
        super(newTree);
    }
    
    @Override
    /**
     * @param pos is the node being visited
     * @param result is a storage mechanism for results computed as this node
     */
    protected void visitPostorder (Position pos, TraversalResult result) {
        STNode node = (STNode) pos;
        STNode leftChild = node.getLeftChild();
        
        if (leftChild != null) {
            visitPostorder(leftChild, null);
            visitPostorder(leftChild.getSibling(), null);
            System.out.println(node.element());
        }
        else {
            System.out.println(node.element());
        }
    }
    
    public void execute(Position pos, TraversalResult result) {
        this.visitPostorder(pos, result);
    }

}
