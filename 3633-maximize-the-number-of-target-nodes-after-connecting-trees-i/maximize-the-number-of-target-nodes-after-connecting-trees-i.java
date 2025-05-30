class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length+1;
        int m = edges2.length+1;

        List<Integer>[] tree1 = buildGraph(n, edges1);
        List<Integer>[] tree2 = buildGraph(m, edges2);

        int maxreachabletree2 = 0;

        for(int i =0; i< m ; i++){
            int reachable = bfs(tree2, i, k-1);
            maxreachabletree2 = Math.max(maxreachabletree2, reachable);
        }
        
        int[] result = new int[n];
        for(int i =0; i< n ;i++){
            int reachableTree1= bfs(tree1, i, k);
            result[i]= reachableTree1 + maxreachabletree2;
        }

        return result;
    }

    private List<Integer>[] buildGraph(int nodes, int [][] edges){
        List<Integer> [] graph = new ArrayList[nodes];
        for(int i =0; i< nodes;i++) graph[i]= new ArrayList<>();
        for(int [] edge : edges ){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }


    private int bfs(List<Integer>[] graph, int start, int maxDist){
        boolean[] visited = new boolean[graph.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start]=true;

        int count =0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0], dist= cur[1];

            if(dist > maxDist) continue;
            count++;

            for(int neighbour : graph[node]){
                if(!visited[neighbour]){
                     visited[neighbour]= true;
                     queue.offer(new int[]{neighbour, dist+1});
                }
            }
        }
        return count;
    }
}