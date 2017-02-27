package dijkstra;

import dijkstra.io.FileInputReader;
import dijkstra.io.InputReader;
import dijkstra.graph.Tree;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point of the application
 */
public class Main
{
    private static final Logger m_logger = Logger.getLogger( Main.class.getName() );

    public static void main( String args[] )
    {
        // For now we only support one argument i.e. location of file path
        if( args.length <1 )
        {
            m_logger.log(Level.SEVERE, "Missing input file path" );
            return;
        }

        String filePath = args[0];

        try
        {
            InputReader reader = new FileInputReader( filePath );
            Tree model = RoutesBuilder.populate( reader );
            RoutesFinder finder = new RoutesFinder( model );
            finder.printResults();
        }
        catch( IOException ex )
        {
            m_logger.log(Level.SEVERE, "Exception encountered while calculating routes", ex );
        }
    }
}