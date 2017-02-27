package dijkstra.io;

import dijkstra.graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class FileInputReader implements InputReader<Node>
{
    private BufferedReader m_reader;

    /**Input entry should be in this format AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE*/
    private static final Pattern ENTRY_PATTERN = Pattern.compile( "[A-E]{2}[0-9]+" );

    private final Logger m_logger= Logger.getLogger( FileInputReader.class.getName() );

    /**
     * @param inputFile file  which contains the input
     */
    public FileInputReader( String inputFile ) throws IOException
    {
        setFile( inputFile );
    }

    public FileInputReader()
    {

    }

    public void setFile( String inputFile ) throws IOException
    {
        m_reader = new BufferedReader( new FileReader( inputFile ) );
    }

    /**
     * @return next node in the input stream
     */
    public Node readNext() throws IOException
    {
        String entry ;
        while( ( entry = m_reader.readLine() )!= null )
        {
            entry = entry.trim();
            if( entry.startsWith("#")
                    || entry.length() == 0 )
            {
                continue;
            }

            if( !ENTRY_PATTERN.matcher( entry ).matches() )
            {
                m_logger.log(Level.WARNING, "Input entry {0} should be of this format {1}",
                        new Object[]{entry, ENTRY_PATTERN.pattern()});

                throw new IOException("Invalid input format");

            }

            // convert the entry to a node
            return parseNode( entry );
        }

        //no more nodes
        return null;
    }

    /**
     * Closes the input stream and release any resources
     */
    public void close()
    {
        if( m_reader != null )
        {
            try
            {
                m_reader.close();
            }
            catch( IOException e )
            {
                m_logger.log( Level.WARNING, "Failed to close the input stream. " );
            }
        }
    }

    /**
     * @param entry in format AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE
     * @return node which describes the parent entry
     */
    public Node<Character> parseNode( String entry )
    {
        Character parentNodeId = entry.charAt( 0 );
        Character nodeId = entry.charAt( 1 );
        String weightStr = entry.substring( 2 );

        Integer weight = Integer.valueOf( weightStr );

        Node<Character> node = new Node<Character>( parentNodeId );
        Node<Character> childNode = new Node<Character>( nodeId );
        node.addChildNode( childNode, weight );
        return node;
    }
}