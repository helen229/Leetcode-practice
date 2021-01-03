package other;

import java.util.*;

public class L207 {
    static public void main(String[] args){
        int[][] prerequisites={{1,0},{2,1}};
        System.out.println(canFinish(3,prerequisites));
    }
    static public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0; i<prerequisites.length;i++){
            /****/
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }

    //DFS version
//    static public boolean canFinish(int numCourses, int[][] prerequisites) {
//        //another way of two-dimension arrayList
//        ArrayList[] graph = new ArrayList[numCourses];
//        for(int i=0;i<numCourses;i++)
//            graph[i] = new ArrayList();
//
//        boolean[] visited = new boolean[numCourses];
//        //directed graph
//        for(int i=0; i<prerequisites.length;i++){
//            graph[prerequisites[i][1]].add(prerequisites[i][0]);
//        }
//
//        for(int i=0; i<numCourses; i++){
//            if(!dfs(graph,visited,i))
//                return false;
//        }
//        return true;
//    }

    static private boolean dfs(ArrayList[] graph, boolean[] visited, int course){
        if(visited[course])
            return false;
        else
            visited[course] = true;;

        for(int i=0; i<graph[course].size();i++){
            if(!dfs(graph,visited,(int)graph[course].get(i)))
                return false;
        }
        /***Reset the visited array since there is a DNS for each course but using same visited array***/
        visited[course] = false;
        return true;
    }
}
