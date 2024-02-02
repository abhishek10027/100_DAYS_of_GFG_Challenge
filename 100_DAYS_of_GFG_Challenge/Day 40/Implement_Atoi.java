/* 
Task :- 
Given a string, s, the objective is to convert it into integer format without utilizing any built-in functions. 
If the conversion is not feasible, the function should return -1.

*/

import java.util.*;

public class Implement_Atoi{
    public static int atoi(String s) {
        int neg_flag=1;
        if (s.charAt(0) == '-'){
            neg_flag = -1;
        }
       
        
        for (int i=0;i<s.length();i++) {
            if (i==0 && s.charAt(i)=='-') continue;
            if (Character.isDigit(s.charAt(i))==false) return -1;
        }
        if (neg_flag==-1) {
            s = s.substring(1,s.length());
        }
        return Integer.parseInt(s)*neg_flag;
    }


    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your String: ");
        String s=sc.nextLine();
        int res=atoi(s);
        if(res ==-1){
            System.out.println("The String conversion is not feasible");
        }
        else 
            System.out.println("The conversion is feasible and result is : "+res);

    }
}