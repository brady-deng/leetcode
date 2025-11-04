package lc.structure;

import lc.common.ob.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/*
// Definition for a GraphNode.
class GraphNode {
    public int val;
    public List<GraphNode> neighbors;
    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GraphNode>();
    }
    public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) {
            return null;
        }
        Map<Integer, GraphNode> cache = new HashMap();
        return dfsGraph(node, cache);
    }

    public GraphNode dfsGraph(GraphNode node, Map<Integer, GraphNode> map) {
        ArrayList<GraphNode> neighbors = new ArrayList();
        if(!map.containsKey(node.val)) {
            GraphNode cur = new GraphNode(node.val);
            map.put(cur.val, cur);
            for(GraphNode n: node.neighbors) {
                if(!map.containsKey(n.val)) {
                    neighbors.add(dfsGraph(n, map));
                } else {
                    neighbors.add(map.get(n.val));
                }
            }
            cur.neighbors = neighbors;
            return cur;
        } else {
            return (GraphNode) map.get(node.val);
        }
    }
}