// 207. Course Schedule
// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 
// 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            arr.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] in = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it: arr.get(i)){
                in[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(in[i]==0) q.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();

            res.add(node);
            for(int i: arr.get(node)){
                in[i]--;
                if(in[i]==0) q.add(i);
            }
        }

        if(res.size()!=numCourses) return false;
        return true;
    }
}
