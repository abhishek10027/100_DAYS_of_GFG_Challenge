/* 
Task:
The task is to complete the function nthCharacter() which takes the string s and integers r and n as input parameters and 
returns the n-th character of the string after performing r operations on s.
*/



import java.util.Scanner;

public class Find_the_N_th_character {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.println("Enter the string s:");
        String s = scanner.nextLine();

        System.out.println("Enter the value of r:");
        int r = scanner.nextInt();

        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();

        // Output
        System.out.println("Output: " + nthCharacter(s, r, n));
    }

    public static char nthCharacter(String s, int r, int n) {
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1')
                    sb.append("10");
                else
                    sb.append("01");

                if (j > n)
                    break;
            }
            s = sb.toString();
        }
        return s.charAt(n);
    }
}
