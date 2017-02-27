package dijkstra;

import dijkstra.io.ConsoleOutputWriter;
import dijkstra.io.OutputWriter;
import dijkstra.graph.*;
import dijkstra.graph.criteria.Criteria;
import dijkstra.graph.criteria.LevelCriteria;
import dijkstra.graph.criteria.WeightCriteria;

public class RoutesFinder
{
    private TreeTraverser<Character> m_treeTraverser;
    private OutputWriter<String> m_writer;

    private static final String NO_SUCH_ROUTE ="NO SUCH ROUTE";
    private int m_maxDefaultLevels;

    public RoutesFinder( Tree<Character> tree )
    {
        m_treeTraverser = new TreeTraverser<Character>( tree );
        m_writer = new ConsoleOutputWriter();
        // Lets make a default for the maximum levels to avoid cyclic dependencies
        m_maxDefaultLevels = tree.getNodes().size() * 2;
    }

    public void printResults()
    {
        // 1. The distance of the route A-B-C.
        int distance = m_treeTraverser.getWeight( 'A', 'B', 'C' );
        printRouteResult( 1, distance );

        // 2. The distance of the route A-D.
        distance = m_treeTraverser.getWeight( 'A', 'D' );
        printRouteResult( 2, distance );

        // 3. The distance of the route A-D-C.
        distance = m_treeTraverser.getWeight( 'A', 'D', 'C' );
        printRouteResult( 3, distance );

        // 4. The distance of the route A-E-B-C-D.
        distance = m_treeTraverser.getWeight( 'A', 'E', 'B', 'C', 'D' );
        printRouteResult( 4, distance );

        // 5. The distance of the route A-E-D.
        distance = m_treeTraverser.getWeight( 'A', 'E', 'D' );
        printRouteResult( 5, distance );

        // 6. The number of trips starting at C and ending at C with a maximum of 3 stops
        NodePaths nodePaths = new NodePaths();
        NodePath path = new NodePath();
        Criteria criteria = new LevelCriteria( 1, 3 );
        m_treeTraverser.findNodes( 'C', 'C', 0, path, nodePaths, criteria );
        printRouteResult( 6, nodePaths.size()  );

        // 7. The number of trips starting at A and ending at C with exactly 4 stops.
        nodePaths.clear();
        path.clear();
        criteria = new LevelCriteria( 4, 4 );
        m_treeTraverser.findNodes( 'A', 'C', 0, path, nodePaths, criteria );
        printRouteResult( 7, nodePaths.size() );

        // 8. The length of the shortest route (in terms of distance to travel) from A to C.
        nodePaths.clear();
        path.clear();
        criteria = new LevelCriteria( 1, m_maxDefaultLevels );
        m_treeTraverser.findNodes( 'A', 'C', 0, path, nodePaths, criteria );
        printRouteResult( 8, getLeastWeight( nodePaths ) );

        // 9. The length of the shortest route (in terms of distance to travel) from B to B.
        nodePaths.clear();
        path.clear();
        m_treeTraverser.findNodes( 'B', 'B', 0, path, nodePaths, criteria );
        printRouteResult( 9, getLeastWeight( nodePaths ) );

        // 10. The number of different routes from C to C with a distance of less than 30.
        nodePaths.clear();
        path.clear();
        criteria = new WeightCriteria( 30 );
        m_treeTraverser.findNodes( 'C', 'C', 0, path, nodePaths, criteria );
        printRouteResult( 10, nodePaths.size() );
    }

    private int getLeastWeight( NodePaths nodePaths )
    {
        int leastWeight = Integer.MAX_VALUE;

        for( NodePath path : nodePaths )
        {
            int pathWeight = path.getTotalWeight();

            if( pathWeight < leastWeight )
            {
                leastWeight = pathWeight;
            }
        }

        return leastWeight;
    }

    private void printRouteResult( int seqNumber, int result )
    {
        StringBuilder sb = new StringBuilder( "Output #" );
        sb.append( seqNumber );
        sb.append( ": " );

        if( result == -1 )
        {
            sb.append( NO_SUCH_ROUTE );
        }
        else
        {
            sb.append( result );
        }

        m_writer.writeOutput( sb.toString() );
    }
}