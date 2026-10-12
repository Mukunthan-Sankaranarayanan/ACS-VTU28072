import java.util.*;

public class ForestFireSpreadSimulator {

    static class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] grid = new int[R][C];

        Queue<Cell> queue = new LinkedList<>();

        int totalTrees = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 2) {
                    queue.offer(new Cell(i, j));
                }

                if (grid[i][j] == 1) {
                    totalTrees++;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int burnedTrees = 0;
        int minutes = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean treeBurnedThisMinute = false;

            for (int i = 0; i < size; i++) {

                Cell current = queue.poll();

                for (int d = 0; d < 4; d++) {

                    int newRow = current.row + dr[d];
                    int newCol = current.col + dc[d];

                    if (newRow >= 0 && newRow < R &&
                        newCol >= 0 && newCol < C) {

                        if (grid[newRow][newCol] == 1) {

                            grid[newRow][newCol] = 2;

                            burnedTrees++;

                            queue.offer(new Cell(newRow, newCol));

                            treeBurnedThisMinute = true;
                        }
                    }
                }
            }

            if (treeBurnedThisMinute) {
                minutes++;
            }
        }

        if (burnedTrees == totalTrees) {
            System.out.println("Minutes = " + minutes);
        } else {
            System.out.println("Minutes = -1");
        }

        sc.close();
    }
}
