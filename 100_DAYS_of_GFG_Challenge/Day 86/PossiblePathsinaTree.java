/*
Task:  
Complete the function maximumWeight()which takes integers n, list of edges where each edge is given by {start,end,weight}, an integer q and a list of q queries as input parameters and 
returns a list of integers denoting the number of possible paths for each query.
*/


import java.util.*;

public class PossiblePathsinaTree {
    int ans;

    private int root(int i, int[] parent) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private int union(int a, int b, int[] parent, int[] sz) {
        int ra = root(a, parent);
        int rb = root(b, parent);
        if (ra == rb)
            return sz[ra] * sz[ra];
        if (sz[ra] < sz[rb]) {
            int temp = ra;
            ra = rb;
            rb = temp;

            temp = a;
            a = b;
            b = temp;
        }

        ans += sz[ra] * sz[rb];
        parent[rb] = ra;
        sz[ra] += sz[rb];

        return ans;
    }

    public ArrayList<Integer> maximumWeight(int n, int[][] edges, int q, int[] queries) {
        ans = 0;

        int[] parent = new int[n + 1];
        int[] sz = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

        ArrayList<int[]> wt = new ArrayList<>();
        for (int i = 0; i < n - 1; i++)
            wt.add(new int[]{edges[i][0], edges[i][1], edges[i][2]});
        wt.sort((a, b) -> Integer.compare(a[2], b[2]));

        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for (int i = 0; i < n - 1; i++) {
            int a = wt.get(i)[0];
            int b = wt.get(i)[1];
            int c = wt.get(i)[2];
            mp.put(c, union(a, b, parent, sz));
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            Map.Entry<Integer, Integer> val = mp.floorEntry(queries[i]);
            if (val == null)
                res.add(0);
            else
                res.add(val.getValue());
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes (n): ");
        int n = scanner.nextInt();

        System.out.println("Enter the edges (start, end, weight) as space-separated triplets:");
        int[][] edges = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
            edges[i][2] = scanner.nextInt();
        }

        System.out.print("Enter the number of queries (q): ");
        int q = scanner.nextInt();

        System.out.println("Enter the queries:");
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = scanner.nextInt();
        }

        PossiblePathsinaTree solution = new PossiblePathsinaTree();
        ArrayList<Integer> result = solution.maximumWeight(n, edges, q, queries);

        System.out.println("Output:");
        for (int val : result) {
            System.out.println(val);
        }
    }
}
