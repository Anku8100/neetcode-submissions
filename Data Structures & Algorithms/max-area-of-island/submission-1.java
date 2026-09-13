class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int maxArea = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == 1 && visited[i][j] != 1){
                    int area = dfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, area);
                }
                
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int row, int col, int[][] visited){
        int n = grid.length;
        int m = grid[0].length;
        int area = 1;
        visited[row][col] = 1;

        int[] nRow = {-1, 0, 1, 0};
        int[] nCol = {0, -1, 0, 1};

        for(int i = 0; i< 4; i++){
            int adjR = row + nRow[i];
            int adjC = col + nCol[i];

            if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m &&
                grid[adjR][adjC] == 1 && visited[adjR][adjC] == 0){
                    visited[adjR][adjC] = 1;
                    
                    area +=  dfs(grid, adjR, adjC, visited);

            }
            
        }
        return area;
    }
}





// [0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]
