package dijkstra.graph;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Tree<T>
{
    /**Nodes collection keyed by the parent node identifier*/
    private Map<T,Node<T>> m_nodes;

    public Tree()
    {
        m_nodes = new LinkedHashMap<T, Node<T>>();
    }

    public void add( Node<T> newNode )
    {
        T parentNodeId = newNode.getId();

        // find the parent if existing in the map
        Node<T> parentNode = m_nodes.get( parentNodeId );

        // no parent node found, so create one
        if( parentNode == null )
        {
            parentNode = new Node<T>( parentNodeId );
            m_nodes.put( parentNodeId, parentNode );
        }

        // Now merge the new child nodes for this parent node
        for( Map.Entry<Node<T>, Integer> entry : newNode.getChildNodes().entrySet() )
        {
            Node<T> childNode = entry.getKey();
            Integer weight = entry.getValue();

            // existing child node
            Node<T> node = m_nodes.get( childNode.getId() );
            if( node == null )
            {
                node = childNode;
                m_nodes.put( node.getId(), node );
            }

            parentNode.addChildNode( node, weight );
        }
    }

    public Collection<Node<T>> getNodes()
    {
        return m_nodes.values();
    }

    public Node<T> getNode( T nodeId )
    {
        return m_nodes.get( nodeId );
    }
}