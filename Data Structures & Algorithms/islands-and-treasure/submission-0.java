class Tuple{
    int row, col, dist;
    public Tuple(int row_, int col_, int dist_){
        row = row_;
        col = col_;
        dist = dist_;
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        Queue<Tuple> q = new LinkedList<>();
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(grid[i][j] == 0) q.add(new Tuple(i, j, 0));
            }
        }

        while(! q.isEmpty()){
            Tuple t = q.poll();
            int r = t.row;
            int c = t.col;
            int d = t.dist;

            int[] nr = {-1, 0, 1, 0};
            int[] nc = {0, -1, 0, 1};

            for(int i = 0; i< 4; i++){
                int adjR = r + nr[i];
                int adjC = c + nc[i];

                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < m
                    && grid[adjR][adjC] == 2147483647){
                        grid[adjR][adjC] = d + 1;
                        q.add(new Tuple(adjR, adjC, d + 1));
                    }     
            }
        }
    }
}
