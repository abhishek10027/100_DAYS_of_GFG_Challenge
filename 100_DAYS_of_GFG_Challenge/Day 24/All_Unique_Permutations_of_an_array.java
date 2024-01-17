/* 
Your Task:
To complete the function uniquePerms() that takes an integer n, and 
an array arr of size n as input and returns a sorted list of lists containing all unique permutations of the array.*/



class All_Unique_Permutations_of_an_array {
    static Set<ArrayList<Integer>> ans;

    static void helper(int idx, ArrayList<Integer> arr) {
        int n = arr.size();
        if (idx >= n) {
            ArrayList<Integer> temp = new ArrayList<>(arr);
            ans.add(temp);
            return;
        }
        for (int i = idx; i < n; i++) {
            Collections.swap(arr, i, idx);
            helper(idx + 1, arr);
            Collections.swap(arr, i, idx);
        }
    }

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ans = new HashSet<>();
        Collections.sort(arr);
        helper(0, arr);

        // Convert the Set to an ArrayList
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(ans);

        // Sort the ArrayList of ArrayLists
        Collections.sort(result, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        return result;
    }
}
