class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int row, int col, int[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = 1;
        int[] nRows = {-1, 0, 1, 0};
        int[] nCols = {0, -1, 0, 1};

        for(int i = 0; i< 4; i++){
            int adjRow = row + nRows[i];
            int adjCol = col + nCols[i];
            if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < m && 
                grid[adjRow][adjCol] == '1' && visited[adjRow][adjCol] != 1){
                visited[adjRow][adjCol] = 1;
                dfs(grid, adjRow, adjCol, visited);
            }
        }
    }
}
