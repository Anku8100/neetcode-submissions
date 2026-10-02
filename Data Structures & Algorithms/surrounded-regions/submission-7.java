
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        
        char[][] visited = new char[n][m];
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){   
                visited[i][j] = 'X';
            }
        } 
        for(int i = 0; i< n; i++){
            if(board[i][0] == 'O' && visited[i][0] == 'X') dfs(i, 0, board, visited);
            if(board[i][m-1] == 'O' && visited[i][m-1] == 'X') dfs(i, m-1, board, visited);
        }   
        for(int j = 1; j< m-1; j++){
            if(board[0][j] == 'O' && visited[0][j] == 'X') dfs(0, j, board, visited);
            if(board[n-1][j] == 'O' && visited[n-1][j] == 'X') dfs(n-1, j, board, visited);
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                if(visited[i][j] == 'X' && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int r, int c, char[][] board, char[][] vis){
        int n = board.length;
        int m = board[0].length;
        vis[r][c] = 'O';
        int[] nRow = {-1, 0, 1, 0};
        int[] nCol = {0, -1, 0, 1};

        for(int i = 0; i< 4; i++){
            int adR = r + nRow[i];
            int adC = c + nCol[i];
            if(adR >= 0 && adR <n && adC >= 0 && adC < m
            && board[adR][adC] == 'O' && vis[adR][adC] != 'O'){
                dfs(adR, adC, board, vis);
            }
        }
    }
}
