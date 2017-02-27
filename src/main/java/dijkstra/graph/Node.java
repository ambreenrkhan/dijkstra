package dijkstra.graph;

import java.util.*;

public class Node<T>
{
    private T m_id;

    /**Child nodes and their weights with the parent node*/
    private Map<Node<T>,Integer> m_childNodes;

    public Node( T id )
    {
        m_id = id;
        m_childNodes = new LinkedHashMap<Node<T>, Integer>();
    }

    public T getId()
    {
        return m_id;
    }

    public void addChildNode( Node<T> childNode, Integer weight )
    {
        m_childNodes.put( childNode, weight );
    }

    public Map<Node<T>, Integer> getChildNodes()
    {
        return m_childNodes;
    }

    public Integer getChildWeight( Node<T> childNode )
    {
        return m_childNodes.get( childNode );
    }

    public boolean isLeafNode()
    {
        return m_childNodes.size() == 0;
    }

    public String toString()
    {
        return m_id.toString();
    }

    @Override
    public boolean equals( Object o )
    {
        if( this==o ) return true;
        if( o==null || getClass()!=o.getClass() ) return false;

        Node<T> node= (Node<T>) o;

        if( !m_id.equals( node.m_id ) ) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return m_id.hashCode();
    }
}