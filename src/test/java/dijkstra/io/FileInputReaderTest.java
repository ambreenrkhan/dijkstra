package dijkstra.io;

import junit.framework.TestCase;
import dijkstra.Util;
import dijkstra.graph.Node;

import java.io.IOException;
import java.util.Map;

public class FileInputReaderTest extends TestCase
{
    public void testToNode() throws IOException
    {
        FileInputReader reader = new FileInputReader();

        // AB8
        Node<Character> node = reader.parseNode( "AB8");
        assertEquals( Character.valueOf( 'A'), node.getId() );
        assertEquals( 1, node.getChildNodes().size() );

        Map.Entry<Node<Character>,Integer> childEntry = node.getChildNodes().entrySet().iterator().next();
        assertNotNull( childEntry );

        Node<Character> childNode = childEntry.getKey();
        Integer childWeight = childEntry.getValue();
        assertEquals( childNode.getId(), Character.valueOf( 'B' ) );
        assertEquals( childWeight, Integer.valueOf( 8 ) );

        // XY10
        node = reader.parseNode( "XY100");
        assertEquals( Character.valueOf( 'X'), node.getId() );
        assertEquals( 1, node.getChildNodes().size() );

        childEntry = node.getChildNodes().entrySet().iterator().next();
        assertNotNull( childEntry );

        childNode = childEntry.getKey();
        childWeight = childEntry.getValue();
        assertEquals( childNode.getId(), Character.valueOf( 'Y' ) );
        assertEquals( childWeight, Integer.valueOf( 100 ) );
    }

    public void tearDown() throws Exception
    {
        super.tearDown();
        Util.deleteTempDirectory();
    }
}
