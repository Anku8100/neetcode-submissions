
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int j = 0; j< m; j++){
            pacific[0][j] = true;
            atlantic[n-1][j] = true;
        }
        for(int i = 0; i< n; i++){
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int j = 0; j< m; j++){
            dfs(0, j, heights, pacific);
        }

        for(int i = 1; i< n; i++){
            dfs(i, 0, heights, pacific);
        }

        for(int j = 0; j< m; j++){
            dfs(n-1, j, heights, atlantic);
        }
        for(int i = 0; i< n-1; i++){
            dfs(i, m-1, heights, atlantic);
        }
        for(int i = 0; i< n; i++){
            
            for(int j = 0; j< m; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
            
        }
        return result;
    }
    private void dfs(int r, int c, int[][] heights, boolean[][] vis){
        int n = heights.length;
        int m = heights[0].length;
        
        vis[r][c] = true;
        int[] nRow = {-1, 0, 1, 0};
        int[] nCol = {0, -1, 0, 1};

        for(int i = 0; i< 4; i++){
            int adR = r + nRow[i];
            int adC = c + nCol[i];

            if(adR >= 0 && adR < n && adC >= 0 && adC < m
            && heights[adR][adC] >= heights[r][c] && !vis[adR][adC]){
                dfs(adR, adC, heights, vis);
            }
        }
    }
}
