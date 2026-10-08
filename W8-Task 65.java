class Solution {

    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == '1') {

                    islands++;

                    dfs(grid, r, c);
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col); // up
        dfs(grid, row + 1, col); // down
        dfs(grid, row, col - 1); // left
        dfs(grid, row, col + 1); // right
    }
}
