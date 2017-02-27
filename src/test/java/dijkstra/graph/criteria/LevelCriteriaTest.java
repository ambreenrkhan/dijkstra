package dijkstra.graph.criteria;

import junit.framework.TestCase;
import dijkstra.Util;
import dijkstra.graph.NodePath;

public class LevelCriteriaTest extends TestCase
{
    public void testAccept()
    {
        LevelCriteria criteria = new LevelCriteria( 1, 2 );
        NodePath path = new NodePath( Util.createNodePath( "AB2", "BC7" ) );
        assertTrue( criteria.accept( path ) );

        criteria = new LevelCriteria( 5, 5 );
        path = new NodePath( Util.createNodePath( "AB2", "BC7", "CD9" ) );
        assertFalse( criteria.accept( path ) );
    }

    public void testIsInvalid()
    {
        LevelCriteria criteria = new LevelCriteria( 1, 2 );
        NodePath path = new NodePath( Util.createNodePath( "AB2", "BC7" ) );
        assertFalse( criteria.isInvalid( path ) );

        criteria = new LevelCriteria( 1, 2 );
        path = new NodePath( Util.createNodePath( "AB2", "BC7", "CD9" ) );
        assertTrue( criteria.accept( path ) );
    }
}
