package project6;

public class ListBinaryTree implements BinaryTree {
    private STNode root;
    private STNode[] tree;
    private int size = 0;
    
    public static void main (String[] args) {
        ListBinaryTree myTree = new ListBinaryTree();
        myTree.fillTree();
        
        System.out.println(myTree.root.getLeftChild().element());
    }
    
    public void fillTree() {
        tree = new STNode[11];
        
        root = new STNode(new Integer(0), null, null, null);
        tree[0] = root;
        
        for (int i = 1;  i < 11; i += 2) {
            tree[i] = new STNode(new Integer(i), root, null, null);
            tree[i + 1] = new STNode(new Integer(i + 1), root, null, null);
            tree[i / 2].setLeftChild(tree[i]);
            tree[i].setSibling(tree[i + 1]);
            
            size += 2;
        }
        
        /*root = new STNode(new Integer(0), null, null, null);
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
        node9.setSibling(node10);*/

        //size = 11;
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
        STNode node = (STNode) pos.element();
        
        return node.getLeftChild();
    }

    @Override
    /**
     * @param pos is the node whose right child will be returned
     * @return a reference to right child of pos
     */
    public Position rightChild(Position pos) throws InvalidPositionException {
        
        return null;
    }

    @Override
    /**
     * @param pos is the node whose sibling will be returned
     * @return a reference to the sibling of pos
     */
    public Position sibling(Position pos) throws InvalidPositionException {
        
        return null;
    }

    @Override
    /**
     * @param pos is the node whose parent will be returned
     * @return a reference to the parent of pos
     */
    public Position parent(Position pos) throws InvalidPositionException {
        
        return null;
    }

    @Override
    /**
     * @param pos is the node which will be examined
     * @return true if node has 1 or 2 childen
     */
    public boolean isInternal(Position pos) throws InvalidPositionException {
        
        return false;
    }

    @Override
    /**
     * @param pos is the node which will be examined
     * @return true if node has no childen
     */
    public boolean isExternal(Position pos) throws InvalidPositionException {
        
        return false;
    }

    @Override
    /**
     * @param pos is the node which will be examined
     * @return true if the node is the root node
     */
    public boolean isRoot(Position pos) throws InvalidPositionException {
        
        return false;
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