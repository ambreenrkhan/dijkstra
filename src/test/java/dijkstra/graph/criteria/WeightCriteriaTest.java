package dijkstra.graph.criteria;

import junit.framework.TestCase;
import dijkstra.Util;
import dijkstra.graph.NodePath;

public class WeightCriteriaTest extends TestCase
{
    public void testAccept()
    {
        WeightCriteria criteria = new WeightCriteria( 10 );
        NodePath path = new NodePath( Util.createNodePath( "AB2", "BC7" ) );
        assertTrue( criteria.accept( path ) );

        path = new NodePath( Util.createNodePath( "AA0" ) );
        System.out.println( path.getTotalWeight());
        assertFalse( criteria.accept( path ) );
    }

    public void testIsInvalid()
    {
        WeightCriteria criteria = new WeightCriteria( 10 );
        NodePath path = new NodePath( Util.createNodePath( "AB2", "BC7" ) );
        assertFalse( criteria.isInvalid( path ) );

        path = new NodePath( Util.createNodePath( "AB2", "BC7", "CD9" ) );
        assertTrue( criteria.accept( path ) );
    }
}
