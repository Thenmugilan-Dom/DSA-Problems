import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;  // number of nodes in tree1
        int m = edges2.length + 1;  // number of nodes in tree2

        // Build adjacency list for both trees
        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        // Arrays to store the parity of depth (0 = even, 1 = odd) for each node
        int[] depth1 = new int[n];
        int[] depth2 = new int[m];

        // Arrays to count number of nodes at even (index 0) and odd (index 1) levels
        int[] count1 = new int[2];
        int[] count2 = new int[2];

        // Fill depth and count arrays using DFS
        dfs(0, -1, 0, tree1, depth1, count1);  // for tree1
        dfs(0, -1, 0, tree2, depth2, count2);  // for tree2

        int maxFromTree2 = Math.max(count2[0], count2[1]);  // maximum we can add from tree2

        // For each node in tree1, calculate result based on its parity
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int parity = depth1[i];  // 0 for even, 1 for odd
            result[i] = count1[parity] + maxFromTree2;
        }

        return result;
    }

    // Builds the adjacency list for a tree
    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    // DFS to compute depth parity and even/odd level node counts
    private void dfs(int node, int parent, int depth, List<List<Integer>> tree, int[] depthArr, int[] count) {
        int parity = depth % 2;
        depthArr[node] = parity;
        count[parity]++;
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, depth + 1, tree, depthArr, count);
            }
        }
    }
}