package dijkstra.graph.criteria;

import dijkstra.graph.NodePath;

public class LevelCriteria implements Criteria
{
    /**Minimum number of levels to the parent node*/
    private int m_minLevels;

    /**Maximum number of levels to the parent node*/
    private int m_maxLevels;

    public LevelCriteria( int minLevels, int maxLevels )
    {
        m_minLevels = minLevels;
        m_maxLevels = maxLevels;
    }

    public boolean accept( NodePath path )
    {
        // We are adding 1 to min level as the current path contains the source node as well
        return path.getLevels() >= m_minLevels+1;
    }

    public boolean isInvalid( NodePath path )
    {
        return path.getLevels() > m_maxLevels;
    }
}
