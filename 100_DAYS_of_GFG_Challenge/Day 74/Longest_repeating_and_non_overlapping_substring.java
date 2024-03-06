/* 
Task:
The task is to complete the function longestSubstring() which takes a Integer n and a string s as input and returns the answer.
*/

import java.util.Scanner;

public class Longest_repeating_and_non_overlapping_substring {

    static String longestSubstring(String S, int N) {
        int max = 0;
        String ans = "-1";
        int i = 0, j = 0;
        while (i < N && j < N) {
            String subString = S.substring(i, j + 1);
            if (S.indexOf(subString, j + 1) != -1) {
                int len = subString.length();
                if (len > max) {
                    max = len;
                    ans = subString;
                }
            } else {
                i++;
                j = i;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input:\n" +
                "n = ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("s = ");
        String s = scanner.nextLine();
        System.out.println("Output: " + longestSubstring(s, n));
        scanner.close();
    }
}
