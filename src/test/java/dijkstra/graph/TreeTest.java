package dijkstra.graph;

import junit.framework.TestCase;
import dijkstra.Util;

public class TreeTest extends TestCase
{
    public void testAdd()
    {
        Tree<Character> tree = new Tree<Character>();
        Node<Character> node = Util.createNode( "AB1" );
        tree.add( node );

        node = Util.createNode( "BC2" );
        tree.add( node );

        node = Util.createNode( "CD3" );
        tree.add( node );

        node = Util.createNode( "DE4" );
        tree.add( node );

        node = Util.createNode( "DB6" );
        tree.add( node );

        node = Util.createNode( "CE9" );
        tree.add( node );

        // Unique nodes
        assertEquals( 5, tree.getNodes().size() );
    }

    public void testGetNode()
    {
        Tree<Character> tree = new Tree<Character>();
        Node<Character> node = Util.createNode( "AB1" );
        tree.add( node );

        node = Util.createNode( "BC2" );
        tree.add( node );

        node = Util.createNode( "CD3" );
        tree.add( node );

        node = Util.createNode( "DE4" );
        tree.add( node );

        node = Util.createNode( "DB6" );
        tree.add( node );

        node = Util.createNode( "CE9" );
        tree.add( node );

        // Unique nodes
        Node<Character> testNode = tree.getNode( 'C' );
        assertNotNull( testNode );
        assertEquals( Character.valueOf( 'C' ), testNode.getId() );
        assertFalse( testNode.isLeafNode() );
        assertEquals( 2, testNode.getChildNodes().size() );
    }
}
