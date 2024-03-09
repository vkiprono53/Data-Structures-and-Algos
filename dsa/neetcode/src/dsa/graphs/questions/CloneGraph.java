package dsa.graphs.questions;
import java.util.Map;
import java.util.HashMap;

/**
 * @author vkiprono
 * @created 3/9/24
 */

import java.util.ArrayList;
import java.util.List;

/**
 * LEETCODE 133. Clone Graph
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 */
public class CloneGraph {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor : node.neighbors){
            if(map.containsKey(neighbor)){
                newNode.neighbors.add(map.get(neighbor));
            }
            else{
                newNode.neighbors.add(cloneGraph(neighbor));
            }
        }

        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

}

