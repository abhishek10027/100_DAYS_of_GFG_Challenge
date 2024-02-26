/* 
Task:

The task is to complete the function AllPossibleStrings() which takes a string s as the input parameter and 
returns a list of all possible subsequences (non-empty) that can be formed from s in lexicographically-sorted order.

*/




import java.util.*;

public class Power_Set {
    public static List<String> AllPossibleStrings(String s) {
        int n = s.length();
        List<String> ans = new ArrayList<>();

        // i loop for 0 to 2^n-1
        for (int i = 1; i < (1 << n); i++) {
            StringBuilder sub = new StringBuilder();

            // j loop for running in the length of string
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) { // if bit is set
                    sub.append(s.charAt(j));
                }
            }
            ans.add(sub.toString());
        }

        Collections.sort(ans); // Sort the list before returning it
        return ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your String :  ");
        String s = sc.nextLine();

        List<String> result = AllPossibleStrings(s);
        System.out.println("Output:");
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}
