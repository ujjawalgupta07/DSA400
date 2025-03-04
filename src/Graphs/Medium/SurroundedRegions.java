package Graphs.Medium;

//You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
//
//Connect: A cell is connected to adjacent cells horizontally or vertically.
//Region: To form a region connect every 'O' cell.
//Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
//To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
//
//
//
//Example 1:
//
//Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
//
//Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//
//Explanation:
//
//
//In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.
//
//Example 2:
//
//Input: board = [["X"]]
//
//Output: [["X"]]
//
//
//
//Constraints:
//
//m == board.length
//n == board[i].length
//1 <= m, n <= 200
//board[i][j] is 'X' or 'O'.

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        Queue<Pairs> q = new LinkedList<>();
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1 ){
                    if(board[i][j] == 'O'){
                        q.add(new Pairs(i, j));
                        visited[i][j] = 1;
                    }
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            Pairs currItem = q.remove();
            int currRow = currItem.row;
            int currCol = currItem.col;
            visited[currRow][currCol] = 1;
            for(int i = 0 ; i < 4; i++){
                int nRow = currRow + delRow[i];
                int nCol = currCol + delCol[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                        visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                    q.add(new Pairs(nRow, nCol));
                }
            }
        }

        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] != 1 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                    visited[i][j] = 1;
                }
            }
        }
    }
}

class Pairs {
    int row;
    int col;

    public Pairs(int row, int col){
        this.row = row;
        this.col = col;
    }
}

