/* 
Task:
Complete the function removeDuplicates() which takes a string str, as input parameters and returns a string denoting the answer.
*/

import java.util.*;
public class Removeallduplicatesfromagivenstring{
    static String removeDuplicates(String str) {
        String ans= "";
        for(int i = 0; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(!ans.contains(ch+""))ans+=ch;
        }
        return ans;
    }

    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your String : ");
        String str=sc.nextLine();
        System.out.println("Output : " + removeDuplicates(str));
    }
}