package Graphs.Medium;

//The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix. mat[i][j] denotes the weight of the edge from i to j. If mat[i][j] = -1, it means there is no edge from i to j.
//Note: Modify the distances for every pair in place.
//
//Examples :
//
//Input: mat = [[0, 25], [-1, 0]]
//
//Output: [[0, 25], [-1, 0]]
//
//Explanation: The shortest distance between every pair is already given(if it exists).
//Input: mat = [[0, 1, 43],[1, 0, 6], [-1, -1, 0]]
//
//Output: [[0, 1, 7], [1, 0, 6], [-1, -1, 0]]
//
//Explanation: We can reach 2 from 0 as 0->1->2 and the cost will be 1+6=7 which is less than 43.
//Constraints:
//1 <= mat.size() <= 100
//-1 <= mat[ i ][ j ] <= 1000

public class FloydWarshallAlgo {

    public static void main(String[] args) {

    }

    public void shortestDistance(int[][] mat) {

        // Code here
        int n = mat.length;

        // Step 1: Replace -1 with Integer.MAX_VALUE (representing "infinity")
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == -1) mat[row][col] = Integer.MAX_VALUE;
            }
        }

        // Step 2: Floyd-Warshall Algorithm
        for (int via = 0; via < n; via++) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    // to check for integer overflow due to sum of max values of integer
                    if (mat[row][via] != Integer.MAX_VALUE && mat[via][col] != Integer.MAX_VALUE) {
                        mat[row][col] = Math.min(mat[row][col], mat[row][via] + mat[via][col]);
                    }
                }
            }
        }

        // Step 3: Replace Integer.MAX_VALUE back to -1 for unreachable nodes
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == Integer.MAX_VALUE) mat[row][col] = -1;
            }
        }
    }
}
