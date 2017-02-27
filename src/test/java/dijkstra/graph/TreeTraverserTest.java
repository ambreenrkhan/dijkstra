package dijkstra.graph;

import junit.framework.TestCase;
import dijkstra.Util;
import dijkstra.graph.criteria.Criteria;
import dijkstra.graph.criteria.LevelCriteria;

public class TreeTraverserTest extends TestCase
{
    public void testGetWeight()
    {
        Tree<Character> tree = Util.createTree( "AB1", "BC2", "CD3", "DE4", "AD5", "BD7" );
        TreeTraverser<Character> treeTraverser = new TreeTraverser<Character>( tree );

        assertEquals( 3, treeTraverser.getWeight( 'A', 'B', 'C' ) );
        assertEquals( 9, treeTraverser.getWeight( 'A', 'D', 'E' ) );

    }

    public void testFindNodes()
    {
        Tree<Character> tree = Util.createTree( "AB10", "BD2", "BC3", "CA1", "CD5", "AD7" );
        TreeTraverser<Character> treeTraverser = new TreeTraverser<Character>( tree );

        NodePaths nodePaths = new NodePaths();
        NodePath path = new NodePath();
        Criteria criteria = new LevelCriteria( 1, 3 );
        treeTraverser.findNodes( 'A', 'D', 0, path, nodePaths, criteria );

        assertEquals( 3, nodePaths.size()  );
    }
}
