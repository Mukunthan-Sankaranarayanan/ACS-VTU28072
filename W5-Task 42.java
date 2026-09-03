class Solution {

    List<int[]> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        
        dfs(root, 0, 0);

        
        Collections.sort(nodes, (a, b) -> {

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[2], b[2]);
        });

        int previousColumn = Integer.MIN_VALUE;

        for (int[] node : nodes) {

            int column = node[0];
            int value = node[2];

            
            if (column != previousColumn) {
                result.add(new ArrayList<>());
                previousColumn = column;
            }

            result.get(result.size() - 1).add(value);
        }

        return result;
    }

    private void dfs(TreeNode root, int row, int column) {

        if (root == null) {
            return;
        }

        nodes.add(new int[]{column, row, root.val});

        dfs(root.left, row + 1, column - 1);

        dfs(root.right, row + 1, column + 1);
    }
}
