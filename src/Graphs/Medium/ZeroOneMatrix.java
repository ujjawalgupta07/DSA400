package Graphs.Medium;

//Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//
//The distance between two cells sharing a common edge is 1.
//
//
//
//Example 1:
//
//
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
//Example 2:
//
//
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = mat;
        int[][] visited = new int[n][m];
        Queue<Struct> q = new LinkedList<>();
        for(int i = 0 ; i < n; i++){
            for(int j =0; j< m; j++){
                if(mat[i][j] == 0){
                    q.add(new Struct(i, j, 0));
                    visited[i][j] = 1;
                    ans[i][j] = 0;
                }
            }
        }

        bfs(mat, ans, visited, q, n, m);

        return ans;
    }

    public void bfs(int[][] mat, int[][] ans, int[][] visited, Queue<Struct> q, int n , int m){
        int[] delRows = {-1, 0, 1, 0};
        int[] delCols = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Struct currItem = q.remove();
            int row = currItem.row;
            int col = currItem.col;
            int dist = currItem.dist;
            ans[row][col] = dist;
            for(int i = 0 ; i < 4; i++){
                int nRow = row + delRows[i];
                int nCol = col + delCols[i];
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && mat[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                    q.add(new Struct(nRow, nCol, dist+1));
                    visited[nRow][nCol] = 1;
                }
            }
        }

    }
}

class Struct{
    int row;
    int col;
    int dist;

    public Struct(int r, int c, int d){
        this.row = r;
        this.col = c;
        this.dist = d;
    }
}

