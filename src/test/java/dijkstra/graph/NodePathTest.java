package dijkstra.graph;

import junit.framework.TestCase;
import dijkstra.Util;

public class NodePathTest extends TestCase
{
    public void testAdd()
    {
        NodePath path = new NodePath();
        Node<Character> node = Util.createNode( "AB8" );
        path.add( node, 8 );

        node = Util.createNode( "BC2" );
        path.add( node, 2 );

        node = Util.createNode( "CD6" );
        path.add( node, 6 );

        assertEquals( 3, path.getLevels() );
    }

    public void testRemoveLast()
    {
        NodePath path = new NodePath();
        Node<Character> node = Util.createNode( "AB1" );
        path.add( node, 1 );

        node = Util.createNode( "BC2" );
        path.add( node, 2 );

        node = Util.createNode( "CD3" );
        path.add( node, 3 );

        node = Util.createNode( "DE4" );
        path.add( node, 4 );

        assertEquals( 4, path.getLevels() );

        path.removeLast();
        assertEquals( 3, path.getLevels() );
    }

    public void testWeight()
    {
        NodePath path = new NodePath();
        Node<Character> node = Util.createNode( "AB1" );
        path.add( node, 1 );

        node = Util.createNode( "BC2" );
        path.add( node, 2 );

        node = Util.createNode( "CD3" );
        path.add( node, 3 );

        node = Util.createNode( "DE4" );
        path.add( node, 4 );

        assertEquals( 10, path.getTotalWeight() );
        assertEquals( 4, path.getWeights().size() );

        path.removeLast();
        assertEquals( 6, path.getTotalWeight() );
        assertEquals( 3, path.getWeights().size() );
    }
}
