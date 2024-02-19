/* 

Task:

The task is to complete the function minValue() which takes s and k as input parameters and 
returns the minimum possible required value.

*/


import java.util.*;

public class Game_with_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        int result = minValue(s, k);
        System.out.println("Output: " + result);
    }

    static int minValue(String s, int k) {
        // Count the frequency of each character
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Use a priority queue to efficiently remove characters with highest frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int count : charCounts) {
            if (count > 0) {
                pq.add(count);
            }
        }

        // Remove k characters
        int value = 0;
        while (k > 0 && !pq.isEmpty()) {
            int count = pq.poll();
            count--;
            k--;
            if (count > 0) {
                pq.add(count);
            }
        }
        
        // Calculate the value
        while (!pq.isEmpty()) {
            int count = pq.poll();
            value += count * count;
        }
        return value;
    }
}
