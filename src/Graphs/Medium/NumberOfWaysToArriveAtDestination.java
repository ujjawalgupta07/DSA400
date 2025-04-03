package Graphs.Medium;

//You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.
//
//You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.
//
//Return the number of ways you can arrive at your destination in the shortest amount of time. Since the answer may be large, return it modulo 109 + 7.
//
//
//
//Example 1:
//
//
//Input: n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
//Output: 4
//Explanation: The shortest amount of time it takes to go from intersection 0 to intersection 6 is 7 minutes.
//The four ways to get there in 7 minutes are:
//- 0 ➝ 6
//- 0 ➝ 4 ➝ 6
//- 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
//- 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
//Example 2:
//
//Input: n = 2, roads = [[1,0,10]]
//Output: 1
//Explanation: There is only one way to go from intersection 0 to intersection 1, and it takes 10 minutes.
//
//
//Constraints:
//
//1 <= n <= 200
//n - 1 <= roads.length <= n * (n - 1) / 2
//roads[i].length == 3
//0 <= ui, vi <= n - 1
//1 <= timei <= 109
//ui != vi
//There is at most one road connecting any two intersections.
//You can reach any intersection from any other intersection.

import java.util.*;
import java.util.Comparator;

public class NumberOfWaysToArriveAtDestination {

    public static void main(String[] args) {

    }

    public int countPaths(int n, int[][] roads) {

        final long MOD = 1000000007L;

        List<List<long[]>> adj = new ArrayList<>();
        for (long i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            long wt = roads[i][2];
            adj.get(u).add(new long[]{wt, v});
            adj.get(v).add(new long[]{wt, u});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long node = current[1];
            long wt = current[0];

            for (long[] edge : adj.get((int) node)) {
                long newNode = edge[1];
                long newWt = edge[0];

                if (wt + newWt < dist[(int) newNode]) {
                    dist[(int) newNode] = wt + newWt;
                    pq.offer(new long[]{wt + newWt, newNode});
                    ways[(int) newNode] = ways[(int) node];
                } else if (wt + newWt == dist[(int) newNode]) {
                    ways[(int) newNode] = (ways[(int) newNode] + ways[(int) node]) % MOD;
                }
            }
        }

        return (int) (ways[n - 1] % MOD);
    }
}
