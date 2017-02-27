package dijkstra.graph;

import junit.framework.TestCase;

public class NodeTest extends TestCase
{
    public void testNodeCreation()
    {
        Node<Character> node = new Node<Character>( 'A' );
        assertEquals( Character.valueOf( 'A' ), node.getId() );
        assertTrue( node.isLeafNode() );
        assertEquals( 0, node.getChildNodes().size() );

        Node<Character> childNode = new Node<Character>( 'B' );
        node.addChildNode( childNode, 10 );
        assertEquals( Integer.valueOf( 10), node.getChildWeight( childNode ) );

        childNode = new Node<Character>( 'C' );
        node.addChildNode( childNode, 9 );
        assertEquals( Integer.valueOf( 9 ), node.getChildWeight( childNode ) );

        // not a leaf node anymore
        assertFalse( node.isLeafNode() );
        assertEquals( 2, node.getChildNodes().size() );
    }
}
