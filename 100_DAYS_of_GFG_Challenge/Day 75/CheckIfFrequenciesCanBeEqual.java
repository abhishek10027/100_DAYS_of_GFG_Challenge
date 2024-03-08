/* 
Task:  

Complete the function sameFreq() which takes a string as input parameter and 
returns a boolean value denoting if same frequency is possible or not.

*/



import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckIfFrequenciesCanBeEqual {
    
    boolean sameFreq(String s) {
        Map<Character,Integer> mp=new HashMap<>();
        int maxFreq=0;
        for(int i=0;i<s.length();i++) {
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
            maxFreq=Math.max(maxFreq,mp.get(s.charAt(i)));
        }
        int count=0;
        for(int i:mp.values()) {
            if(maxFreq-i>1)
                return false;
            if(maxFreq==i)
                count++;
        }
        
        if(count>1 && count<mp.size())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        CheckIfFrequenciesCanBeEqual solution = new CheckIfFrequenciesCanBeEqual();
        boolean result = solution.sameFreq(s);
        
        if(result)
            System.out.println("Output: 1");
        else
            System.out.println("Output: 0");
        
        scanner.close();
    }
}
