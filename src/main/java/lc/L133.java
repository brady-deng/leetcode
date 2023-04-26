package main.java.lc;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/8/23
 **/
public class L133 {
    public static GraphNode[] nodes = new GraphNode[100];
    public GraphNode cloneGraph(GraphNode node) {
        if (null != node) {
            return cloneGraph(node, nodes);
        }
        else {
            return null;
        }
    }

    public GraphNode cloneGraph(GraphNode node, GraphNode[] nodes) {
        if (null != node) {
            if (nodes[node.val] != null) {
                return nodes[node.val];
            }
            else {
                GraphNode res = new GraphNode(node.val);
                nodes[node.val] = res;
                node.neighbors.forEach(item->{
                    res.neighbors.add(cloneGraph(item, nodes));
                });
                return res;
            }
        }
        return null;
    }

}
