/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project6;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Owner
 */
public class ListBinaryTreeTest {
    
    public ListBinaryTreeTest() {
    }

    /**
     * Test of main method, of class ListBinaryTree.
     */
    @Test
    public void main() {
        ListBinaryTree myTree = new ListBinaryTree();
        myTree.fillTree();
        
        Position curr = myTree.root();
        STNode result;
        
        InOrder inOrder = new InOrder(myTree);
        PreOrder preOrder = new PreOrder(myTree);
        PostOrder postOrder = new PostOrder(myTree);
        postOrder.execute(curr, null);
        
        /*for (int i = 0; i < 10; ++i) {
            result = (STNode) myTree.leftChild(curr);
            
            if (result != null) {
                System.out.println(result.element());
            }
            
            curr = myTree.leftChild(curr);
        }*/
    }

    /**
     * Test of root method, of class ListBinaryTree.
     */
    @Test
    public void testRoot() {
       
    }

    /**
     * Test of leftChild method, of class ListBinaryTree.
     */
    @Test
    public void testLeftChild() {
       
    }

    /**
     * Test of rightChild method, of class ListBinaryTree.
     */
    @Test
    public void testRightChild() {
       
    }

    /**
     * Test of sibling method, of class ListBinaryTree.
     */
    @Test
    public void testSibling() {
       
    }

    /**
     * Test of parent method, of class ListBinaryTree.
     */
    @Test
    public void testParent() {
     
    }

    /**
     * Test of isInternal method, of class ListBinaryTree.
     */
    @Test
    public void testIsInternal() {
     
    }

    /**
     * Test of isExternal method, of class ListBinaryTree.
     */
    @Test
    public void testIsExternal() {
     
    }

    /**
     * Test of isRoot method, of class ListBinaryTree.
     */
    @Test
    public void testIsRoot() {
     
    }

    /**
     * Test of size method, of class ListBinaryTree.
     */
    @Test
    public void testSize() {
     
    }

    /**
     * Test of isEmpty method, of class ListBinaryTree.
     */
    @Test
    public void testIsEmpty() {
     
    }
}
