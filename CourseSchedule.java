package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Can be done with DFS. (Read dfs solution)

public class CourseSchedule {

    // Done with topological sorting
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        List<Integer>[] adjGraph = new List[numCourses];

        for(int[] course: prerequisites) {
            inDegree[course[0]]++;
            if(adjGraph[course[0]] == null) {
                adjGraph[course[0]] = new ArrayList<>();
            }
            adjGraph[course[0]].add(course[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int visited = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            for(int i=0; i<adjGraph.length; i++) {
                if(adjGraph[i]!=null && adjGraph[i].contains(course)) {
                    inDegree[i]--;
                    adjGraph[i].remove((Integer) course);
                    if (inDegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
            visited++;
        }

        return visited == numCourses;
    }

    // Done with DFS
    public boolean dfs(List<List<Integer>> graph ,boolean visited[],boolean resStack[] ,int start){
        resStack[start] = true;
        visited[start] = true;
        for(int n:graph.get(start)){
            if(resStack[n]){
                return true;
            }
            if(!visited[n]){
                if(dfs(graph,visited,resStack,n)){
                    return true;
                }
            }
        }
        resStack[start]=false;
        return false;
    }
    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int arr[]:prerequisites){
            graph.get(arr[0]).add(arr[1]);
        }

        boolean resStack[] = new boolean[numCourses];
        boolean visited[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(graph,visited,resStack,i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(canFinish(5, prerequisites));
    }
}
