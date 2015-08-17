/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
*/

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) throw new IllegalArgumentException("Illegal prerequisites array");
        if(prerequisites.length == 0){
            int[] res = new int[numCourses];
            for(int i = 0; i < numCourses; ++i) res[i] = i;
            return res;
        }
        
        // For each course, we count the number of prerequisites
        int[] prereqNum = new int[numCourses];
        for(int i = 0; i < prerequisites.length; ++i){
            prereqNum[prerequisites[i][0]]++;
        }
        
        // 
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; ++i){
            if(prereqNum[i] == 0){
                q.add(i);
            }
        }
        
        int courseTaken = q.size();
        int[] res = new int[numCourses];
        int j = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            res[j++] = curr;
            for(int i = 0; i < prerequisites.length; ++i){
                if(prerequisites[i][1] == curr){
                    prereqNum[prerequisites[i][0]]--;
                    if(prereqNum[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                        courseTaken++;
                    }
                }
            }
        }
        if(courseTaken == numCourses) return res;
        else return new int[0];
    }
}
