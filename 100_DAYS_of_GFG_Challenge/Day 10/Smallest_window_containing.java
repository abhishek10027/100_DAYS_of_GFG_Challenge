/* Complete the function smallestSubstring() which takes the string S as input, and 
returns the length of the smallest substring of string S that 
contains all the three characters 0, 1 and 2.*/

public class Smallest_window_containing{
    public static int smallestSubstring(String S) {
        // Code here
        int one=-1;
        int zero=-1;
        int two=-1;
        
        int res=10001;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='0') zero=i;
            if(S.charAt(i)=='1') one=i;
            if(S.charAt(i)=='2') two=i;
            
            if(zero==-1||one==-1||two==-1){
                continue;
            }
            
            int min=Math.min(Math.min(one,two),zero);
            int max=Math.max(Math.max(one,two),zero);
            res=Math.min(res,max-min+1);
            
            
        }
        return res==10001?-1:res;
    }

    public static void main(String args[]){
        String S = "12121";

        int res=smallestSubstring(S);

        System.out.println("The output is :=> "+" "+res);
    }
}