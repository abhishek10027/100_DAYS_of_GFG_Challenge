/* 

Your Task:
The task is to complete the function search() which takes the string text and the string pattern as input and 
returns an array denoting the start indices (1-based) of substring pattern in the string text. 

*/




import java.util.ArrayList;
import java.util.Scanner;

public class Rabin_Karp_Algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input text and pattern from the user
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();
        
        ArrayList<Integer> result = search(pattern, text);
        
        // Output the result
        System.out.println("Output: ");
        System.out.println(result);
    }

    static ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> al = new ArrayList<>();
        
        if (pattern.equals(text)) {
            al.add(1);
            return al;
        }
        
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            if (pattern.equals(text.substring(i, i + pattern.length()))) {
                al.add(i + 1);
            }
        }
        
        return al;
    }
}
