package project6;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
  * @author James Osborne
  * @version 1.0
  * File: ListBinaryTreeTest.java
  * Created: 04 Nov 2016
  */
public class ListBinaryTreeTest {
    public ListBinaryTreeTest() {
    }

    @Rule public ExpectedException expected = ExpectedException.none();

    /**
      * Test of root method, of class ListBinaryTree.
      */
    @Test
    public void testRoot() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        //Root should have element value of 0.
        assertEquals(0, test.root().element());

        expected.expect(EmptyTreeException.class);
        expected.expectMessage("Empty Tree");

        test = new ListBinaryTree();

        test.root();
    }

    /**
      * Test of leftChild method, of class ListBinaryTree.
      */
    @Test
    public void testLeftChild() {
       ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position leftChild = test.leftChild(test.root());

        //Left child should have element value of 1.
        assertEquals(1, leftChild.element());

        //Checks that leftChild() returns null when the left child is null.
        STNode testNode = new STNode();
        assertEquals(null, test.leftChild(testNode));

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.leftChild(null);
    }

    /**
      * Test of rightChild method, of class ListBinaryTree.
      */
    @Test
    public void testRightChild() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position rightChild = test.rightChild(test.root());

        //Right child should have element value of 2.
        assertEquals(2, rightChild.element());

        //Checks that rightChild() returns null when the right child is null.
        STNode testNode = new STNode();
        assertEquals(null, test.rightChild(testNode));

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.rightChild(null);
    }

    /**
      * Test of sibling method, of class ListBinaryTree.
      */
    @Test
    public void testSibling() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position leftChild = test.leftChild(test.root());
        Position rightChild = test.sibling(leftChild);

        //Tests that both the right children and
        //left children return the correct sibling position.
        assertEquals(2, rightChild.element());
        leftChild = test.sibling(rightChild);
        assertEquals(1, leftChild.element());

        //Checks that sibling() returns null when the sibling is null. First
        //check is on root, which should have no sibling, and next check is
        //just of a newly created node with no specified sibling.
        assertEquals(null, test.sibling(test.root()));
        STNode testNode = new STNode();
        assertEquals(null, test.sibling(testNode));

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.sibling(null);
    }

    /**
      * Test of parent method, of class ListBinaryTree.
      */
    @Test
    public void testParent() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position parent = test.root();
        Position leftChild = test.leftChild(parent);
        Position rightChild = test.sibling(leftChild);

        //Checks that parent method for left and right children returns
        //the correct parent position.
        assertEquals(parent, test.parent(leftChild));
        assertEquals(parent, test.parent(rightChild));

        //Checks that parent() returns null when the parent is null. First
        //check is on root, which should have no parent, and next check is
        //just of a newly created node with no specified parent.
        assertEquals(null, test.parent(test.root()));
        STNode testNode = new STNode();
        assertEquals(null, test.parent(testNode));

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.parent(null);
    }

    /**
      * Test of isInternal method, of class ListBinaryTree.
      */
    @Test
    public void testIsInternal() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position curr = test.root();

        //Tests all positions of the left children down the tree
        //which should be considered internal.
        for (int i = 0; i < 3; ++i) {
            assertEquals(true, test.isInternal(curr));

            curr = test.leftChild(curr);
        }

        //Last position in tree should not be considered internal.
        assertEquals(false, test.isInternal(curr));

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.isInternal(null);
    }

    /**
      * Test of isExternal method, of class ListBinaryTree.
      */
    @Test
    public void testIsExternal() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position curr = test.root();

        //Tests all positions of the left children down the tree
        //which should not be considered external.
        for (int i = 0; i < 3; ++i) {
            assertEquals(false, test.isExternal(curr));

            curr = test.leftChild(curr);
        }

        //Last position in tree should be considered external.
        assertEquals(true, test.isExternal(curr));

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.isExternal(null);
    }

    /**
      * Test of isRoot method, of class ListBinaryTree.
      */
    @Test
    public void testIsRoot() {
        ListBinaryTree test = new ListBinaryTree();

        test.fillTree();

        Position curr = test.root();

        //Only the root should return true for the isRoot() method.
        assertEquals(true, test.isRoot(curr));

        //Rest of the tree should not be considered root. This checks down
        //the left side of the tree, which should demonstrate well enough
        //the isRoot() method's functionality.
        for (int i = 0; i < 3; ++i) {
            curr = test.leftChild(curr);

            assertEquals(false, test.isRoot(curr));
        }

        expected.expect(InvalidPositionException.class);
        expected.expectMessage("Invalid Position");
        test.isRoot(null);
    }

    /**
      * Test of size method, of class ListBinaryTree.
      */
    @Test
    public void testSize() {
        ListBinaryTree test = new ListBinaryTree();

        assertEquals(0, test.size());

        //Puts 11 positions into the tree.
        test.fillTree();

        assertEquals(11, test.size());
    }

    /**
      * Test of isEmpty method, of class ListBinaryTree.
      */
    @Test
    public void testIsEmpty() {
        ListBinaryTree test = new ListBinaryTree();

        assertEquals(true, test.isEmpty());

        test.fillTree();

        assertEquals(false, test.isEmpty());
    }
}
