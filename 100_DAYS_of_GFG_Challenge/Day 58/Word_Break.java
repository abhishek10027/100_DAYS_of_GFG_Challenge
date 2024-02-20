
/* 
Task:

Complete wordBreak() function which takes a string and list of strings as a parameter and 
returns 1 if it is possible to break words, else return 0.

*/


import java.util.*;

public class Word_Break {
    

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionary.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n] ? 1 : 0;
    }
}

