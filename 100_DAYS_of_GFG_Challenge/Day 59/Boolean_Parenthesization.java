/*
Task:
The task is to complete the function countWays() which takes n and s as input parameters and 
returns number of possible ways modulo 1003.

 */

import java.util.HashMap;
import java.util.Scanner;

class Pair {
    int t, f;
    int modulo = 1003;
    
    Pair (int t, int f) {
        this.t = t;
        this.f = f;
    }
    
    public void applyModulo() {
        this.t %= modulo;
        this.f %= modulo;
    }
}

public class Boolean_Parenthesization {

    static Pair rec(String s, HashMap<String, Pair> mem) {
        
        if(s.length()==0) {
            return new Pair(0, 0);
        }
        
        if(s.length()==1) {
            return s.charAt(0) == 'T' ? new Pair(1, 0) : new Pair(0, 1);
        }
        
        if(mem.containsKey(s)) {
            return mem.get(s);
        }
        
        Pair ans = new Pair(0, 0);
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '&') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.t * rightWays.t;
                ans.f += leftWays.f*rightWays.f + leftWays.t*rightWays.f + leftWays.f*rightWays.t;
            } else if(s.charAt(i) == '|') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.t*rightWays.t + leftWays.t*rightWays.f + leftWays.f*rightWays.t;
                ans.f += leftWays.f*rightWays.f;
            } else if(s.charAt(i) == '^') {
                Pair leftWays = rec(s.substring(0, i), mem);
                Pair rightWays = rec(s.substring(i+1), mem);
                
                ans.t += leftWays.f*rightWays.t + leftWays.t*rightWays.f;
                ans.f += leftWays.t*rightWays.t + leftWays.f*rightWays.f;
            }
            ans.applyModulo();
        }
        
        mem.put(s, ans);
        
        return ans;
        
    }
    
    
    static int countWays(int n, String s){
        
        HashMap<String, Pair> mem = new HashMap<>();
        
        return rec(s, mem).t;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter string s:");
        String s = scanner.nextLine();
        System.out.println("Output:");
        System.out.println(countWays(n, s));
        scanner.close();
    }
}
