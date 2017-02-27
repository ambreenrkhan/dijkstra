package dijkstra.graph;

import java.util.ArrayList;
import java.util.List;

public class NodePath extends ArrayList<Node>
{
    /**Weights which correspond to the nodes in this node path*/
    private List<Integer> m_weights;

    public NodePath()
    {
        m_weights = new ArrayList<Integer>();
    }

    public NodePath( NodePath path )
    {
        super( path );
        m_weights = new ArrayList<Integer>( path.getWeights() );
    }

    public void removeLast() {
        // get the index to find the corresponding weight
        int size = size();
        if (size > 0) {
            m_weights.remove(size - 1);
            super.remove(size - 1);
        }
    }

    public boolean add( Node node, int weight )
    {
        boolean added = super.add( node );
        if( added )
        {
            m_weights.add( weight );
        }

        return added;
    }

    public List<Integer> getWeights()
    {
        return m_weights;
    }

    public int getTotalWeight()
    {
        int totalWeight = 0;
        for( Integer weight : m_weights )
        {
            totalWeight += weight;
        }

        return totalWeight;
    }

    public int getLevels()
    {
        return size();
    }
}