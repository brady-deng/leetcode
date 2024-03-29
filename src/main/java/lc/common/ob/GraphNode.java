package main.java.lc.common.ob;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 2021/8/23
 **/
public class GraphNode {

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
