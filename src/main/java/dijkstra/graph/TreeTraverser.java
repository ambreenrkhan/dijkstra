package dijkstra.graph;

import dijkstra.graph.criteria.Criteria;

import java.util.*;

public class TreeTraverser<T> {
    private Tree<T> m_tree;

    public TreeTraverser(Tree<T> tree) {
        m_tree = tree;
    }

    public int getWeight(T... nodeIds) {
        int totalDistance = 0;
        boolean lastNodeFound = false;

        for (int i = 0; i < nodeIds.length - 1; i++) {
            T nodeId = nodeIds[i];
            T nextNodeId = nodeIds[i + 1];

            Node<T> node = m_tree.getNode(nodeId);
            if (node == null || node.isLeafNode()) {
                return -1;
            }

            for (Map.Entry<Node<T>, Integer> entry : node.getChildNodes().entrySet()) {
                Node<T> childNode = entry.getKey();
                Integer weight = entry.getValue();

                if (childNode.getId().equals(nextNodeId)) {
                    // last node in the sequence has been found
                    if (i == nodeIds.length - 2) {
                        lastNodeFound = true;
                    }

                    int distance = weight;
                    totalDistance += distance;
                    break;
                }
            }
        }

        return lastNodeFound ? totalDistance : -1;
    }

    public void findNodes( T startNode, T endNode, int weight, NodePath currentPath, NodePaths nodePaths, Criteria criteria )
    {
        Node<T> node = m_tree.getNode( startNode );
        currentPath.add( node, weight );

        if( node == null )
        {
            return;
        }

        if (startNode.equals(endNode) && criteria.accept(currentPath)) {
            // valid path found
            nodePaths.add(new NodePath(currentPath) );
            currentPath.removeLast();
            return;
        } else if (criteria.isInvalid( currentPath ) ) {
            // No point continuing as it is no longer a potential candidate
            currentPath.removeLast();
            return;
        }

        for( Map.Entry<Node<T>, Integer> entry : node.getChildNodes().entrySet()  )
        {
            Node<T> childNode = entry.getKey();
            int childWeight = entry.getValue();
            findNodes( childNode.getId(), endNode, childWeight, currentPath, nodePaths, criteria );

        }

        currentPath.removeLast();
    }
}