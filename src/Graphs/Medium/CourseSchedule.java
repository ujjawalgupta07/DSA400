package Graphs.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.
//
//
//
//Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0. So it is possible.
//Example 2:
//
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
//
//
//Constraints:
//
//1 <= numCourses <= 2000
//0 <= prerequisites.length <= 5000
//prerequisites[i].length == 2
//0 <= ai, bi < numCourses
//All the pairs prerequisites[i] are unique.
public class CourseSchedule {

    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        int n = prerequisites.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ;  i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n; i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i = 0 ; i < numCourses; i++){
            for(int j = 0 ; j < adj.get(i).size(); j++){
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0 ;
        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
            else{
                count++;
            }
        }

        // if(count == numCourses){
        //     return false;
        // }

        while(!q.isEmpty()){
            int currCourse = q.remove();
            ArrayList<Integer> neighbours = adj.get(currCourse);
            for(int neighbour : neighbours){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }

        for(int i = 0 ; i < numCourses; i++){
            if(indegree[i] > 0){
                return false;
            }
        }

        return true;
    }
}
