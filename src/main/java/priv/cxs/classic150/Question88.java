package priv.cxs.classic150;

public class Question88 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    rec(grid, i, j);
                }
            }
        }
        return count;
    }

    private void rec(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == ' ' || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = ' ';
        rec(grid, i - 1, j);
        rec(grid, i + 1, j);
        rec(grid, i, j - 1);
        rec(grid, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] data = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Question88().numIslands(data));
    }
}
