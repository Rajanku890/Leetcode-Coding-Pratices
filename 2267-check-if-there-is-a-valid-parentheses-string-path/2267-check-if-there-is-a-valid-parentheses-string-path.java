class Solution {

    int m, n;
    char[][] grid;
    Boolean[][][] dp;
    public boolean hasValidPath(char[][] grid) {

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1) {
            return false;
        }
        dp = new Boolean[m][n][m + n];

        return solve(0, 0, 0);
    }

    boolean solve(int row, int col, int balance) {
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }
        if (balance < 0) {
            return false;
        }
        if (row == m - 1 && col == n - 1) {
            return balance == 0;
        }

        if (dp[row][col][balance] != null) {
            return dp[row][col][balance];
        }

        boolean ans = false;
        if (row + 1 < m) {
            ans = solve(row + 1, col, balance);
        }
        if (!ans && col + 1 < n) {
            ans = solve(row, col + 1, balance);
        }

        return dp[row][col][balance] = ans;
    }
}