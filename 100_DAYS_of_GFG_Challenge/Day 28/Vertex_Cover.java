/* 
Task :-

Task is to complete the function vertexCover() which takes 
the edge list and an integer n for the number of nodes of the graph as input parameters and 
returns the size of the smallest possible vertex cover.

*/


public class Vertex_Cover{
    public static int vertexCover(int n, int m, int[][] edges) {
        // code here
        int ans = Integer.MAX_VALUE;
        
        outerloop:
        for(int i = 0; i <= 1 << n; i++){
            for(int j = 0; j < m; j++)
            if(!((1 << (edges[j][0] - 1) & i) != 0 || (1 << (edges[j][1] - 1) & i) != 0)) continue outerloop;
            ans = Math.min(ans, Integer.bitCount(i));
        }
        return ans;
    }
}