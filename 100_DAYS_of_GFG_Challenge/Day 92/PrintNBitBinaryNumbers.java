/*
Task:
The task is to complete the function NBitBinary() which takes a single number as input n 
and returns the list of strings in decreasing order.
*/



import java.util.ArrayList;
import java.util.Scanner;

public class PrintNBitBinaryNumbers {
    ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        PrintNBitBinaryNumbers solution = new PrintNBitBinaryNumbers();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();

        ArrayList<String> result = solution.NBitBinary(N);
        System.out.println("N-bit binary numbers having more 1s than 0s:");
        for (String str : result) {
            System.out.println(str);
        }
        scanner.close();
    }

    ArrayList<String> NBitBinary(int N) {
        String s = "";
        solve(s, 0, N);
        return ans;
    }

    private void solve(String s, int extra, int i) {
        if (i == 0) {
            ans.add(s);
            return;
        }
        solve(s + "1", extra + 1, i - 1);

        if (extra > 0) {
            solve(s + "0", extra - 1, i - 1);
        }
    }
}
