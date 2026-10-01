class Tuple{
    int row;
    int col;
    int time;
    public Tuple(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }

}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Tuple(i, j, 0));
                }
                visited[i][j] = grid[i][j];
            }
        }
        int minT = 0;
        while(! q.isEmpty()){
            Tuple t = q.poll();
            int r = t.row;
            int c = t.col;
            int tT = t.time;
            minT = tT;
            int[] nRow = {-1, 0, 1, 0};
            int[] nCol = {0, -1, 0, 1};
            for(int i = 0; i< 4; i++){
                int adR = r + nRow[i];
                int adC = c + nCol[i];
                if(adR >= 0 && adR < n && adC >= 0 && adC < m &&
                    grid[adR][adC] == 1 && visited[adR][adC] != 2){
                    visited[adR][adC] = 2;
                    q.offer(new Tuple(adR, adC, tT + 1));
                }
            }
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(visited[i][j] == 1) return -1;
    
            }
        }
        return minT;
    }
}
