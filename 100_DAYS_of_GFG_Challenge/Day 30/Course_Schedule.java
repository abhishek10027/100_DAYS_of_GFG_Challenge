/* 
TAsk :- 

The task is to complete the function findOrder(),
which takes two integers n, and m and a list of lists of size m*2 denoting the prerequisite pairs as input and 
returns any correct order to finish all the tasks. 
Return an empty array if it's impossible to finish all tasks.

*/



public class Course_Schedule{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> adj) {
        
        int[] ans = new int[n];
        int ansIndex = 0;
        int[] indegree = new int[n];
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : adj) {
            
            int from = edge.get(1);
            int to = edge.get(0);
            adjList.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            
            int curr = q.poll();
            ans[ansIndex++] = curr;

            for (int neighbor : adjList.get(curr)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return ansIndex == n ? ans : new int[0];
    }
}
