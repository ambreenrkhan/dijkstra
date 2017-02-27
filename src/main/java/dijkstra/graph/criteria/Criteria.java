package dijkstra.graph.criteria;

import dijkstra.graph.NodePath;

public interface Criteria
{
    /**
     * @param path path to be tested
     * @return true if the criteria is satisfied, false otherwise
     */
    boolean accept( NodePath path );

    /**
     * @param path path to be tested
     * @return true if the object is a potential candidate false otherwise
     */
    boolean isInvalid( NodePath path );
}
