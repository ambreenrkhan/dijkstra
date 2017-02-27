package dijkstra;

import dijkstra.io.InputReader;
import dijkstra.graph.Node;
import dijkstra.graph.Tree;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Populates model from the input
 */
public class RoutesBuilder
{
    private final static Logger m_logger= Logger.getLogger( RoutesBuilder.class.getName() );

    public static Tree populate( InputReader<Node> reader ) throws IOException
    {
        Tree routesTree = new Tree();
        Node node = null;

        try
        {
            while( ( node = reader.readNext() )!= null )
            {
                routesTree.add( node );
            }
        }
        catch( IOException ex )
        {
            m_logger.log( Level.WARNING, "Unable to read node {0}, reason = {1}",
                    new Object[]{ node, ex.getMessage() });

        }
        finally
        {
            reader.close();
        }

        return routesTree;
    }
}