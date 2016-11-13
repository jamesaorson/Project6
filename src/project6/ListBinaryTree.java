package project6;

/**
  * This class provides a ListBinaryTree object which can demonstrate inOrder,
  * postOrder, and preOrder walks of the tree.
  *
  * @author James Osborne
  * @version 1.0
  * File: ListBinaryTree.java
  * Created: 04 Nov 2016
  * ©Copyright James Osborne. All rights reserved.
  * Summary of Modifications:
  *     04 Nov 2016 – JAO – Created body for all of the methods implemented from
  *     the BinaryTree interface.
  * 
  * Description: This ListBinaryTree uses STNodes rather than BTNodes.The main
  * purpose of this exact implementation is to be able to demonstrate inOrder,
  * postOrder, and preOrder walks of the tree, for after calling fillTree, there
  * is no present method for adding nodes to the tree.
  */
public class ListBinaryTree implements BinaryTree {
    private STNode root;
    private int size;
    
    /**
      * Default constructor for the ListBinaryTree.
      */
    public ListBinaryTree() {
        root = null;
        size = 0;
    }
    
    public static void main (String[] args) {
        ListBinaryTree myTree = new ListBinaryTree();
        myTree.fillTree();
        
        InOrder inOrder = new InOrder(myTree);
        PreOrder preOrder = new PreOrder(myTree);
        PostOrder postOrder = new PostOrder(myTree);
        
        System.out.println("InOrder:");
        inOrder.execute();
        
        System.out.println("\nPreOrder:");
        preOrder.execute();
        
        System.out.println("\nPostOrder:");
        postOrder.execute();
    }
    
    /**
      * Used to fill the tree up with elements for testing.
      */
    public void fillTree() {
        root = new STNode(new Integer(0), null, null, null);
        STNode node1 = new STNode(new Integer(1), root, null, null);
        STNode node2 = new STNode(new Integer(2), root, null, null);
        root.setLeftChild(node1);
        node1.setSibling(node2);

        STNode node3 = new STNode(new Integer(3), node1, null, null);
        STNode node4 = new STNode(new Integer(4), node1, null, null);
        node1.setLeftChild(node3);
        node3.setSibling(node4);

        STNode node5 = new STNode(new Integer(5), node2, null, null);
        STNode node6 = new STNode(new Integer(6), node2, null, null);
        node2.setLeftChild(node5);
        node5.setSibling(node6);

        STNode node7 = new STNode(new Integer(7), node3, null, null);
        STNode node8 = new STNode(new Integer(8), node3, null, null);
        node3.setLeftChild(node7);
        node7.setSibling(node8);

        STNode node9 = new STNode(new Integer(9), node4, null, null);
        STNode node10 = new STNode(new Integer(10), node4, null, null);
        node4.setLeftChild(node9);
        node9.setSibling(node10);
        
        size = 11;
    }
    
    @Override
    /**
     * @return a reference to the root node
     */
    public Position root() throws EmptyTreeException {
        if (size == 0) {
            throw new EmptyTreeException();
        }
        
        return root;
    }

    @Override
    /**
     * @param pos is the node whose left child will be returned
     * @return a reference to left child of pos
     */
    public Position leftChild(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }
        
        return ((STNode) pos).getLeftChild();
    }

    @Override
    /**
     * @param pos is the node whose right child will be returned
     * @return a reference to right child of pos
     */
    public Position rightChild(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }

        //Store leftChild for checking and to get at its sibling.
        STNode leftChild = ((STNode) pos).getLeftChild();
        
        if (leftChild == null) {
            return null;
        }
        else {
            return leftChild.getSibling();
        }
    }

    @Override
    /**
     * @param pos is the node whose sibling will be returned
     * @return a reference to the sibling of pos
     */
    public Position sibling(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }
        
        //Stores parent and sibling of pos for checking.
        STNode parent = ((STNode) pos).getParent();
        STNode sibling = ((STNode) pos).getSibling();
        
        //Since the tree is not circular on the horzontal level, a null sibling
        //could mean pos is either the rightmost child, or it has no sibling.
        if (sibling == null) {
            //Pos has no other sibling because it has bo parent.
            if (parent == null) {
                return null;
            }
            else {
                //Returns sibling in the case pos was the rightmost sibling.
                return parent.getLeftChild();
            }
        }
        else {
            return sibling;
        }
    }

    @Override
    /**
     * @param pos is the node whose parent will be returned
     * @return a reference to the parent of pos
     */
    public Position parent(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }
        
        return ((STNode) pos).getParent();
    }

    @Override
    /**
     * @param pos is the node which will be examined
     * @return true if node has 1 or 2 children
     */
    public boolean isInternal(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }
        
        return ((STNode) pos).getLeftChild() != null;
    }

    @Override
    /**
     * @param pos is the node which will be examined
     * @return true if node has no children
     */
    public boolean isExternal(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }
        
        return ((STNode) pos).getLeftChild() == null;
    }

    @Override
    /**
     * @param pos is the node which will be examined
     * @return true if the node is the root node
     */
    public boolean isRoot(Position pos) throws InvalidPositionException {
        //STNode implements the Position interface, so this checks that
        //the pos parameter is the STNode implementation or not, nd also
        //whether or not the pos is null.
        if (!(pos instanceof STNode)) {
            throw new InvalidPositionException();
        }
        
        return (STNode) pos == root;
    }

    @Override
    /**
     * @return the number of Positions (nodes) in the tree
     */
    public int size() {
        return size;
    }

    @Override
    /**
     * @return true if the tree currently contains no Positions
     */
    public boolean isEmpty() {
        return size == 0;
    }
}