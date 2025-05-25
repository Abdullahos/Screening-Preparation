package graph;

import tree.TreeNode;

import java.util.*;

public class Nodes_K_Distance_From_Target {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();

        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();

        List<TreeNode> neighboors = new ArrayList<>();
        neighboors.add(null);

        graph.put(root, neighboors);

        buildGraph(root, graph);

        Set<TreeNode> visited = new HashSet<>();

        traverseGraph(graph, target, 0, k, result, visited);

        return result;
    }

    private void traverseGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode node, int d, int k, List<Integer> result, Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        if (d == k) {
            result.add(node.val);
            return;
        }


        visited.add(node);

        List<TreeNode> neighboors = graph.get(node);

        for (TreeNode n : neighboors) {
            traverseGraph(graph, n, d + 1, k, result, visited);
        }

    }

    private void buildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph) {
        if (root == null) {
            return;
        }

        List<TreeNode> neighboors = graph.get(root);

        neighboors.add(root.left);
        neighboors.add(root.right);

        addNodeToGraph(root, root.left, graph);
        addNodeToGraph(root, root.right, graph);

        buildGraph(root.left, graph);
        buildGraph(root.right, graph);

    }

    private void addNodeToGraph(TreeNode parent, TreeNode child, Map<TreeNode, List<TreeNode>> graph) {
        if (child != null) {
            List<TreeNode> list = new ArrayList<>();
            list.add(parent);
            graph.put(child, list);
        }
    }


}
