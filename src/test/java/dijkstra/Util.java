package dijkstra;

import dijkstra.graph.Node;
import dijkstra.graph.NodePath;
import dijkstra.graph.Tree;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Util
{
    public static File getTempRawResourceFolder()
    {
        return new File( System.getProperty( "java.io.tmpdir" ), "ThoughtWorksTest" );
    }

    public static File getTempRawResource( String resourceFile )
    {
        return new File( getTempRawResourceFolder(), resourceFile );
    }

    public static void deleteTempDirectory()
            throws IOException
    {
        File tmpDir= Util.getTempRawResourceFolder();

        if( tmpDir.exists() )
        {
            deleteContents( tmpDir );
            deleteFile( tmpDir );
        }
    }

    /**
     * Deletes the contents of a directory recursively. This method does not delete the directory itself.
     *
     * @param dir Directory to delete
     *
     * @throws IOException When failed to delete folder and content.
     */
    public static void deleteContents( final File dir ) throws IOException
    {
        if( dir==null || !dir.isDirectory() )
        {
            return;
        }

        File[] files= dir.listFiles();
        if( files==null )
        {
            throw new IllegalStateException();
        }

        for( File fileInFolder : files )
        {
            if( fileInFolder.isDirectory() )
            {
                deleteContents( fileInFolder );
            }

            deleteFile( fileInFolder );
        }
    }

    /**
     * Deletes the given file and throws an exception if the delete failed.
     *
     * @param inFile File to delete.
     */
    public static void deleteFile( final File inFile )
    {
        if( !inFile.exists() )
        {
            throw new IllegalStateException( "File does not exist: "+inFile );
        }

        if ( !inFile.delete() && inFile.isDirectory() )
        {
            throw new IllegalStateException( inFile+" is a directory" );
        }
    }

    /**
     * @param entry entry in this format AB9
     * @return node representing the entry
     */
    public static Node<Character> createNode( String entry )
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

    /**
     * @param entries entries in this format AB9, BE7
     * @return path containing the nodes
     */
    public static NodePath createNodePath( String... entries )
    {
        NodePath path = new NodePath();
        for( String entry : entries )
        {
            Node<Character> node = createNode( entry );
            Map.Entry<Node<Character>,Integer> childEntry = node.getChildNodes().entrySet().iterator().next();
            path.add( node, childEntry.getValue() );
        }

        return path;
    }

    public static Tree<Character> createTree( String... entries )
    {
        Tree<Character> tree = new Tree<Character>();

        for( String entry : entries )
        {
            Node<Character> node = createNode( entry );
            tree.add( node );
        }

        return tree;
    }

}
