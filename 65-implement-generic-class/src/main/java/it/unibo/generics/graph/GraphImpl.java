package it.unibo.generics.graph;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.NodeColor;

public class GraphImpl<N> implements Graph<N> {
    
    private final Map<N, ArrayList<N>> graph = new HashMap<>();

    @Override
    public void addNode(N node) {
        if (node != null) {
            this.graph.put(node, new ArrayList<N>());
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            (this.graph.get(source)).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return this.graph.keySet();
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return Set.copyOf(this.graph.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        List<N> path = new ArrayList<>();
        Map<N, N> parent = new HashMap<>();          // node -> parentNode      
        Map<N, NodeColor> color = new HashMap<>();   // node -> color           
        if (source == null || target == null) {
            return path;
        }
        BFS(source, parent, color);
        return(findPath(source, target, path, parent));  
    }

    private void BFS(N source, Map<N, N> parent, Map<N, NodeColor> color) {
        for (N node : this.graph.keySet()) {
            parent.put(node, null);
            color.put(node, NodeColor.WHITE);
            if (node.equals(source)) {
                color.put(source, NodeColor.GREY);
            }
        }
        Queue<N> queue = new LinkedList<N>();
        queue.add(source);
        while (!queue.isEmpty()) {
            N value = queue.poll();
            for (N adj : this.graph.get(value)) {
                if (color.get(adj) == NodeColor.WHITE) {    
                    color.replace(adj, NodeColor.GREY);
                    parent.replace(adj, value);
                    queue.add(adj);
                }
            }
            color.replace(value, NodeColor.BLACK);
        }
    }

    private List<N> findPath(N source, N target, List<N> path, Map<N, N> parent) {
        if(target == null) {
            return path;
        }
        findPath(source, parent.get(target), path, parent);
        path.add(target);
        return path;
    }
}