/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/



public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) throw new IllegalArgumentException("illegal prerequisites array");
        int[] prereqNum = new int[numCourses]; // prereqNum[i]: the num of prereq before taking Course_i
        
        // count the number of prerequisites needed for each Course
        for(int i = 0; i < prerequisites.length; ++i){
            prereqNum[prerequisites[i][0]]++;
        }
        
        // starting from those Course that has no prerequisites
        // q is used to maintain the courses that have already been taken
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; ++i){
            if(prereqNum[i] == 0){
                q.add(i);
            }
        }
        
        //
        int courseTaken = q.size();
        while(!q.isEmpty()){
            int preC = q.poll();
            // already took preC, check those courses whose prereq is preC.
            for(int i = 0; i < prerequisites.length; ++i){
                if(prerequisites[i][1] == preC){
                    prereqNum[prerequisites[i][0]]--;
                    if(prereqNum[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                        courseTaken++;
                    }
                }
            }
        }
        return courseTaken == numCourses;
    }
}
