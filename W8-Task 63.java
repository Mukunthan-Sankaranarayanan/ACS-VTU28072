class Solution {

    public int[] shortestAlternatingPaths(
        int n,
        int[][] redEdges,
        int[][] blueEdges
    ) {
        
        List<Integer>[][] graph = new ArrayList[n][2];

        for (int i = 0; i < n; i++) {
            graph[i][0] = new ArrayList<>();
            graph[i][1] = new ArrayList<>();
        }

        
        for (int[] edge : redEdges) {
            graph[edge[0]][0].add(edge[1]);
        }

       
        for (int[] edge : blueEdges) {
            graph[edge[0]][1].add(edge[1]);
        }

        int[][] dist = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

       
        dist[0][0] = 0;
        dist[0][1] = 0;

        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int node = curr[0];
            int lastColor = curr[1];

           
            int nextColor = 1 - lastColor;

            for (int next : graph[node][nextColor]) {

                if (dist[next][nextColor] != -1) {
                    continue;
                }

                dist[next][nextColor] =
                    dist[node][lastColor] + 1;

                queue.offer(new int[]{next, nextColor});
            }
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int redDist = dist[i][0];
            int blueDist = dist[i][1];

            if (redDist == -1 && blueDist == -1) {
                answer[i] = -1;
            } else if (redDist == -1) {
                answer[i] = blueDist;
            } else if (blueDist == -1) {
                answer[i] = redDist;
            } else {
                answer[i] = Math.min(redDist, blueDist);
            }
        }

        return answer;
    }
}
