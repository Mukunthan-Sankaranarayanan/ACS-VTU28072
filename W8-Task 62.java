class Solution {
    public int[] sortItems(
        int n,
        int m,
        int[] group,
        List<List<Integer>> beforeItems
    ) {
        
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

       
        List<List<Integer>> groupItems = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupItems.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            groupItems.get(group[i]).add(i);
        }


        List<List<Integer>> groupGraph = new ArrayList<>();
        int[] groupIndegree = new int[m];

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        
        List<List<Integer>> itemGraph = new ArrayList<>();
        int[] itemIndegree = new int[n];

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {

                if (group[prev] == group[i]) {
                   
                    itemGraph.get(prev).add(i);
                    itemIndegree[i]++;
                } else {
                   
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        
        List<Integer> groupOrder =
            topoSort(groupGraph, groupIndegree);

        if (groupOrder.size() != m) {
            return new int[0];
        }

        List<Integer> answer = new ArrayList<>();

        for (int g : groupOrder) {
            List<Integer> items = groupItems.get(g);

            if (items.isEmpty()) {
                continue;
            }

            List<Integer> itemOrder =
                topoSortItems(items, itemGraph, itemIndegree);

            if (itemOrder.size() != items.size()) {
                return new int[0];
            }

            answer.addAll(itemOrder);
        }

        return answer.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }

    private List<Integer> topoSort(
        List<List<Integer>> graph,
        int[] indegree
    ) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : graph.get(u)) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return order;
    }

    private List<Integer> topoSortItems(
        List<Integer> items,
        List<List<Integer>> graph,
        int[] indegree
    ) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int item : items) {
            if (indegree[item] == 0) {
                queue.offer(item);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : graph.get(u)) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return order;
    }
}
