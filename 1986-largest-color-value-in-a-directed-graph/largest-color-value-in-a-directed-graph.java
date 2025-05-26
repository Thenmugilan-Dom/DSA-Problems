class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] count = new int[n][26];  
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int maxValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            int colorIndex = colors.charAt(node) - 'a';
            count[node][colorIndex]++;
            maxValue = Math.max(maxValue, count[node][colorIndex]);

            for (int neighbor : graph[node]) {
                for (int c = 0; c < 26; c++) {
                    count[neighbor][c] = Math.max(count[neighbor][c], count[node][c]);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return visited == n ? maxValue : -1; 
    }
}