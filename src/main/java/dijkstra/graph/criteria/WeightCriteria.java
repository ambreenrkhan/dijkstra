package dijkstra.graph.criteria;

import dijkstra.graph.NodePath;

public class WeightCriteria implements Criteria
{
    /**Maximum weight till the parent node*/
    private int m_maxWeight;

    public WeightCriteria( int maxWeight )
    {
        m_maxWeight = maxWeight;
    }

    public boolean accept( NodePath path )
    {
        return path.getTotalWeight() > 0;
    }

    public boolean isInvalid( NodePath path )
    {
        return path.getTotalWeight() > m_maxWeight;
    }
}
