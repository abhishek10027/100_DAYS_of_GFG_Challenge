/*
Task: 
The task is to complete the function isAdditiveSequence() which takes a single string as input n and
 returns a boolean value indicating whether the given string contains an additive sequence or not.
*/

import java.util.*;
public class Additivesequence{
    public static boolean isAdditiveSequence(String n) {
        // code here
        int l=n.length();
        int num1=0;
        for(int i=0;i<l/2;i++){
            num1=num1*10+(n.charAt(i)-'0');
            int num2=0;
            for(int j=i+1;j<l-1;j++){
                num2=num2*10+(n.charAt(j)-'0');
                int p1=num1;
                int p2=num2;
                int k=j+1;
                int sum=0;
                
                while(k<l){
                    sum=sum*10+(n.charAt(k)-'0');
                    if(sum==p1+p2){
                        p1=p2;
                        p2=sum;
                        sum=0;
                    }
                    k++;
                }
                if(k==l&&sum==0) return true;
            }
        }
        return false;
    }


    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your string as number:");
        String s=sc.nextLine();
        boolean res=isAdditiveSequence(s);
        if(res==true){
            System.out.println("Output : 1 ");
        }
        else{
            System.out.println("Output : 0 ");
        }
        
    }
}
