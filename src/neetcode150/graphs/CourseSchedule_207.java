package neetcode150.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {

    /**
     * Build an adjacency list for the graph
     *
     * @param numCourses    number of courses
     * @param prerequisites prerequisites for the courses
     * @return adjacency list
     */
    private static List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // [1, 0] means 0 is prerequisite for 1 there is edge from 0 to 1
        for (int[] pre : prerequisites) {
            adjacencyList.get(pre[1]).add(pre[0]);
        }

        return adjacencyList;
    }

    //---------------------------------------------BFS-----------------------------------------------------

    // Topological sort using BFS
    // Cycle Detection (Topological Sort with Kahn’s Algorithm)
    private static List<Integer> detectCycleBFS(int numCourses, List<List<Integer>> adjacencyList) {

        // Stores the in-degree of each course
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int course : adjacencyList.get(i)) {
                inDegree[course]++;
            }
        }

        // Queue will be empty when there is a cycle in the graph, none of the courses can be completed
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);

            for (int nextCourse : adjacencyList.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.add(nextCourse);
                }
            }

        }

        return result;
    }

    //---------------------------------------------DFS-----------------------------------------------------

    /**
     * If there is a cycle in graph, none of the courses can be completed
     * Detects cycle in weighted graph, using three states
     * <p>
     * The values in the visited array (0, 1, 2) represent the following states:
     * <p>
     * 0 (Unvisited): This indicates that the vertex (course) has not been visited yet during the DFS traversal.
     * When visited[i] == 0, it means that course i has not been explored at all.
     * <p>
     * 1 (Visiting/In Progress): This indicates that the vertex is currently being visited,
     * i.e., the DFS has reached this vertex and is exploring its adjacent vertices.
     * Setting visited[course] = 1 marks the vertex as being visited.
     * If during the DFS traversal you encounter a vertex already marked as 1,
     * it means that you've encountered a cycle because you're revisiting a vertex that is still in progress.
     * <p>
     * 2 (Visited/Completed): This indicates that the vertex and all its adjacent vertices have been fully explored,
     * and the DFS has finished processing it. When visited[course] = 2,
     * it signifies that the vertex is fully processed and there is no cycle starting from this vertex.
     **/

     private static boolean detectCycleDFS(int course, List<List<Integer>> adjacencyList, int[] visited) {
        // Detected cycle
        if (visited[course] == 1) {
            return true;
        }

        if (visited[course] == 2) {
            return false;
        }

        visited[course] = 1;

        for (int nextCourse : adjacencyList.get(course)) {
            if (detectCycleDFS(nextCourse, adjacencyList, visited)) return true;
        }

        visited[course] = 2;
        return false;
    }


    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = buildGraph(numCourses, prerequisites);

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && detectCycleDFS(i, adjacencyList, visited)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
