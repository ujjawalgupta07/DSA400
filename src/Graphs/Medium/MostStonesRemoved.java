package Graphs.Medium;

//On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
//
//A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
//
//Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.
//
//
//
//Example 1:
//
//Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//Output: 5
//Explanation: One way to remove 5 stones is as follows:
//1. Remove stone [2,2] because it shares the same row as [2,1].
//2. Remove stone [2,1] because it shares the same column as [0,1].
//3. Remove stone [1,2] because it shares the same row as [1,0].
//4. Remove stone [1,0] because it shares the same column as [0,0].
//5. Remove stone [0,1] because it shares the same row as [0,0].
//Stone [0,0] cannot be removed since it does not share a row/column with another stone still on the plane.
//Example 2:
//
//Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
//Output: 3
//Explanation: One way to make 3 moves is as follows:
//1. Remove stone [2,2] because it shares the same row as [2,0].
//2. Remove stone [2,0] because it shares the same column as [0,0].
//3. Remove stone [0,2] because it shares the same row as [0,0].
//Stones [0,0] and [1,1] cannot be removed since they do not share a row/column with another stone still on the plane.
//Example 3:
//
//Input: stones = [[0,0]]
//Output: 0
//Explanation: [0,0] is the only stone on the plane, so you cannot remove it.
//
//
//Constraints:
//
//1 <= stones.length <= 1000
//0 <= xi, yi <= 104
//No two stones are at the same coordinate point.
import java.util.*;

public class MostStonesRemoved {

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int mRow = 0;
        int mCol = 0;

        for (int[] stone : stones) {
            mRow = Math.max(mRow, stone[0]);
            mCol = Math.max(mCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(mRow + mCol + 1);

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + mRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            hm.put(nodeRow, 1);
            hm.put(nodeCol, 1);
        }

        int numberOfComponents = 0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            int key = entry.getKey();
            if(ds.findUParent(key) == key){
                numberOfComponents++;
            }
        }

        return n - numberOfComponents;

    }

    static class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n){
            for(int i = 0 ; i <= n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findUParent(int n){
            if(n == parent.get(n)){
                return n;
            }

            int par = findUParent(parent.get(n));
            parent.set(n, par);
            return parent.get(n);
        }

        public void unionBySize(int x, int y){
            int ulp_x = findUParent(x);
            int ulp_y = findUParent(y);

            if(ulp_x == ulp_y){
                return;
            }

            if(size.get(ulp_x) < size.get(ulp_y)){
                parent.set(ulp_x, ulp_y);
                size.set(ulp_y, size.get(ulp_x) + size.get(ulp_y));
            }
            else{
                parent.set(ulp_y, ulp_x);
                size.set(ulp_x, size.get(ulp_x) + size.get(ulp_y));
            }
        }
    }
}

